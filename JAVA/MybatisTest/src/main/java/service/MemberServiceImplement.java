package service;

import java.io.File;
import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import dao.MemberDao;
import dao.MemberDaoImplement;
import dto.BFile;
import dto.Board;
import util.PageInfo;

public class MemberServiceImplement implements MemberService {
	private MemberDao memberDao=new MemberDaoImplement();
	
	public void MemberListByPage(HttpServletRequest request) throws Exception {
		//1. 페이지를 가져오고 없으면 페이지번호를 1로 한다.
		Integer page=1;
		String pageNo=request.getParameter("page");
		if(pageNo!=null) {
			page=Integer.parseInt(pageNo);
		}
		
		//2. PageInfo 계산하여 설정하기
		int maxPage=(int)Math.ceil((double)memberDao.selectMemberCount()/10);
		int startPage=(page-1)/10*10+1; //페이지 10을 고려하여 page-1을 한다.
		int endPage=startPage+10-1;
		if(endPage>maxPage) endPage=maxPage;
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		//3.해당 페이지에 해당하는 게시판 글 목록 조회
		int row=(page-1)*10;
		List<Member> memberList=memberDao.selectMemberList(row);
		
		//4.응답으로 보내기 위해 request영역에 담는다
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", memberList);
	}

	public Board memberDetail(Integer num) throws Exception {
		memberDao.updateMemberViewCount(num);
		return memberDao.selectMember(num);
	}

	public void memberWrite(HttpServletRequest request) throws Exception {
		Member member=new Member();
		//1-1. 업로드할 경로 설정
		String path=request.getServletContext().getRealPath("upload");
		int size=10*1024*1024;
		//1-2. 설정한 경로에 파일 업로드
		MultipartRequest multi=new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		//2. 업로드 파일이 있을경우
		File file=multi.getFile("file");
		if(file!=null) {
			//2-1. 파일정보를 BFile 객체에 담아 file 테이블에 삽입
			BFile bFile=new BFile();
			bFile.setDirectory(path);
			bFile.setContenttype(multi.getContentType("file"));
			bFile.setName(file.getName());
			bFile.setSize(file.length());
			memberDao.insertFile(bFile);
			//2-2. 파일테이블에서 자동생성된 파일번호로 업로드한 파일 변경
			File uploadFile=new File(path,file.getName());
			uploadFile.renameTo(new File(path, bFile.getNum()+""));
			//2-3. Board의 파일번호 셋팅
			member.setFilenum(bFile.getNum());
		}
		
		//3. 파라미터에서 파일 이외의 정보 가져와 Board 객체에 담아 Board 테이블에 삽입
		member.setSubject(multi.getParameter("subject"));
		member.setContent(multi.getParameter("content"));
		member.setWriter(multi.getParameter("writer"));
		memberDao.insertBoard(member);
	}

	public void memberModify(HttpServletRequest request) throws Exception {
		Board board=new Board();
		//1. 파일 업로드
		//1-1. 업로드할 경로 설정
		String path=request.getServletContext().getRealPath("upload");
		int size=10*1024*1024;
		//1-2. 설정한 경로에 파일 업로드
		MultipartRequest multi=new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		//2. 업로드 파일이 있을경우
		File file=multi.getFile("file");
		if(file!=null) {
			//2-1. 파일정보 모아모아 BFile 객체 생성하여 파일 테이블에 삽입
			BFile bFile=new BFile();
			bFile.setDirectory(path);
			bFile.setContenttype(multi.getContentType("file"));
			bFile.setName(file.getName());
			bFile.setSize(file.length());
			memberDao.insertFile(bFile);
			//2-2. 저장된 파일번호로 업로드한 파일의 변경
			File uploadFile=new File(path, file.getName());
			uploadFile.renameTo(new File(path, bFile.getNum()+""));
			//2-3. 저장된 파일번호로 Board의 파일번호 셋팅
			board.setFilenum(bFile.getNum());
		}
		//3. 수정된 Board 정보를 파라미터에서 가져다가 Board 객체 생성하여 Board 테이블 갱신
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		memberDao.updateMember(member);
	}


}

