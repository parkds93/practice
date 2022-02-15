<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQuery -->
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/datePicker.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
html {
	height: 100%;
	width: 100%;
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
	width: 100%;
	height: 100%;
	flex-direction: column;
}

li {
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
		$("#datePicker").datepicker({
		    onSelect: function(dateText) {
		       alert(dateText);
		       $("#datePicker1").datepicker();
		       $("#datePicker1").attr("disabled",false);
		       $("#datePicker1").datepicker("option", "minDate", dateText);
		    }
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="header"
		style="background-color: #00B9FF; color: white; display: flex; justify-content: center; align-items: center; flex-direction: column; width: 100%; height: 15%;">
		<h2 style="font-weight: bold;">관리자페이지</h2>
		<ul style="display: flex; font-weight: bold;">
			<li><a href="eventRegister.do">| 이벤트 등록 |</a></li>
			<li><a href="eventList.do">&nbsp;이벤트 목록 |</a></li>
			<li><a href="eventApplicant.do">&nbsp;당첨자 추첨 |</a></li>
			<li><a href="winnerList.do">&nbsp;당첨자 목록 |</a></li>
		</ul>
	</div>
	<div style="height: 100%; width: 100%;">
		<form action="eventRegister.do" method="post">
			<div style=" height: 100%; width: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column;">
				<h2>이벤트 등록</h2>
				<table>
					<tr>
						<td><label for="eventName">이벤트 명: </label></td>
						<td><input style="width: 400px;" type="text" id="eventName"
							name="eventName"></td>
					<tr>
					<tr>
						<td><label for="eventDetail">이벤트 내용: </label></td>
						<td><textarea style="width: 400px; height: 200px;"
								id="eventDetail" name="eventDetail"></textarea></td>
					</tr>
					<tr>
						<td><label for="datePicker">이벤트 기간</label></td>
						<td><input type="text" id="datePicker" name="eventDate">
							~ <input type="text" id="datePicker1" name="eventEndDate"
							disabled></td>
					</tr>
				</table>
				<div>
					<br> <input type="submit" id="btn-submit" value="전송">
					<input type="reset" id="btn-submit" value="취소">
				</div>
			</div>
		</form>
	</div>

</body>
</html>