<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYP reE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select id="./writeForm">
		<h2>게시판 글수정</h2>
		<form action="boardmodify" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${board.num }" />
			<table>
				<tr>
					<td class="td_left"><label for="writer">글쓴이</label></td>
					<td class="td_right"><input type="text" name="write"
						id="writer" readonly="readonly" value="${board.writer }" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for=subject>글쓴이</label></td>
					<td class="td_right"><input type="text" name="subject"
						id="subject" required="required" value="${board.subject }" /></td>
				</tr>
			</table>
		</form>
	</select>
</body>
</html>