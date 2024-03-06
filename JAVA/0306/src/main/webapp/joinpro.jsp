<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="bean.User" scope="page" />
<jsp:setProperty name="user" property="*"/>
<%-- <jsp:useBean id="user" class="bean.User" scope="page" />
<jsp:setProperty name="user" property="name" param="name" />
<jsp:setProperty name="user" property="id" param="id" />
<jsp:setProperty name="user" property="address" param="address" />
<jsp:setProperty name="user" property="email" param="email" />
<jsp:setProperty name="user" property="password" param="password" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><jsp:getProperty name="user" property="id" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><jsp:getProperty name="user" property="name" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><jsp:getProperty name="user" property="password" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><jsp:getProperty name="user" property="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><jsp:getProperty name="user" property="address" /></td>
		</tr>
	</table>

</body>
</html>