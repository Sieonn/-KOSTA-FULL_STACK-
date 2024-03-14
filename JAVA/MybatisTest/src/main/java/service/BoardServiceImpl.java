package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.BFile;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO = new BoardDAOImpl();
	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		
		// 1.페이지 가져오고 없으면 페이지번호를 1로 한다.
		Integer page = 1;
		String pageNo = request.getParameter("page");
		if(pageNo != null) {
			page = Integer.parseInt(pageNo);
		}
		
		// 2. PageInfo 계산하여 설정
		int maxPage = (int)Math.ceil((double)boardDAO.selectBoardCount()/10);
		// 2-1 1, 11, 21, 31, ....
		int startPage = (page-1)/10*10+1;
		// (page)/10*10+1; 이것은 10일 때가 걸리므로 안됨
		int endPage = startPage+10-1;
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		// 3. 해당 페이지에 해당하는 게시판 글목록 조회 (1번째가 0)
		int row = (page-1)*10;
		List<Board> boardList = boardDAO.selectBoardList(row);
		
		// 4. 응답으로 보내기 위해 request영역에 담는다
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("boardList", boardList);
	}
	@Override
	public Board boardDetail(Integer num) throws Exception {
		boardDAO.updateBoardViewCount(num);
		return boardDAO.selectBoard(num);
	}
	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
		
		Board board = new Board();
		
		// 1. 파일업로드
		// 1-1. 업로드할 경로 설정 및 최대크기 설정
		String path = request.getServletContext().getRealPath("upload");
		int size = 10 * 1024 * 1024;
		// 1-2. 설정한 경로에 파일 업로드
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8",new DefaultFileRenamePolicy());
		
		// 2. 업로드 파일이 있는 경우
		File file = multi.getFile("file");
		if (file != null) {
		// 2-1. 파일정보를 DB 객체에 담아 파일테이블에 삽입
			BFile bfile = new BFile();
			bfile.setDirectory(path);
			bfile.setContenttype(multi.getContentType("file"));
			bfile.setName(multi.getFilesystemName("file"));
			bfile.setSize(file.length());
			boardDAO.insertFile(bfile);
		
		// 2-2. 파일테이블에서 자동생성된 파일번호로 업로드한 파일이름 변경
			File uploadFile = new File(path, file.getName());
			uploadFile.renameTo(new File(path,bfile.getNum()+""));
		// 2-3. 파일테이블에서 자동생성된 파일번호를 Board의 파일번호 셋팅 
			board.setFilenum(bfile.getNum());
		}
		
		// 3. 파일테이블에서 자동생성된 파일번호를 업로드한 파일이름 변경
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		boardDAO.insertBoard(board);
		
		
		
	}
	@Override
	public void boardModify(HttpServletRequest request) throws Exception {
		Board board = new Board();
		// 1. 파일 업로드
		String path = request.getServletContext().getRealPath("upload");
		int size = 10 * 1024 * 1024;  //10 메가
		
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		// 2. 업로드 파일이 있으면
		File file = multi.getFile("file");  //jsp의 파일
		if (file != null) {
		// 2-1. 파일정보 모아모아 BFile 객체 생성하여 파일 테이블에 삽입
			BFile bfile = new BFile();
			bfile.setDirectory(path);
			bfile.setName(file.getName());
			bfile.setContenttype(multi.getContentType("file"));
			bfile.setSize(file.length());
			boardDAO.insertFile(bfile);
		// 2-2. 저장된 파일번호로 업로드한 파일명 변경
			File uploadFile =new File(path, bfile.getName());
			uploadFile.renameTo(new File(path, bfile.getNum()+""));
		// 2-3. 저장된 파일번호로 Board의 파일번호 셋팅  -> board는 미리 생성해둔다
			board.setFilenum(bfile.getNum());
		}
		// 3. 수정된 Board 정보를 파라미터에서 가져다가 Board 객체 생성하여 Board 테이블에 갱신
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		System.out.println(board.getNum());
		System.out.println(board.getSubject());
		boardDAO.updateBoard(board);
	}

	
	
}
