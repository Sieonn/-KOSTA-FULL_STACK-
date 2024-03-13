package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.BoardServiceImplement;

@WebServlet("/boardlist")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BoardService boardService=new BoardServiceImplement();
			boardService.boardListByPage(request);
			request.getRequestDispatcher("boardlist.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 목록 조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
