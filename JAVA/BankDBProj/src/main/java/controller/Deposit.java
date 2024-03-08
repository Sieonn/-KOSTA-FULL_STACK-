package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

@WebServlet("/deposit")
public class Deposit extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public Deposit() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("deposit.jsp").forward(request, response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      String id=request.getParameter("id");
      int money=Integer.parseInt(request.getParameter("money"));
      try {
         AccountService accountService=new AccountServiceImpl();
         accountService.deposit(id, money);
         Account acc=accountService.accountInfo(id);
         request.setAttribute("acc", acc);
         request.getRequestDispatcher("accountinfo.jsp").forward(request, response);
      } catch(Exception e) {
         e.printStackTrace();
         request.setAttribute("err", e.getMessage());
         request.getRequestDispatcher("error.jsp");
      }
   }

}