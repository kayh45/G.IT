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
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/carlog.js?ver=2"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/segmented-controls.css" rel="stylesheet">
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더--> </header>
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
		<p class="content_title-text">운행일지 작성</p>
	</div>

	<form method="post" action="carlog.do?command=carlog_write" name="frm">
		<div class="content_cont-box">
			<p class="content_cont-text">* 운행 기본 정보</p>
			<p class="content_cont-text"></p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">배차 신청 번호</p>

					</td>
					<td class="form_normal-td" colspan="3"><input name="driv_no"
						type="text" class="form_textbox" readonly>

						<button type="button" onClick="carlogSearch();" class="quiet_btn"
							id="idCheck">

							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button> <!-- 위에 있는거 나중에 js파일로 처리 --></td>
				</tr>

				<tr>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>

					</td>
					<td><input name="car_reg_no" type="text" class="form_textbox" readonly>

					</td>
					<td class="form_label">
						<p class="label">차종</p>
					</td>
					<td class="form_normal-td"><input name="car_model" type="text"
						class="form_textbox" readonly></td>
				</tr>

				<tr>
					<td class="form_label">
						<p class="label">사원 이름</p>
					<input name="mem_id" type="hidden" class="form_textbox" readonly>


					</td>
					<td class="form_normal-td" colspan="3"><input name="mem_name"
						type="text" class="form_textbox" readonly></td>

				</tr>

				<tr>
					<td class="form_label">
						<p class="label">운행 기간(시작)</p>
					</td>

					<td >
						<div id="driv_s_date">
							<input type="text" class="form_textbox" name="driv_s_date" readonly> </div>
					
							</td>
							<td class="form_label">
						<p class="label">운행 기간(종료)</p>
					</td>
							<td>
							<div id="driv_e_date"><input type="text" class="form_textbox" name="driv_e_date" readonly></div>
						
					</td>


				</tr>

			</table>

			<!-- <div class="content_cont-box"> -->
			<p class="content_cont-text">* 경로 정보</p>
			<p class="content_cont-text"></p>
			<input name="cour_no" type="hidden" class="form_textbox">
			<table class="table table-bordered" id="form_table">

				<tr>
					<td class="form_label">
						<p class="label">출발지</p>

					</td>
					<td><input name="s_place_name" type="text"
						class="form_textbox" readonly>
						<button type="button" onClick="carlogCourseSearch();"
							class="quiet_btn" id="idCheck">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button></td>
					<td class="form_label">
						<p class="label">도착지</p>
					</td>
					<td class="form_normal-td"><input name="e_place_name"
						type="text" class="form_textbox" readonly></td>
				</tr>

				<tr>
					<td class="form_label">
						<p class="label">경로 목적</p>

					</td>
					<td colspan="4"><select class="form_textbox" name="driv_purpo">
							<option value="선택" selected>선택</option>
							<option value="거래처방문">거래처 방문</option>
							<option value="회의참석">회의 참석</option>
							<option value="출·퇴근">출·퇴근</option>
							<option value="기타업무">기타업무</option>
							<option value="업무외사용">업무외 사용</option>
					</select></td>


				</tr>


				<tr>
					<td class="form_label">
						<p class="label">주행거리</p>
					</td>
					<td class="form_normal-td" colspan="3"><input name="distance"
						type="text" size="13" class="form_textbox">&nbsp;km</td>
				</tr>
			</table>
		</div>

		<div class="content_cont-box">
			<p class="content_cont-text">* 추가 입력 정보</p>
			<p class="content_cont-text"></p>
			<table class="table table-bordered" id="form_table">

				<tr>
					<td class="form_label">
						<p class="label">카드 구분</p>
					</td>
					<td class="form_normal-td" colspan="3">
						<div class="radio-group">
							 <input type="radio" value="미사용" name="card_divi" checked>미사용
							<input type="radio" value="법인카드" name="card_divi">법인카드
							 <input type="radio" value="개인카드" name="card_divi">개인카드 
						</div>
					</td>
				</tr>

				<tr>
					<td class="form_label" rowspan="3">
						<p class="label">비용 구분</p>
					</td>
					<td class="form_normal-td" colspan="3">
						<div class="radio-group">
							<input type="checkbox" name="oil_fee_check">유류비 <input
								name="oil_fee" type="text" class="form_textbox" value = 0>원

						</div>
					</td>
				</tr>

				<tr>
					<td class="form_normal-td" colspan="3">
						<div class="radio-group">
							<input type="checkbox" name="trans_fee_check">교통비 <input
								name="trans_fee" type="text" class="form_textbox" value = 0>원

						</div>
					</td>

				</tr>

				<tr>

					<td class="form_normal-td" colspan="3">
						<div class="radio-group">
							<input type="checkbox" name="etc_fee_check">기타(직접 입력)
							<input name="etc_text" type="text" class="form_textbox"> <input
								name="etc_fee" type="text" class="form_textbox" value = 0>원

						</div>
					</td>
				</tr>
			</table>
		</div>




		<div class="form_btn-group">
			<button id="ins_btn" type="submit" onclick="return carlogWriteCheck()">등록</button>
			<button id="mod_btn" type="submit" onclick="return carlogModifyCheck()" disabled>수정</button>
			<button id="del_btn" type="button" onclick="carlogDelete()" disabled>삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>
<!-- 
TODO 
- 이미 저장되어있는 정보 가져오는 부분 만들기 
- 모바일에 맞게 CSS등 수정
-->