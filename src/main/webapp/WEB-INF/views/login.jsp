<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("input[id='btn-submit']").click(function(){
			if($("input[id='id']").val()== "" || $("input[id='id']").val() == null){
				alert("아이디를 입력해주세요.");
				return false;
			}
			if($("input[id='pw']").val()== "" || $("input[id='pw']").val() == null){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			$("form[id='form-login']").submit();	
		});
		
	});
</script>
<style type="text/css">
	tr{
		text-align: right;
	}
	html{
		height: 100%;
	}	
	body{
		display: flex;
		align-items:center;
		justify-content: center;
		height: 100%;
		flex-direction:column;
	}
	.btn-submit{
		margin-right: 10px;
	}
	.container{
		display: flex;
		align-items:center;
		justify-content: center;
		flex-direction:column; 
	}
	.btn-container{
		display: flex;
		justify-content: center;
	}
</style>
</head>
<body>
<div class="container">
	<h2> 로그인 </h2>
	<form action="login.do" method="post" id="form-login">
		<table>
			<tr>
				<td><label for="id" style="width: 100px;">ID:</label></td>
				<td><input type="text" id="id" name="memberId" ></td>
			</tr>
			<tr>
				<td><label for="pw" style="width: 100px;">PW:</label></td>
				<td><input type="password" id="pw" name="memberPw"></td>
			</tr>
		</table><br>
		<div class="btn-container">
			<input type="button" value="로그인" id="btn-submit"><input type="reset" value="취소">
		</div>
	</form>
</div>
</html>