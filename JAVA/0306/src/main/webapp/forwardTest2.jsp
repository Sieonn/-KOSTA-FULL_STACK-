<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h2>포워드된 페이지</h2>
	<table>
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=request.getParameter("age")%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=request.getParameter("address")%></td>
		</tr>
	</table>
	<jsp:include page='<%=request.getParameter("includePage") %>'></jsp:include>
</body>
</html>