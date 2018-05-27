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
<script type="text/javascript" src="js/cent.js?ver=2"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript" src="js/car.js"></script>
<title>부서 조회</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;법인차 조회</p>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test = "${isLike eq 'no'}">
		<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=cart_write_check_form&popup=yes">
					차량 등록 번호 &nbsp;
					<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "car_reg_no_ok" value = "1">
				<p>'${car_reg_no}'은 등록가능합니다. 
					<button type = "button" onclick = "useCarNo()">사용</button> 
				</p>
			</form>
		</div>			
		</c:when>
		<c:when test = "${isLike eq 'yes'}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=car_write_check_form&popup=yes">
						<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
						<button type = "submit">조회</button>
					<c:if test = "${isMatch eq 'no'}">					
						<input type = "hidden" name = "cent_name_ok" value = "1">
						<p>'${car_reg_no}'은 등록가능합니다. 
							<button type = "button" onclick = "useCarNo()">사용</button> 
						</p>
					</c:if>
				</form>
			</div>
			<div class = "popup_box">
				<p class = "search-result_label">'${car_reg_no}'에 대한 조회 결과입니다.</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
						<th>법인차 구분</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carList}">
				<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "centSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
						<td>${car.car_divi}</td>
					</tr>					
					<input type = "hidden" name = "${car.car_reg_no}car_reg_no" value  = "${car.car_reg_no}">
					<input type = "hidden" name = "${car.car_model}car_model" value  = "${car.car_model}">
					<input type = "hidden" name = "${car.car_divi}car_divi" value  = "${car.car_divi}">
					<input type = "hidden" name = "${car.bo_name}bo_name" value  = "${car.bo_name}">
					<input type = "hidden" name = "${car.bo_divi}bo_divi" value  = "${car.bo_divi}">
					<input type = "hidden" name = "${car.bo_age}bo_age" value  = "${car.bo_age}">
					<input type = "hidden" name = "${car.bo_s_date}bo_s_date" value  = "${car.bo_s_date}">
					<input type = "hidden" name = "${car.bo_e_date}bo_e_date" value  = "${car.bo_e_date}">
					<input type = "hidden" name = "${car.co_name}co_name" value  = "${car.co_name}">
					<input type = "hidden" name = "${car.co_tel}co_tel" value  = "${car.co_tel}">
					<input type = "hidden" name = "${car.co_fax}co_fax" value  = "${car.co_fax}">
					<input type = "hidden" name = "${car.ct_date}ct_date" value  = "${car.ct_date}">
					<input type = "hidden" name = "${car.ep_date}ep_date" value  = "${car.ep_date}">
				
	
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