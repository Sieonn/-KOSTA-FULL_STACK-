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

@WebServlet("/boardmodify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num=Integer.parseInt(request.getParameter("num"));
		try {
			BoardService boardService=new BoardServiceImplement();
			Board board=boardService.boardDetail(num);
			request.setAttribute("board", board);
			request.getRequestDispatcher("modifyform.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 상세 조회 실패");
			request.getRequestDispatcher("error.jps").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BoardService boardService=new BoardServiceImplement();
			boardService.boardModify(request);
			response.sendRedirect("boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 수정 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
