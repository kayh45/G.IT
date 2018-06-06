<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>운행 일지 작성 :: 법인차량관리시스템</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.js"></script>

<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/member.js?ver=4"></script>
<script type="text/javascript" src="js/car.js?ver=3"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>

	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<c:if test="${message ne null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}
		</div>
	</c:if>
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">운행일지 일괄작성</p>
	</div>
	<form name="frm" action="post">
		<input type = "hidden" name = "demand" value = "id">
		<div class="content_cont-box">
			<p class="content_cont-text">차량 등록 번호</p>
			<input type="text" class="form_textbox" name="car_reg_no"> <input
				type="hidden" name="car_reg_no_ok" class="form_textbox"> <input
				type="hidden" name="car_usable_no">
			<button type="button" onClick="carSearch()" class="quiet_btn"
				id="idCheck">
				<span id="search-button" class="glyphicon glyphicon-search"
					aria-hidden="true"></span>
			</button>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*일지 작성 기본 정보</p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">작성기간</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan="3">
					<select class="form_car_select select_sm">
							<option value="${curYear - 2}">${curYear - 2}년</option>
							<option value="${curYear - 1}">${curYear - 1}년</option>
							<option value="${curYear}" selected>${curYear}년</option>
					</select> <select class="form_car_select select_sm">
							<c:forEach varStatus="month" begin="1" end="12" step="1">
								<option value="${month.count}">${month.count}월</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">운전자</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td">
						<input name="mem_search_name" type="text" class="form_textbox">
						<input name = "mem_name" type = "hidden">
						<input name = "mem_id" type = "hidden">
						<button type="button" onClick="memSearchByName();" class="quiet_btn">
							<span id="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</td>
					<td class="form_label">
						<p class="label">주행거리</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text" class="form_textbox" name="total_dist"> km</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">평균 유가(ℓ당)</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td">
							<input type="text" class="form_textbox" name="avg_oil"> 원
					</td>
					<td class="form_label">
						<p class="label">연비</p>
						<p class="must">*</p>
					</td>
					<td>
						<select class = "form_car_select text_half">
							<option value = "16">16km/ℓ</option>
							<option value = "14">14km/ℓ</option>
							<option value = "12">12km/ℓ</option>
							<option value = "10">10km/ℓ</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div class="content_cont-box">
			카드 비용 들어갈 곳
		</div>
	</form>
	</section> 
	</section>
</body>
</html>