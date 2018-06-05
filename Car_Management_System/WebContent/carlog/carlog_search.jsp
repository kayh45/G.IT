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
<script type="text/javascript" src="js/carlog.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>장소 조회</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;배차 조회</p>
</div>
<div class = "popup_body">
			<div class = "popup_box">
				 <p class = "search-result_label">미작성 운행 일지</p> 
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">배차 신청 번호</th>
						<th>차량 등록 번호</th>
						<th>운행 기간</th>
					</tr>
					<thead>
					<c:forEach var = "nocarlog" items = "${NocarlogList}">
				<tr>
						<td><a onclick = "nocarlogSelect('${nocarlog.driv_no}')">${nocarlog.driv_no}</a></td>
						<td>${nocarlog.car_reg_no}</td>		
						<td>${nocarlog.driv_s_date}~${nocarlog.driv_e_date}</td>		
					</tr>	
					<input type = "hidden" name = "${nocarlog.driv_no}driv_no" value  = "${nocarlog.driv_no}">
					<input type = "hidden" name = "${nocarlog.driv_no}car_reg_no" value  = "${nocarlog.car_reg_no}">
					<input type = "hidden" name = "${nocarlog.driv_no}car_model" value  = "${nocarlog.car_model}">
					<input type = "hidden" name = "${nocarlog.driv_no}mem_name" value  = "${nocarlog.mem_name}">
					<input type = "hidden" name = "${nocarlog.driv_no}driv_s_date" value  = "${nocarlog.driv_s_date}">
					<input type = "hidden" name = "${nocarlog.driv_no}driv_e_date" value  = "${nocarlog.driv_e_date}">
					</c:forEach>
				</table>
			</div>
		
			<div class = "popup_box">
	
				 <p class = "search-result_label">작성 완료 운행 일지</p> 
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">배차 신청 번호</th>
						<th>차량 등록 번호</th>
						<th>운행 기간</th>
						<th>출발지</th>
						<th>도착지</th>
						<th>운행 목적</th>
					</tr>
					<thead>
					<c:forEach var = "carlog" items = "${carlogList}">
				<tr>
						<td><a onclick = "carlogSelect('${carlog.driv_no}')">${carlog.driv_no}</a></td>
						<td>${carlog.car_reg_no}</td>		
						<td>${carlog.driv_s_date}~${carlog.driv_e_date}</td>		
						<td>${carlog.s_place_name}</td>		
						<td>${carlog.e_place_name}</td>
						<td>${carlog.driv_purpo}</td>		
					</tr>	
					<input type = "hidden" name = "${carlog.driv_no}driv_no" value  = "${carlog.driv_no}">
					<input type = "hidden" name = "${carlog.driv_no}car_reg_no" value  = "${carlog.car_reg_no}">
					<input type = "hidden" name = "${carlog.driv_no}car_model" value  = "${carlog.car_model}">
					<input type = "hidden" name = "${carlog.driv_no}mem_name" value  = "${carlog.mem_name}">
					<input type = "hidden" name = "${carlog.driv_no}driv_s_date" value  = "${carlog.driv_s_date}">
					<input type = "hidden" name = "${carlog.driv_no}driv_e_date" value  = "${carlog.driv_e_date}">
					<input type = "hidden" name = "${carlog.driv_no}s_place_name" value  = "${carlog.s_place_name}">
					<input type = "hidden" name = "${carlog.driv_no}e_place_name" value  = "${carlog.e_place_name}">
					<input type = "hidden" name = "${carlog.driv_no}driv_purpo" value  = "${carlog.driv_purpo}">
					<input type = "hidden" name = "${carlog.driv_no}distance" value  = "${carlog.distance}">
					<input type = "hidden" name = "${carlog.driv_no}card_divi" value  = "${carlog.card_divi}">
					<input type = "hidden" name = "${carlog.driv_no}oil_fee" value  = "${carlog.oil_fee}">
					<input type = "hidden" name = "${carlog.driv_no}trans_fee" value  = "${carlog.trans_fee}">
					<input type = "hidden" name = "${carlog.driv_no}etc_text" value  = "${carlog.etc_text}">
					<input type = "hidden" name = "${carlog.driv_no}etc_fee" value  = "${carlog.etc_fee}">

					</c:forEach>
				</table>
			</div>
			
</div>
</body>
</html>