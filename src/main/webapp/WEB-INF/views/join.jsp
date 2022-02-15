<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
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
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn-login').click(function(){
			location.href="login.do";
		})
	});
</script>
</head>
<body>
<div class="container">
	<h2> 회원가입 </h2>
	<form action="join.do" method="post">
		<table>
			<tr>
				<td><label for="id" style="width: 100px;">ID:</label></td>
				<td><input type="text" id="id" name="memberId" ></td>
			</tr>
			<tr>
				<td><label for="name" style="width: 100px;">NAME:</label></td>
				<td><input type="text" id="name" name="memberName"></td>
			</tr>
			<tr>
				<td><label for="pw" style="width: 100px;">PW:</label></td>
				<td><input type="password" id="pw" name="memberPw"></td>
			</tr>
			<tr>
				<td><label for="phone" style="width: 100px;">PHONE:</label></td>
				<td><input type="text" id="phone" name="memberPhone"></td>
			</tr>
		</table><br>
		<div class="btn-container">
			<c:if test="${result == 1}">
				<h3 style="color: blue;">회원가입에 성공했습니다.</h3>
			</c:if>
			<input type="submit" value="회원가입" class="btn-submit"><input type="reset" value="취소">
			<input type="button" value="로그인" id="btn-login">
		</div>
	</form>
</div>
</body>
</html>