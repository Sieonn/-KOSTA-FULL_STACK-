<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.include("pageContext3.jsp");
	%>
	<h2>pageContext2의 forward 메소드로 포워딩된 페이지 입니다.</h2>
	<table border="1">
		<tr>
			<td>이메일</td>
			<td><%=request.getParameter("email")%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=request.getParameter("address")%></td>
		</tr>
	</table>
</body>
</html>