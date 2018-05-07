<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인차량관리시스템</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section
		id="content">
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">장소 등록</p>
	</div>
	<div class="content_cont-box">
		<p class="content_cont-text">장소 번호</p>
		<input type="text" class="form_textbox" readonly>
	</div>
	<div class="content_cont-box">
		<p class="content_cont-text">*장소 기본 정보</p>
		<table class="table table-bordered">
			<tr>
				<td class="form_label">
					<p class="label">장소명</p>
					<p class="must">*</p>
				</td>
				<td colspan="3"><input type="text" class="form_textbox">
					<span id="search-button" class="glyphicon glyphicon-search"
					aria-hidden="true"></span></td>
			</tr>
			<tr>
				<td class="form_label">
					<p class="label">장소 구분</p>
					<p class="must">*</p>
				</td>
				　　　　　　<td colspan="3"><select class="form_textbox">
						<option value="선택" selected="">선택</option>
						<option value="거래처 방문">거래처 방문</option>
						<option value="회의 참석">회의 참석</option>
						<option value="출·퇴근">출·퇴근</option>
						<option value="기타 업무 목적">기타 업무 목적</option>
						<option value="업무 외 사용">업무 외 사용</option>
				</select> <input type="text" class="form_textbox"></td>

			</tr>
			<tr>
				<td class="form_label">
					<p class="label">우편 번호</p>
					<p class="must">*</p>
				</td>
				<td colspan="3"><input type="text" class="form_textbox"
					readonly></td>
			</tr>

			<tr>
				<td class="form_label">
					<p class="label">주소</p>
					<p class="must">*</p>
				</td>
				<td colspan = "3">
							<input type = "text" class = "form_textbox">
							<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						
			</tr>
			<tr>
				<td class="form_label">
					<p class="label">상세 주소</p>
					<p class="must">*</p>
				</td>
				<td colspan="3"><input type="text" id="form_address"
					class="form_textbox"></td>
			</tr>

		</table>
	</div>
	<div class="form_btn-group">
		<button>등록</button>
		<button>수정</button>
		<button>삭제</button>
	</div>
	</section> </section>
</body>
</html>