<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인클루드 액션 테스트</h2>
<jsp:include page="includeTest1.jsp">
<jsp:param value ="hongsildong" name="name"/>
<jsp:param value ="30" name="age"/>
</jsp:include>
<h3>서울시 금천구</h3>
</body>
</html>