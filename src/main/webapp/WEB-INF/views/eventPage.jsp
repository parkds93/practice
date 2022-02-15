<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
	.container{
		display: flex;
		align-items:center;
		justify-content: center;
		flex-direction:column;
	}
	#btn-logout{
		border: none;
		background-color: #00B9FF;
		border-radius: 15px;
		height:50px; 
		width: 150px;
		color: white;
		font-weight: bold;
	}
	#btn-logout:hover {
		border:#00B9FF solid 2px;
		background-color: #A5D8FA;
	}
	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<title>이벤츠 추첨 Page</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
			$("a[id='btn-submit']").click(function(){
				let eventCode = $(this).data("eventcode");
				let data = {"eventCode" : eventCode};
				$.ajax({
					type:"post",
					url:"eventApply.do",
					data: data,
					dataType: "json",
					success:function(data){
						if(data.result == "duplication"){
							alert("이미 응모하셨어요~");
						}else{
							alert("응모되었습니다~");	
						}	
					}
				});
			});

		$("input[id='btn-logout']").click(function(){
			location.href="logout.do";
		});
		
		
	});
</script>

<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="today"/>
	<div class="container" style="border: 1px solid black; border-radius: 20px; height: 80%">
		<h2>이벤트 추첨</h2>
		${memberId}님이 접속했어요~<br><br>
		<div class="eventButton">
		<c:forEach items="${eList}" var="event" varStatus="status">
			<a class="btn btn-primary" href="#" role="button" id="btn-submit" data-eventcode="${event.eventCode }" style="width:200px; margin: 5px;">${event.eventName}</a>
			<h5 style="display: inline;">이벤트 기간 : 
			<fmt:formatDate value="${event.eventDate}" pattern="yyyy-MM-dd" />~
			<fmt:formatDate value="${event.eventEndDate}" pattern="yyyy-MM-dd" /></h5><br>
		</c:forEach>
		</div>
		
		<input type="button" id="btn-logout" value="Logout" style="margin-top: 30px;">
	</div>
</body>
</html>