<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<link href="css/popup.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<script type="text/javascript" src="js/carlog.js?ver=2"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>장소 조회</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;일괄작성 가능 여부</p>
</div>
<div class = "popup_body">
	<div class = "popup-box">
		<form method = "post" name = "frm">
		<c:choose>
			<c:when test = "${preExist eq 0}">
				<p class = "popup_notice">이전 달(${month - 1}월)에 입력된 운행일지 내역이 없어서 일괄 작성이 불가합니다.<p>
				<button type = "button" onclick = "autoCheckClose()">닫기</button>
			</c:when>
			<c:when test = "${preSize > 0}">
					<p class = "popup_notice">이전 달(${month - 1}월)에 ${preSize}건의 미작성 운행일지가 있어서 일괄작성이 불가능합니다.<p>
					<p class = "popup_notice">해당 사원에게 운행일지 작성을 마무리 하도록 요청해주세요</p>
					<button type = "button" onclick = "autoCheckClose()">닫기</button>
					<table class = "table">
						<thead><tr>
							<th>운행 일지 번호</th>
							<th>운전자</th>
							<th>운행 시작 시간</th>
						</tr></thead>
				<c:forEach var = "preMonth" items = "${preMonthList}">

						<tr>
							<td>${preMonth.driv_no}</td>
							<td>${preMonth.mem_name}</td>
							<td>${preMonth.driv_s_date}</td>
						</tr>						
				</c:forEach>
					</table>
			</c:when>
			<c:when test = "${thisSize > 0}">
				<p class = "popup_notice">이번 달(${month}월) 일괄작성이 가능하지만 이미 작성된 내용은 모두 지워집니다</p>
				<p class = "popup_notice">계속 하시겠습니까?
				<button type = "button" onclick = "autoCheckOk()">확인</button>
				<button type = "button" onclick = "autoCheckClose()">닫기</button>
				</p>
				
				<table class = "table">
					<thead><tr>
						<th>운행 일지 번호</th>
						<th>운전자</th>
						<th>운행 시작 시간</th>
					</tr></thead>
				<c:forEach var = "thisMonth" items = "${thisMonthList}">
						<tr>
							<td>${thisMonth.driv_no}</td>
							<td>${thisMonth.mem_name}</td>
							<td>${thisMonth.driv_s_date}</td>
						</tr>											
				</c:forEach>
					</table>
			</c:when>
			<c:otherwise>
				<p class = "popup_notice">이번 달(${month}월) 일괄작성이 가능합니다.</p>
				<button type = "button" onclick = "autoCheckOk()">확인</button>
				<button type = "button" onclick = "autoCheckClose()">닫기</button>
			</c:otherwise>
		</c:choose>
	</form>
	</div>
</div>
</body>
</html>