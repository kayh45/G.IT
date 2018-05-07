<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script language="javascript">
	function change(style) {
		if (style == "0") {
			paycar.style.display = "none"
			rental_lease.style.display = "none"
		}
		if (style == "1") {
			paycar.style.display = "inline"
			rental_lease.style.display = "none"
		}
		if (style == "2" || style == "3") {
			paycar.style.display = "none"
			rental_lease.style.display = "inline"
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
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">법인 차 등록</p>
	</div>
	<div class="content_cont-box">
		<p class="content_cont-text">차량 등록 번호</p>
		<input type="text" class="form_textbox" readonly>
	</div>
	<div class="content_cont-box">
		<p class="content_cont-text">*법인 차 기본 정보</p>
		<form name="car_form" action=" ">
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">법인 차 구분</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><select name="car_select"
						class="form_car_select"onChange="change(this.options[this.selectedIndex].value)">
							<option value="0">선택</option>
							<option value="1">구입</option>
							<option value="2">렌트</option>
							<option value="3">리스</option>
					</select></td>
					<td class="form_label">
						<p class="label">차종</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox"></td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">누적 거리</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan="3"><input type="text"
						class="form_textbox"></td>
				</tr>


			</table>
			<div id="paycar" style="display: NONE;"><jsp:include
					page="car_pay.jsp" flush="true" /></div>

			<div id="rental_lease" style="display: NONE;"><jsp:include
					page="car_rental_lease.jsp" flush="true" /></div>
	</div>
	<div class="form_btn-group">
		<button>등록</button>
		<button>수정</button>
		<button>삭제</button>
	</div>
	</section> </section>
</body>
</html>