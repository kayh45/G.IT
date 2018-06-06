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
<script type="text/javascript" src="js/car.js?ver=1"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript">
	function change(style) {
		if (style == "선택") {
			paycar.style.display = "none";
			rental_lease.style.display = "none";
		}
		else if (style == "구입") {
			paycar.style.display = "inline";
			rental_lease.style.display = "none";
		}
		else if (style == "렌트") {
			paycar.style.display = "inline";
			rental_lease.style.display = "inline";
		}
		else if (style == "리스") {
			paycar.style.display = "inline";
			rental_lease.style.display = "inline";
		}
	}
//-->
</script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> 
	<section id="content">
	<c:if test = "${message ne null}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		 	 ${message}
		</div>
	</c:if>	
	<form name="frm" method="post" action="car.do?command=car_write">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">법인 차 등록</p>
		</div>
		<div class="content_cont-box">
			
			<p class="content_cont-text">차량 등록 번호</p>
			<input type="text" class="form_textbox" name="car_reg_no">
						<input type = "hidden" name = "car_reg_no_ok" value="0" class = "form_textbox">
						<input type = "hidden" name = "car_usable_no">
			<button type="button" onClick="carNoCheck()" class="quiet_btn" id="idCheck">
				<span id="search-button" class="glyphicon glyphicon-search"
					aria-hidden="true"></span>
			</button>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*법인 차 기본 정보</p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">법인 차 구분</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td">
					<select name="car_divi" class="form_car_select"
						onChange="change(this.options[this.selectedIndex].value)">
							<option value="선택">선택</option>
							<option value="구입">구입</option>
							<option value="렌트">렌트</option>
							<option value="리스">리스</option>
					</select></td>
					<td class="form_label">
						<p class="label">차종</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" name="car_model"></td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">누적 거리</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan="3">
					<input type="text" class="form_textbox" name="total_dist"> &nbsp; km
					</td>
				</tr>


			</table>

			<div id="paycar" style="display: NONE;">
				<jsp:include page="car_pay.jsp" flush="true" />
			</div>
			<div id="rental_lease" style="display: NONE;">
				<jsp:include page="car_rental_lease.jsp" flush="true" />
			</div>
		</div>
		<div class="form_btn-group">
			<button id="ins_btn" type="submit" onclick="return carWriteCheck1()">등록</button>
			<button id="mod_btn" type="submit" onclick="return carModifyCheckDivided()"disabled>수정</button>
			<button id="del_btn" type="button" onclick="carDelete()" disabled>삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>