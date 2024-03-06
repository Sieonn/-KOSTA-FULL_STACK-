<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="page"/>
<jsp:setProperty name="user" property="name" value="hong"/>
<jsp:setProperty name="user" property="age" value="30"/>
<jsp:setProperty name="user" property="address" value="seoul"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><jsp:getProperty name="user" property="name"/></h3>
<h3><jsp:getProperty name="user" property="age"/></h3>
<h3><%=user.getAddress() %></h3>
</body>
</html>