<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h3 {text-align: center;}
	table{margin: auto; width: 800px;}
	#tr_top{background: orange; text-align: center;}
	#emptyArea{margin: auto; width: 800px; text-align: center};
	#emptyArea a{
		display: inline-block;
		width: 20px;
		height: 20px;
		text-decoration: none;
	}
</style>
</head>
<body>
<h3>글 목록</h3>
<table>	
	<tr id="tr_top">
		<th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th><th>삭제</th>
		<c:forEach items="${boardList  }" var = "board">
		<tr><td>${board.num }</td>
		<td><a href = "boarddetail?num=${board.num }">${board.subject }</a></td>
		<td>${board.writer}</td>
		<td>${board.writedate}</td>
		<td>${board.viewcount}</td>
		</tr>
		</c:forEach>
	</tr>
</table>
<div id="emptyArea">
	<a>&lt;</a>
	<c:forEach begin="1" end="10" var="i">
		<a href="#">${i}</a>
	</c:forEach>
	<a>&gt;</a>
</div>
</body>
</html>