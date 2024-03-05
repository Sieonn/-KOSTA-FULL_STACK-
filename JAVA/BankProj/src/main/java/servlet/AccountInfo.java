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
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountinfo")
public class AccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		RequestDispatcher dispatcher = null;
		
		if(acc==null) {
			request.setAttribute("err", "계좌번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else {
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		}
		dispatcher.forward(request, response);
		//1.request 인코딩
		//2. 파라미터 가져오기: id
		//3. 세션 얻어오기
		//4. 세션에서 id에 대항하는 계좌 가져오기
		//5. dispatcher 선언하기
		//6. 계좌가 없으면 err.jsp 페이지로 포워드(request에 에러를 담아서 보낸다.)
		//7. 계좌가 있으면 accountinfo.jsp 페이지로 포워드(request에 acc 담아서 보낸다.)
	}

}
