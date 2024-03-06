<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포워드 액션 테스트</h2>
	<form action="forwardTest1.jsp" method="post">
		<input type="hidden" name="forwardpage" value="forwardTest2.jsp">
		<input type="hidden" name="includepage" value="forwardTest2.jsp">
		<table border="1">
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td>기타등등</td>
				<td><input type="text" name="etc"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>