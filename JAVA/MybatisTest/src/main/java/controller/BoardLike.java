package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;

import service.BoardLikeService;

/**
 * Servlet implementation class BoardLike
 */
@WebServlet("/boardlike")
public class BoardLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonParam = request.getParameter("like");
		JSONParser parser = new JSONParser();
		try {
			JSONObject jobj = (JSONObject)parser.parse(jsonParam);
			String memberId = (String)jobj.get("memberId");
			String boardNum = (String)jobj.get("boardNum");
			BoardLikeService boardLikeService.togleBoardLikeServiceImpl();
			boolean like = boardLikeService.togleBoardLike(memberId,Integer.parseInt(boardNum));
			response.getWriter().write(String.valueOf(like));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void togleBoardLikeServiceImpl() {
		// TODO Auto-generated method stub
		
	}

}
