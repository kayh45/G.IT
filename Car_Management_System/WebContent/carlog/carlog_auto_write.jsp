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
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/member.js?ver=3"></script>
<script type="text/javascript" src="js/car.js?ver=3"></script>
<script type="text/javascript" src="js/common.js"></script>
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
		<p class="content_title-text">운행일지 자동작성</p>
	</div>
	<form name = "frm" action = "post">
	<div class = "content_cont-box">
		<p class="content_cont-text">차량 등록 번호</p>
			<input type="text" class="form_textbox" name="car_reg_no">
						<input type = "hidden" name = "car_reg_no_ok" class = "form_textbox">
						<input type = "hidden" name = "car_usable_no">
			<button type="button" onClick="carSearch()" class="quiet_btn" id="idCheck">
				<span id="search-button" class="glyphicon glyphicon-search"
					aria-hidden="true"></span>
			</button>
	</div>
	<div class = "content_cont-box">
		<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">일지 작성기간</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id="st_date">
						<input type="text" class="form_textbox" name="st_date">
					</div> 
					<div id="ed_date">
						<input type="text" class="form_textbox" name="ed_date">
					</div> 
					<script type="text/javascript">
				        $('#st_date input').datepicker({dateFormat : "yy-mm-dd"});
					</script>
				</td>
				<td class="form_label">
					<p class="label">차종</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<input type="text" class="form_textbox" name="car_model">
				</td>
			</tr>
		</table>
	</div>	
	</form>
	</section> 
	</section>
</body>
</html>