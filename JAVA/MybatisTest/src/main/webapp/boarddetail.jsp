<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h3{text-align: center;}
	table{margin: auto; width: 450px;}
	.td_left{width: 150px; background: orange;}
	.td_right{width: 300px; background: skyblue;}
	#commandCell{text-align: center;}
	#content{height: 200px;}
</style>
</head>
<body>
<h3>게시판 글 상세</h3>
<table border="1">
	<tr>
		<td class="td_left"><label>글쓴이</label></td>
		<td class="td_right"><span>${board.writer }</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>제목</label></td>
		<td class="td_right"><span>${board.subject }</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>내용</label></td>
		<td class="td_right"><div id="content">${board.content}</div></td>
	</tr>
	<c:if test="${board.filenum ne null}">
	<tr>
		<td class="td_left"><label>이미지</label></td>
		<td class="td_right"><img src="image?num=${board.filenum}" width="100px"/></td>
	</tr>
	</c:if>
</table>
<div id="commandCell">
	<a href="boardmodify?num=${board.num }">수정</a>&nbsp;&nbsp;&nbsp;
	<a href="boardlist">목록</a>&nbsp;&nbsp;&nbsp;
</div>
</body>
</html>