<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Insert title here</title>
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
<div style="height: 100%; width: 100%;">
	<table class="table">
		<tr>
			<th scope="col">이벤트 명</th>
			<th scope="col">이벤트 내용</th>
			<th scope="col">이벤트 시작일</th>
			<th scope="col">이벤트 종료일</th>
			<th scope="col">당첨자 추첨여부</th>
		</tr>
		<c:forEach items="${eventList}" var="event"> 
			<tr>
				<td scope="col">${event.eventName}</td>
				<td scope="col">${event.eventDetail}</td>
				<td scope="col"><fmt:formatDate value="${event.eventDate}" pattern="yyyy-MM-dd"/></td>
				<td scope="col"><fmt:formatDate value="${event.eventEndDate}" pattern="yyyy-MM-dd"/></td>
				<td scope="col">${event.winnerYn}</td>
			<tr>
		</c:forEach>
	</table>
		<ul class="pagination" id="pagination">
			<c:if test="${pg.startPage > pg.pageBlock }">
				<li><a href="eventList.do?currentPage=${pg.startPage-pg.pageBlock}">이전</a></li>
			</c:if>
			<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
				<li id="pageNum"><a href="eventList.do?currentPage=${i}">[${i}]</a></li>
			</c:forEach>
			<c:if test="${pg.endPage < pg.totalPage }">
				<li><a href="eventList.do?currentPage=${pg.startPage+pg.pageBlock}">다음</a></li>
			</c:if>
		</ul>
</div>
</body>
</html>