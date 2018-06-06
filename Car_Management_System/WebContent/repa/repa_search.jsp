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
<script type="text/javascript" src="js/repa.js?ver=1"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/segmented-controls.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/rsrv.js"></script>
</head>

<body>
	
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include file="sideMenu.jsp"%> </aside>
	<script type = "text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
	 <section id="content">
	<form name="frm" method="post" action="repa.do?command=repa_search_form">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">정비 내역 조회</p>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*정비 내역 정보</p>
			<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">정비 시작 날짜</p>
					<p class="must">*</p>
				</td>
				<td>				
					<div id = "repa_s_date">
						<input type="text" class="form_textbox" name = "repa_s_date" value="${repa_s_date}">
					</div>
					<script type="text/javascript">
						$('#repa_s_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">정비 종료 날짜</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "repa_e_date">
						<input type="text" class="form_textbox" name = "repa_e_date" value="${repa_e_date}">
					</div>
					<script type="text/javascript">
						$('#repa_e_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>										
					</td>
			</tr>
			
		
				<tr>
					<td class="form_label">
						<p class="label">정비소 번호</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="cent_no" name="cent_no" value="${cent_no}" readonly></td>
					<td class="form_label">
						<p class="label">정비소 명</p>
					</td>
					<td class="form_normal-td">
				<input type="text" name="cent_name" class="form_textbox" value="${cent_name}">
				<input type = "hidden" name = "cent_name_ok" class = "form_textbox">
					<input type = "hidden" name = "cent_usable_name">
							<button type = "button" onClick = "centNameCheck();" class = "quiet_btn" id = "idCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>	
<!-- 							<span id = "hdn_label" class = "hdn_label">기존: <input type = "text" class = "form_textbox" name = "pre_cent_name" readonly></span>
 -->						</td>
				</tr>
					<input type = "hidden" name ="temp_repa_no" value="false">
					<input type = "hidden" name ="temp_car_reg_no" value="false">
					<input type = "hidden" name ="temp_cent_no" value="false">
					<input type = "hidden" name ="temp_repa_s_date" value="false">
			 		<input type = "hidden" name ="temp_repa_e_date" value="false">
					<input type = "hidden" name ="temp_mechanic_name" value="false">
					<input type = "hidden" name ="temp_repa_fee" value="false">
					<input type = "hidden" name ="temp_repa_cont" value="false">
					<input type = "hidden" name ="temp_repa_divi" value="false">
				<tr>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>
					</td>
					<td class="form_normal-td" colspan="3"><input type="text"
						class="form_textbox" id="car_reg_no" name="car_reg_no" value="${ car_reg_no}">
							<input type = "hidden" name = "car_reg_no_ok" value = "0">
						<button type = "button" onClick = "carNoCheck();" class = "quiet_btn" id = "idCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>	</td>
				</tr>
			</table>
			<div class="form_btn-group1">
		<button id="ins_btn" type="submit" onclick="repaDateCheck()">조회</button>
		</div>
		</div>
			<div class = "content_cont-box"
			id="content_cont-box1" style=display:block;>
				<p class = "search-result_label" >조회 리스트</p>

				<table class = "table table-condensed table-bordered" >					
					<thead>
					<tr>
						<th class = "number_th">정비 내역 번호</th>
						<th>차량 등록 번호</th>
						<th>정비 구분</th>
						<th>정비 시작 날짜</th>
						<th>정비 종료 날짜</th>
						<th>수리 비용</th>
					</tr>
					<thead>
					<c:forEach var = "repa" items = "${repaAllList}">
					
				<tr>		               
						<td><a onclick ="repaSelect('${repa.repa_no}')">${repa.repa_no}</a></td>
						<td>${repa.car_reg_no}</td>
						<td>	<c:choose>
					<c:when test="${repa.repa_divi=='0'}">
					정기점검
					</c:when>
					<c:otherwise>
					사고
					</c:otherwise>
					</c:choose></td>
						<td>${repa.repa_s_date}</td>		
						<td>${repa.repa_e_date}</td>		
						<td>${repa.repa_fee}</td>
						
					</tr>					
				    <input type = "hidden" name = "${repa.repa_no}repa_no" value  = "${repa.repa_no}">
					<input type = "hidden" name = "${repa.repa_no}car_reg_no" value  = "${repa.car_reg_no}">
					<input type = "hidden" name = "${repa.repa_no}cent_no" value  = "${repa.cent_no}">
					<%-- <input type = "hidden" name = "${repa.cent_name}cent_name" value  = "${repa.cent_name}"> --%>
					<input type = "hidden" name = "${repa.repa_no}repa_s_date" value  = "${repa.repa_s_date}">
					<input type = "hidden" name = "${repa.repa_no}repa_e_date" value  = "${repa.repa_e_date}">
					<input type = "hidden" name = "${repa.repa_no}mechanic_name" value  = "${repa.mechanic_name}">
					<input type = "hidden" name = "${repa.repa_no}repa_fee" value  = "${repa.repa_fee}">
					<input type = "hidden" name = "${repa.repa_no}repa_cont" value  = "${repa.repa_cont}">
					<input type = "hidden" name = "${repa.repa_no}repa_divi" value  = "${repa.repa_divi}">

					
				
				
				
				
					</c:forEach>
				</table>
			
				
				
			</div>
	</form>
	</section> 
	</section>

		
</body>
</html>