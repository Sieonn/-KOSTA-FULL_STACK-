<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.header {
	text-align: center;
}

.container {
	margin: 0 auto;
	border: 1px solid;
	width: 310px;
	padding: 10px;
}

.row {
	height: 30px;
}

.title {
	float: left;
	width: 70px;
	text-align: center;
	font-weight: bold;
}

.input {
	float: left;
}

input[type='submit'] {
	font-weight: bold;
	width: 120px;
	background-color: lightgray;
	display: block;
	margin: 0 auto;
}
</style>
<script>
        window.onload = function() {
            let select = document.querySelector("#grade");
            let types = document.querySelectorAll("input[name='type']");
            for(type of types) {
                type.onclick = function() {
                    if(this.checked && this.value=='special') {
                        select.disabled = false;
                    } else {
                        select.disabled = true;
                    }
                }
            }
        }
    </script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    	$(function() {
    		$('#doubldId').click(function(e) {
    			e.preventDefault();
    			$.ajax({
    				url:'accountDoubleId',
    				type:'post',
    				async:true,
    				dataType:'text',
    				data:{id:$('#id').val()},
    				success:function(result) {
						if(result=="true") {
							alert("사용중인 계좌번호입니다")
						} else {
							alert("사용 가능한 계좌번호입니다")
						}    					
    				},
    				error: function(result) {
    					
    				}
    			})
    		})
    		
    		$('#submit').click(function(e) {
    			var acc = {};
    			acc.id = $('#id').val();
    			acc.name = $('#name').val();
    			acc.balance = $('#balance').val();
    			acc.type = $('input[type="radio"]:checked').val();
    			if(acc.type=='special') {
    				acc.grade=$('#grade').val();
    			} else {
    				acc.grade=null;
    			}
    			console.log(acc);
    			console.log(JSON.stringify(acc));
    			
    			$.ajax({
    				url:'makeaccount',
    				type:'post',
    				async:true,
    				data:{acc:JSON.stringify(acc)},
    				success:function(result) {
    					alert(result);
    					$('#id').val("");
    					$('#name').val("");
    					$('#balance').val("");
    				},
    				error:function(err){
    				alert("계좌가 개설되지 않았습니다. ");
    				}
    				})
    		})	
    	})
    </script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="header">
		<h3>계좌개설</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="title">계좌번호</div>
			<div class="input">
				<input type="text" name="id" id="id">&nbsp;
				<button id="doubldId">중복</button>
			</div>
		</div>
		<div class="row">
			<div class="title">이름</div>
			<div class="input">
				<input type="text" name="name" id="name">
			</div>
		</div>
		<div class="row">
			<div class="title">입금액</div>
			<div class="input">
				<input type="text" name="balance" id="balance">
			</div>
		</div>
		<div class="row">
			<div class="title">종류</div>
			<div class="input">
				<input type="radio" name="type" checked value="normal">일반 <input
					type="radio" name="type" value="special">특수
			</div>
		</div>
		<div class="row">
			<div class="title">등급</div>
			<div class="input">
				<select name="grade" id="grade" disabled>
					<option>선택</option>
					<option value="VIP">VIP</option>
					<option value="Gold">Gold</option>
					<option value="Silver">Silver</option>
					<option value="Normal">Normal</option>
				</select>
			</div>
		</div>
		<div class="button">
			<button id="submit">개설</button>
		</div>
	</div>
</body>
</html>