<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String user = (String) session.getAttribute("user");
%>
<style>
   a {text-decoration:none; margin-left:10px; margin-right:10px;}
</style>    
<div style="width:100%;height:120px;background-color:navajowhite;padding:5px">
   <h1 style="text-align:center"><i>kosta bank</i></h1>
   <div style="float:left;">
      <a href="makeaccount.jsp">계좌개설</a>
      <a href="deposit.jsp">입금</a>
      <a href="withdraw.jsp">출금</a>
      <a href="accountinfoform.jsp">계좌조회</a>
      <a href="allaccountinfo.jsp">전체계좌조회</a>
      <a href="transfer.jsp">계좌이체</a>
   </div>
   <div style="float:right;">
      <%if(user == null) {%>
         <a href="login.jsp">로그인</a>
      <%} else {%>      
      <%=user %>님 환영합니다&nbsp;&nbsp;
         <a href="logout">로그아웃</a>
      <%} %>
         <a href="join.jsp">회원가입</a>
   </div>

</div>    