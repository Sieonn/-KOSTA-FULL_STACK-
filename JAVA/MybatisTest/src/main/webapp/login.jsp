<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieHeader = request.getHeader("Cookie");
	Boolean autologin = false;
	String id = "";
	String password = "";
	if(cookieHeader!=null) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("autologin")) {
				if(cookie.getValue().equals("true"))
					autologin = true;	
				else 
					autologin = false;
			} else if(cookie.getName().equals("id")) {
				id = cookie.getValue();
			} else if(cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
        .center {
            text-align: center;
        }
        .container {
            margin: 0 auto;
            border: 1px solid;
            width: 280px;
            padding: 10px;
        }</style>
</head>
<body>
<jsp:include page="main.jsp"/>
<div class="center"><h3>로그인</h3></div>
<form action="login" method="post">
	<table border="1" class="container">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value='<%=id%>'/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="password" value="<%=password%>"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<%if(autologin) { %>
				<input type="checkbox" value="true" name="autologin" checked="checked"/>자동로그인
			<%} else { %>
				<input type="checkbox" value="true" name="autologin"/>자동로그인
			<%} %>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center"><input type="submit" value="로그인"/></td>
		</tr>
	</table>
</form>
</body>
</html>