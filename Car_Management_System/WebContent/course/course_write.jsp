<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>경로 등록 :: 법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/course.js?ver=1"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더--> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<form name="frm" method="post" action="course.do?command=cour_write">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">경로 등록</p>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">
				<b>경로 번호<b>
			</p>
			<input type="text" class="form_textbox" name="cour_no" readonly>
				<input type ="button" onclick="courSearch()" value ="조회">
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">
				<b>*경로 기본 정보</b>
			</p>
			<table class="table table-bordered">

				<tr>
				
					<td class="form_label">
						<p class="label">출발지</p>
						<p class="must">*</p>
						<input type="hidden" class="form_textbox" name="s_place_no" readonly>
					</td>
					<td><input type="text" name="s_place_name" class="form_textbox" readonly>
					<input type="hidden" name="s_place_name_ok" class="form_textbox"> 
					<input type="hidden" name="s_place_usable_name">
					<button type="button" onClick="splaceNameCheck()" class="quiet_btn" id="idCheck">
				 	<span id="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button></td>
					<td class="form_label">
						<p class="label">출발지 주소</p>

					</td>
					<td><input type="text" class="form_textbox" name = "s_place_addr" readonly>
					</td>
				</tr>
				<tr>
				
					<td class="form_label">
						<p class="label">도착지</p>  
						<p class="must">*</p>
						<input type="hidden" class="form_textbox" name="e_place_no" readonly>
					</td>
					<td><input type="text" name="e_place_name" class="form_textbox" readonly>
					<input type="hidden" name="e_place_name_ok" class="form_textbox"> 
					<input type="hidden" name="e_place_usable_name">
					<button type="button" onClick="eplaceNameCheck()" class="quiet_btn" id="idCheck">
				 	<span id="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button></td>
					<td class="form_label">
						<p class="label">도착지 주소</p>
					</td>
					<td><input type="text" class="form_textbox" name = "e_place_addr" readonly>
					</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">경로 목적</p>
						<p class="must">*</p>
					</td>
					<td colspan="4"><select class="form_textbox" name = "cour_purpo">
							<option value="선택" selected="">선택</option>
							<option value="거래처방문">거래처 방문</option>
							<option value="회의참석">회의 참석</option>
							<option value="출·퇴근">출·퇴근</option>
							<option value="기타업무">기타업무</option>
							<option value="업무외사용">업무외 사용</option>
					</select></td>

				</tr>
				<tr>
					<td class="form_label">
						<p class="label">거리</p>
						<p class="must">*</p>
					</td>
					<td colspan="4"  class="form_phone-td">
					<input name="distance" type="text" class="form_textbox" size="6" maxlength="3">km</b></td>
				</tr>
			</table>
		</div>
		<div class="form_btn-group">
			<button id="ins_btn" type="submit" onclick="return carWriteCheck1()">등록</button>
			<button id="mod_btn" type="submit" onclick="return carModifyCheckDivided()"disabled>수정</button>
			<button id="del_btn" type="button" onclick="carDelete()" disabled>삭제</button>
		</div>
<!-- 		<div class="form_btn-group">
		<button id="ins_btn" type="submit" onclick = "return courWriteCheck()">등록</button>
		<button id="mod_btn" type="submit" onclick = "return courModifyCheck()" >수정</button>
		<button id="del_btn" type="button" onclick = "courDelete()" >삭제</button>
		</div> -->
	</form>
	</section> </section>
</body>
</html>
