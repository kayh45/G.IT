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
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript" src="js/car.js?ver=2"></script>
<title>법인차 검색</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;부서 조회</p>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test = "${isLike eq 'no'}">
		<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=car_search&popup=yes">
					차량 등록 번호 &nbsp;
					<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "car_reg_no_ok" value = "1">	
			</form>
		</div>	
		<div class = "popup_box">
			<p class = "search-result_label">'${car_reg_no}'에 대한 조회결과가 없습니다.</p>
		</div>			
		</c:when>
		<c:when test = "${isLike eq 'yes'}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=car_search&popup=yes">
						차량 등록 번호 &nbsp;
						<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
						<button type = "submit">조회</button>
				</form>
			</div>
			<div class = "popup_box">
				<p class = "search-result_label">'${car_reg_no}'에 대한 조회 결과입니다.</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carList}">
					<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "carSrchSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
					</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>
	</c:choose>	
</div>
</body>
</html>