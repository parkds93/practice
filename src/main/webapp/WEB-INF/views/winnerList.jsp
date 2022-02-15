<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQuery -->
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	html{
		height: 100%;
		width: 100%;
	}	
	body{
		display: flex;
		align-items:center;
		justify-content: center;
		width: 100%;
		height: 100%;
		flex-direction:column;
	}
	li{
		list-style-type: none;
	}
	a {
	  text-align: center;
	  text-decoration: none; /* 링크의 밑줄 제거 */
	  color: inherit; /* 링크의 색상 제거 */
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#eventCode").val(${eventCode}).attr("selected","selected");
		
		$("#eventCode").change(function(){
			var eventCode=$("#eventCode").val();
			location.href="winnerList.do?eventCode="+eventCode;
		});	
	});
	
</script>
</head>
<body>
<div class="header" style="background-color:#00B9FF; color:white; display:flex; justify-content:center; align-items:center; flex-direction:column; width: 100%;  height:15%;">
		<h2 style="font-weight: bold;">관리자페이지</h2>
		<ul style="display: flex;font-weight: bold;">
			<li><a href="eventRegister.do">| 이벤트 등록 |</a></li>
			<li><a href="eventList.do">&nbsp;이벤트 목록 |</a></li>
			<li><a href="eventApplicant.do">&nbsp;당첨자 추첨 |</a></li>
			<li><a href="winnerList.do">&nbsp;당첨자 목록 |</a></li>
		</ul>
</div>
<div class="winner-container" style="display:flex;width: 80%;height: 100%;justify-content: center;align-items: center;flex-direction: column;">
	<h2>${eventCode}번째 이벤트 당첨자!</h2>
	<div style="width:100%; display: flex; align-items: flex-end; flex-direction: column; al">
		<select name="eventCode" id="eventCode" style="width: 200px;">
			<c:forEach items="${eventList}" var="event">
				<option value="${event.eventCode}">${event.eventName}</option>
			</c:forEach>
		</select>
		<a class="btn btn-primary" href="#" role="button" id="btn-submit" style="margin-top: 5px;">당첨자목록 다운</a>
	</div>
	
	<table class="table">
		<tr>
			<th scope="col">등수</th>
			<th scope="col">ID</th>
			<th scope="col">이름</th>
			<th scope="col">전화번호</th>
		</tr>
		<c:forEach items="${winnerList}" var="winnerInfo">
			<tr scope="row"> 
				<td>${winnerInfo.goods}</td>
				<td>${winnerInfo.memberId}</td>
				<td>${winnerInfo.memberName}</td>
				<td>${winnerInfo.memberPhone}</td>
			</tr>
		</c:forEach>		
	</table>
</div>
</body>
</html>