<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-16LE"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>config 테스트</h2>
	<table border="1">
		<tr>
			<td>초기 파라미터 이름</td>
			<td>초기 파이미터 값</td>
		</tr>
		<%
		Enumeration e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String initParamName = (String)e.nextElement();
		%>
		<tr>
			<td><%=initParamName%></td>
			<td><%=config.getInitParameter(initParamName)%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>