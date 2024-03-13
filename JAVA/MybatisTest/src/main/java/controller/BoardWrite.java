package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import service.BoardServiceImplement;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/boardwrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("writeform.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			BoardService boardService=new BoardServiceImplement();
			boardService.boardWrite(request);
			response.sendRedirect("boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 작성 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
