<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
	<header>
			<%@ include file = "header.jsp" %>
			<!-- 헤더 -->
	</header>
	<section id = "main">
		<section id = "content">
			<div class = "row">
				<div class = "col-md-6 hidden-xs">
					<div class = "main_pic">
					</div>
				</div>
				<div class = "col-md-6">
					<div class = "main_cont-box">
						<p class = "main_title-text"><span class="glyphicon glyphicon-road" aria-hidden="true"></span> 법인 차 현황 (총 ${noc}대)</p>
						<div class = "row main_car">
							<div class = "col-md-6">
								<img class = "img_car_info" src = "img/car_drivable_icon.png">
								<p class = "car-status">사용 가능</p>
								<p class = "car-status-number">${noc-nouc} 대</p>
							</div>
							<div class = "col-md-6">
								<img class = "img_car_info" src = "img/car_driving_icon.png">
								<p class = "car-status">사용 중</p>
								<p class = "car-status-number">${nouc} 대</p>
							</div>
							<div class = "cont-bottom" onclick = "location.href='rsrv.do?command=reserve_write_form'">
								<b>배차 등록 화면으로</b> <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
							</div>
						</div>						
					</div>
				</div>
			</div>
			<div class = "main_cont-box no-bg">
			<div class = "row qLink_grp">
				<div class = "col-md-3 col-xs-6">
					<div class = "content_cont-box qLink_button" onclick = "location.href='place.do?command=place_write_form'">
						<img src = "img/temp_icon.png" width = "200">
						<p>장소 등록</p>
					</div>
				</div>
				<div class = "col-md-3 col-xs-6">
					<div class = "content_cont-box qLink_button" onclick = "location.href='car.do?command=car_write_form'">
						<img src = "img/temp_icon.png" width = "200">
						<p>법인 차 등록</p>
					</div>
				</div>
				<div class = "col-md-3 col-xs-6">
					<div class = "content_cont-box qLink_button" onclick = "location.href='member.do?command=member_write_form'">
						<img src = "img/temp_icon.png" width = "200">
						<p>사원 등록</p>
					</div>
				</div>
				<div class = "col-md-3 col-xs-6">
					<div class = "content_cont-box qLink_button" onclick = "location.href='carlog.do?command=carlog_auto_write_form'">
						<img src = "img/temp_icon.png" width = "200">
						<p>운행일지 일괄작성</p>
					</div>
				</div>
			</div>
			</div>
		</section>
	</section>
</body>
</html>