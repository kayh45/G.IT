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

</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<form name="frm" method="post" action="repa.do?command=repa_write">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">정비 내역 등록</p>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">정비 내역 번호</p>
			<input type="text" class="form_textbox" name="repa_no" readonly>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*정비 내역 정보</p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>
					</td>
					<td class="form_normal-td" colspan="3"><input type="text"
						class="form_textbox" id="car_reg_no" name="car_reg_no">
						<button type = "button" onClick = "repaNameCheck();" class = "quiet_btn" id = "idCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>	</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">정비소 번호</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="cent_no" name="cent_no" readonly></td>
					<td class="form_label">
						<p class="label">정비소 명</p>
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
					<p class="label">정비 시작 날짜</p>
					<p class="must">*</p>
				</td>
				<td>				
					<div id = "bo_s_date">
						<input type="text" class="form_textbox" name = "bo_s_date">
					</div>
					<script type="text/javascript">
						$('#bo_s_date input').datepicker({
							dateFormat: "yy-mm-dd"
						});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">정비 종료 날짜</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "bo_e_date">
						<input type="text" class="form_textbox" name = "bo_e_date">
					</div>
					<script type="text/javascript">
						$('#bo_e_date input').datepicker({
							dateFormat: "yy-mm-dd"
						});
					</script>										
					</td>
			</tr>
			
			
			
				<tr>
					<td class="form_label">
						<p class="label">정비사</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="mechanic_name" name="mechanic_name"></td>
					<td class="form_label">
						<p class="label">수리비용</p>
					</td>
					<td class="form_normal-td"><input type="text"
						class="form_textbox" id="repa_fee" name="repa_fee"> 원</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">정비내용1</p>
					</td>
					<td class="form_normal-td" colspan="3"><textarea
							class="form_textarea" id="repa_cont" name="repa_cont" rows="4"
							cols="60"></textarea></td>
				</tr>


			</table>
		</div>
		<div class="form_btn-group">
			<button id="ins_btn" type="submit">등록</button>
			<button id="mod_btn" type="submit">수정</button>
			<button id="del_btn" type="button">삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>