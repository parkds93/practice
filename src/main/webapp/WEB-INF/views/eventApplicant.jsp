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
<title>응모자 확인</title>
</head>
<script type="text/javascript">

	
	$(document).ready(function(){
/* 		$("a[id='btn-draw']").click(function(){
			location.href="draw.do";
		}); */
		var currentEventCode = ${eventCode};
		$("#eventCode").val(currentEventCode).attr("selected","selected");
		
		$("a[id='btn-logout']").click(function(){
			location.href="logout.do";
		});
		
 		$("#btn-draw").click(function(){
 			var eventCode	=$("#eventCode").val();
 			window.open("winnerCount.do?eventCode="+eventCode, "number of winners", "width=400, height=300, left=100, top=50");
 		});
 		
 		$("#eventCode").change(function(){
 			var eventCode=$("#eventCode").val();
 			location.href="eventApplicant.do?eventCode="+eventCode;
 		});
	});
	
</script>
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
	<div class="admin-container" style="display:flex; flex-direction:column; align-items:center; justify-content:center;  width: 80%; height: 100%;">
		<div style="display:flex; align-items:center;  flex-direction: column; width: 100%;">
		<h2>응모현황</h2>
			<select name="eventCode" id="eventCode">
				<c:forEach items="${eventList}" var="event">
					<option value="${event.eventCode}">${event.eventName}</option>
				</c:forEach>
			</select>
		</div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">응모자ID</th>
		      <th scope="col">이름</th>
		      <th scope="col">전화번호</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${applicantList}" var="applicant">
				<tr scope="row">
					<td>${applicant.memberId}</td>
					<td>${applicant.memberName}</td>
					<td>${applicant.memberPhone}</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		<div>
		<a class="btn btn-primary" href="#" role="button" id="btn-draw">추첨하기</a>
		<a class="btn btn-primary" href="#" role="button" id="btn-logout">로그아웃</a>
		</div>
	</div>
</body>
</html>