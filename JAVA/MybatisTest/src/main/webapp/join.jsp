<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
        .header {
            text-align: center;
        }
        .container {
            margin: 0 auto;
            border: 1px solid;
            width: 330px;
            padding: 10px;
        }
</style>
<script src="http://code.jquery.com/jquery-Latest.min.js"></script>
<script>
	$(function() {
		$('#doubleId').click(function(e) {
			e.preventDefault();
			$.ajax({
				url:'memberDoubleId',
				type:'post',
				async:true,
				dataType:'text',
				data:{id:$('#id').val()},
				success:function(result) {
					if(result=='true') {
						alert("아이디가 중복됩니다.");
					} else {
						alert("사용가능한 아이디 입니다.");
					}
				},
				error:function(result) {
					
				}
				
			})
		})
		
		$("#submit").click(function(){
			var member={}
			member.id=$("#id").val();
			member.name=$("#name").val();
			member.password=$("#password").val();
			member.email=$("#email").val();
			member.address=$("#address").val();
			console.log(member);
			console.log(JSON.stringify(member));
			
			$.ajax({
				url:"join",
				type:"post",
				async:true,
				data:{member:JSON.stringify(member)},
			
				success:function(result) {
					if (result=='true') {
						location.href ="main"
					} else {
						alert(result)
					}
				},
				error:function(result) {
					alert("회원가입에 실패하였습니다.")
				}
			})
		})
	})
</script>
</head>
<body>
<jsp:include page="main.jsp"/>
<%-- <% pageContext.include("header.jsp"); %> --%>
<div class="header"><h3>회원가입</h3></div>
	<table border="1">
		<tr><th>아이디</th><td> <input type="text" name="id" id="id">&nbsp;<button id="doubleId">중복</button> </td></tr>
		<tr><th>이름</th><td> <input type="text" name="name" id="name"> </td></tr>
		<tr><th>비밀번호</th><td> <input type="password" name="password" id="password"> </td></tr>
		<tr><th>이메일</th><td> <input type="text" name="email" id="email"> </td></tr>
		<tr><th>주소</th><td> <input type="text" name="address" id="address"> </td></tr>
		<tr><td colspan="2" class="center"><button id="submit">회원가입</button></td></tr>
	</table>
</body>
</html>