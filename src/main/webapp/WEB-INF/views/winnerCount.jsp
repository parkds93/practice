<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
</head>
<style type="text/css">
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
	#container{
		border:solid 1px black;
		padding: 20px;
		border-radius: 20px;
	}
	
	#content{
		display: flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
	}
</style>
<script type="text/javascript">
	opener.window.name = 'Parent_window';
	
	$(document).ready(function(){
		$("#btn-close").click(function(){
			self.close();
		});
		$("#btn-draw").click(function(){
			var total 		= Number($("#first").val())+Number($("#second").val())+Number($("#third").val())+Number($("#fourth").val());
			var eventCount	=${eventCount};
 			
 			if(total > eventCount){
 				alert("당첨자 수가 응모자보다 많아요");
 				return false;
 			}
 			
			$("#frm").submit();
			self.close();
		});
	});
</script>
<body>
	<div id="container">
		<form action="draw.do" target="Parent_window" id="frm">
			<div id="content">
				<input type="hidden" name="eventCode" value="${event.eventCode}">
				<h2>${event.eventName } 당첨자 추첨하기</h2>
				<h3>총 응모자 수 : ${eventCount }</h3>
				<div>
					<label for="first">	1등 : </label><input type="text" id="first" name="first"><br>
					<label for="second">2등 : </label><input type="text" id="second" name="second"><br>
					<label for="third">	3등 : </label><input type="text" id="third" name="third"><br>
					<label for="fourth">4등 : </label><input type="text" id="fourth" name="fourth"><br>
				</div><br>
				<div>
					<input type="button" id="btn-draw" value="추첨하기">
					<input type="button" value="창닫기" id="btn-close">
				</div>
			</div>
		</form>
	</div>
</body>
</html>