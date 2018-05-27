<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/post.js"></script>
<script type="text/javascript" src="js/repa.js?ver=2"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
							<script language="javascript">
	function change() {
			paycar.style.display = "inline"
			rental_lease.style.display = "none"
	}
//-->
</script>
									
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<form name="frm" method="post" action="repa.do?command=repa_write">
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
						<input type="text" class="form_textbox" name = "repa_s_date" id="repa_s_date">
					</div>
					<script type="text/javascript">
					$('#repa_s_date input').datepicker({dateFormat: "yyyy-mm-dd"});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">정비 종료 날짜</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "repa_e_date">
						<input type="text" class="form_textbox" name = "repa_e_date" id="repa_e_date">
					</div>
					<script type="text/javascript">
						$('#repa_e_date input').datepicker({dateFormat: "yyyy-mm-dd"});
					</script>										
					</td>
			</tr>
				<tr>
					<td class="form_label">
						<p class="label">법인 차 번호</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="cent_no" name="cent_no" readonly></td>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>
					</td>
					<td class="form_normal-td">
				<input type="text" name="cent_name" class="form_textbox">
				<input type = "hidden" name = "cent_name_ok" class = "form_textbox">
					<input type = "hidden" name = "cent_usable_name">
							<button type = "button" onClick = "centNameCheck();" class = "quiet_btn" id = "idCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>	
<!-- 							<span id = "hdn_label" class = "hdn_label">기존: <input type = "text" class = "form_textbox" name = "pre_cent_name" readonly></span>
 -->						</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">사원 아이디</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="mem_no" name="mem_no" readonly></td>
					<td class="form_label">
						<p class="label">사원 이름</p>
					</td>
					<td class="form_normal-td">
				<input type="text" name="mem_name" class="form_textbox">
				<input type = "hidden" name = "cent_name_ok" class = "form_textbox">
					<input type = "hidden" name = "cent_usable_name">
							<button type = "button" onClick = "repaMemSearchByName()" class = "quiet_btn" id = "idCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>	
<!-- 							<span id = "hdn_label" class = "hdn_label">기존: <input type = "text" class = "form_textbox" name = "pre_cent_name" readonly></span>
 -->						</td>
				</tr>
			</table>
			<div class="form_btn-group1">
		<button id="ins_btn" type="button" onclick = "change()">조회</button>
		
		</div>
			
			
			<div id="paycar" style="display: NONE;">
				<jsp:include page="repa_search_sum.jsp" flush="true" />
			</div>
			
			
		</div>
			
	</form>
	</section> </section>
</body>
</html>