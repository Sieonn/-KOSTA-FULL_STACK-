package controller;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllAccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("allaccountinfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			AccountService accountService = new AccountServiceImpl();
			List<Account> accs = accountService.allAccountInfo();
			JSONArray jaccs = new JSONArray();
			for (Account acc : accs) {
				JSONObject jacc = new JSONObject();
				jacc.put("id", acc.getId());
				jacc.put("name", acc.getName());
				jacc.put("balance", acc.getBalance());
				jacc.put("type", acc.getType());
				jacc.put("grade", acc.getGrade());
				jaccs.add(jacc);
//			Console.log()
			}
			response.getWriter().write(jaccs.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}