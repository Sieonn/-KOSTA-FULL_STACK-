package service;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImplement;
import dto.Board;
import dto.File;
import util.PageInfo;

public class BoardServiceImplement implements BoardService {

	private BoardDAO boardDAO;

	public BoardServiceImplement() {
		boardDAO = new BoardDAOImplement();
	}

	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
		Board board = new Board();
		// 파일업로드
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8",
				new FileRenamePolicy() {
			@Override
			public java.io.File rename(java.io.File file) {
				dto.File uploadFile = new dto.File();
				try {
					uploadFile.setDirectory(uploadPath);
					uploadFile.setName(file.getName());
					uploadFile.setSize(file.length());
					boardDAO.insertFile(uploadFile);
					board.setFilenum(uploadFile.getNum());
				} catch(Exception e) {
					e.printStackTrace();
				}
				java.io.File f=new java.io.File(file.getParent(),uploadFile.getNum()+"");
				return f;
			}
		});
		// 파일업로드 끝

		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		
		board.setSubject(subject);
		board.setContent(content);
		board.setWriter(writer);
		boardDAO.insertDAO(board);
	}

	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		Integer page=Integer.parseInt(request.getParameter("page"));
		
		int boardCount=boardDAO.selectBoardCount();
		int maxPage=(int)Math.ceil((double)boardCount/10);
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setCurPage(page);
		pageInfo.setAllPage(maxPage);
		
	}
}
