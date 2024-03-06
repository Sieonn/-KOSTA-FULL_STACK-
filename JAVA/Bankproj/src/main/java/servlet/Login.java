package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(id);
		if (member == null) { // id error
			request.setAttribute("err", "아이디가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else if (member.getPassword().equals(password) == false) { // password error
			request.setAttribute("err", "비밀번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else { // success : session에 사용자 정보 저장
			session.setAttribute("user", member.getId());
			dispatcher = request.getRequestDispatcher("makeaccount.jsp");
		}
		dispatcher.forward(request, response);
	}

}