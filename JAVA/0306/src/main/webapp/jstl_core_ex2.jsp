<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="bean.User"%>
<%
List<User> users = new ArrayList<>();
users.add(new User("hong", "홍길동", "1234", "hong@kosta.com", "서울시 금천구"));
users.add(new User("song", "송길동", "1234", "song@kosta.com", "서울시 영등포구"));
users.add(new User("Kong", "공길동", "1234", "kong@kosta.com", "서울시 강서구"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 비긴부터 엔드까지 step씩 증가 -->
	<c:forEach var="test" begin="1" end="10" step="2">
		<b>${test}</b>&nbsp;
		</c:forEach>
	<br>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>

			<c:forEach var="user" items="<%=users%>" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.password }</td>
					<td>${user.email }</td>
					<td>${user.address }</td>
				</tr>
			</c:forEach>
	</table>
	<c:forTokens items="홍길동, 김길동, 고길동, 하길동, 송길동" delims="," var="name">
		<b>${name}</b>&nbsp;

</c:forTokens>
	<br>
	<c:set var="fruitList" value="applie,banana,orange,strawberry" />
	<c:forTokens items="${fruitList }" delims="," var="fruit">
		<b>${fruit}</b>&nbsp;
		</c:forTokens>
</body>
</html>