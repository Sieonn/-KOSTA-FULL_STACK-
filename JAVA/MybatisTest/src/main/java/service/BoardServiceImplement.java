package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.BoardDaoImplement;
import dto.BFile;
import dto.Board;
import util.PageInfo;

public class BoardServiceImplement implements BoardService {
	private BoardDao boardDao=new BoardDaoImplement();
	
	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		//1. 페이지를 가져오고 없으면 페이지번호를 1로 한다.
		Integer page=1;
		String pageNo=request.getParameter("page");
		if(pageNo!=null) {
			page=Integer.parseInt(pageNo);
		}
		
		//2. PageInfo 계산하여 설정하기
		int maxPage=(int)Math.ceil((double)boardDao.selectBoardCount()/10);
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
		List<Board> boardList=boardDao.selectBoardList(row);
		
		//4.응답으로 보내기 위해 request영역에 담는다
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", boardList);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		boardDao.updateBoardViewCount(num);
		return boardDao.selectBoard(num);
	}

	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
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
			//2-1. 파일정보를 BFile 객체에 담아 file 테이블에 삽입
			BFile bFile=new BFile();
			bFile.setDirectory(path);
			bFile.setContenttype(multi.getContentType("file"));
			bFile.setName(file.getName());
			bFile.setSize(file.length());
			boardDao.insertFile(bFile);
			//2-2. 파일테이블에서 자동생성된 파일번호로 업로드한 파일 변경
			File uploadFile=new File(path,file.getName());
			uploadFile.renameTo(new File(path, bFile.getNum()+""));
			//2-3. Board의 파일번호 셋팅
			board.setFilenum(bFile.getNum());
		}
		
		//3. 파라미터에서 파일 이외의 정보 가져와 Board 객체에 담아 Board 테이블에 삽입
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		boardDao.insertBoard(board);
	}

	@Override
	public void boardModify(HttpServletRequest request) throws Exception {
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
			boardDao.insertFile(bFile);
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
		boardDao.updateBoard(board);
	}


}
