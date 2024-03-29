package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Account;

/**
 * Servlet implementation class MakeAccountProc
 */
@WebServlet("/makeaccount")
public class MakeAccountProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeAccountProc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");

		Account acc = new Account(id, name, balance, type, grade);
		HttpSession session = request.getSession();
		session.setAttribute(id, acc);

		request.setAttribute("acc", acc);
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("makeaccount.jsp").forward(request, response);
	}
}
