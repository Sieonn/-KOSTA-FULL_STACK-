<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String cookieHeader = request.getHeader("Cookie");
Boolean autologin = false;
String id = "";
String password = "";
if (cookieHeader != null) {
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("autologin")) {
	if (cookie.getValue().equals("true"))
		autologin = true;
	else
		autologin = false;
		} else if (cookie.getName().equals("id")) {
	id = cookie.getValue();
		} else if (cookie.getName().equals("password")) {
	password = cookie.getValue();
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.center {
	text-align: center;
}

.container {
	margin: 0 auto;
	border: 1px solid;
	width: 280px;
	padding: 10px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$("#submit").click(function() {
			var login = {}
			login.id = $("#id").val();
			login.password= $("#password").val();
			login.autologin = $("autologin").is(":checked");
			console.log(login);
			$.ajax({
				url : "login",
				type : "post",
				async : true,
				data : {
					login : JSON.stringify(login)
				},
				success : function(result) {
					if(result=='true'){
					location.href  = "main";
					}else {
						alert(result)
					}
				},
				error : function(err) {
					alert("로그인에 실패했습니다.")
				}
			})
		})
	})
</script>
</head>
<body>
	<%
	pageContext.include("header.jsp");
	%>
	<div class="center">
		<h3>로그인</h3>
	</div>

	<table border="1" class="container">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value='<%=id%>' id="id" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="password" value="<%=password%>"
				id="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<%
				if (autologin) {
				%> <input type="checkbox" value="true"
				name="autologin" checked="checked" />자동로그인 <%
 } else {
 %> <input
				type="checkbox" value="false" name="autologin" />자동로그인 <%
 }
 %>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center"><button id="submit">로그인</button></td>
		</tr>
	</table>
</body>
</html>