<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>

<body>
	
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include file="sideMenu.jsp"%> </aside>
	<script type = "text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
	 <section id="content">
	<form name="frm" method="post" action="car.do?command=car_expense">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">법인 차 비용 내역 조회</p>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*비용 내역 정보</p>
			<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">비용 날짜(시작)</p>
					<p class="must">*</p>
				</td>
				<td>				
					<div id = "date_s">
						<input type="text" class="form_textbox" name = "date_s" value="${date_s}">
					</div>
					<script type="text/javascript">
						$('#date_s input').datepicker({dateFormat: "yy-mm-dd"});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">비용 날짜(종료)</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "date_e">
						<input type="text" class="form_textbox" name = "date_e" value="${date_e}">
					</div>
				<script type="text/javascript">
						$('#date_e input').datepicker({dateFormat: "yy-mm-dd"});
					</script>										
					</td>
			</tr>
				<tr><td class="form_label">
						<p class="label">차종</p>
					</td>
					
					<td class="form_normal-td" ><input type="text"
						class="form_textbox" id="car_model" name="car_model" value="${ car_model}">
							</td>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>
					</td>
					
					<td class="form_normal-td"><input type="text"
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
						<th class = "number_th">시작 날짜</th>
						<th>종로 날짜</th>
						<th>차량 등록 번호</th>
						<th>수리비</th>
						<th>유류비</th>
						<th>통행비</th>
						<th>기타비</th>
						<th>총 액</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carAllList}">
					
				<tr>		               
						<td>${car.date_s}</td>
						<td>${car.date_e}</td>
						<td>${car.car_reg_no}</td>
						<td>${car.repa_fee}</td>		
						<td>${car.oil_fee}</td>		
						<td>${car.trans_fee}</td>
						<td>${car.etc_fee}</td>
						<td>${car.etc_fee}</td>
						
					</tr>		
				   <%--  <input type = "hidden" name = "${repa.repa_no}repa_no" value  = "${repa.repa_no}">
					<input type = "hidden" name = "${repa.repa_no}car_reg_no" value  = "${repa.car_reg_no}">
					<input type = "hidden" name = "${repa.repa_no}cent_no" value  = "${repa.cent_no}">
					<input type = "hidden" name = "${repa.repa_no}cent_name" value  = "${repa.cent_name}"> 
					<input type = "hidden" name = "${repa.repa_no}repa_s_date" value  = "${repa.repa_s_date}">
					<input type = "hidden" name = "${repa.repa_no}repa_e_date" value  = "${repa.repa_e_date}">
					<input type = "hidden" name = "${repa.repa_no}mechanic_name" value  = "${repa.mechanic_name}">
					<input type = "hidden" name = "${repa.repa_no}repa_fee" value  = "${repa.repa_fee}">
					<input type = "hidden" name = "${repa.repa_no}repa_cont" value  = "${repa.repa_cont}">
					<input type = "hidden" name = "${repa.repa_no}repa_divi" value  = "${repa.repa_divi}">
 --%>
					
				
				
				
				
					</c:forEach>
				</table>
			
				
				
			</div>
	</form>
	</section> 
	</section>

		
</body>
</html>