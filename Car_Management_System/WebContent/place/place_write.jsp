<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/post.js"></script>
<script type="text/javascript" src="js/place.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더--> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">장소등록</p>
	</div>
	<form method="post" action="place.do?command=place_write" name="frm">
		<div class="content_cont-box">
			<p class="content_cont-text">장소번호</p>
			<input type="text" class="form_textbox" name="place_no" readonly>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*장소기본정보</p>
			<table class="table table-bordered">
				<tr>
					<td class="form_label">
						<p class="label">장소명</p>
						<p class="must">*</p>
					</td>
					<td colspan="3"><input type="text" class="form_textbox"
						name="place_name">
						
						<input type = "hidden" name = "place_usable_name">
					<button type = "button" onClick = "placeNameCheck()" class = "quiet_btn" id = "idCheck">
					<span id="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
					</td>
					
					
				</tr>
				<!-- <tr>
<td class="form_label">
<p class="label">장소구분</p>
<p class="must">*</p>
</td>
　　　　　　<td colspan="3"><select class="form_textbox">
<option value="선택" selected="">선택</option>
<option value="거래처방문">거래처방문</option>
<option value="회의참석">회의참석</option>
<option value="출·퇴근">출·퇴근</option>
<option value="기타업무목적">기타업무목적</option>
<option value="업무외사용">업무외사용</option>
</select> <input type="text" class="form_textbox"></td>

</tr> -->
				<tr>
					<td class="form_label">
						<p class="label">우편번호</p>
						<p class="must">*</p>
					</td>
					<td colspan="3"><input name="place_p_no" type="text"
						id="postcode" class="form_textbox" readonly></td>
				</tr>

				<tr>
					<td class="form_label">
						<p class="label">주소</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan="3"><input
						name="place_addr" type="text" id="roadAddress"
						class="form_textbox">

						<button type="button" onclick="sample6_execDaumPostcode()"
							class="quiet_btn">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">상세주소</p>
						<p class="must">*</p>
					</td>
					<td colspan="3"><input type="text" id="form_address"
						class="form_textbox"></td>
				</tr>

			</table>
		</div>
		<div class="form_btn-group">
			<button id="ins_btn" type="submit">등록</button>
			<button>수정</button>
			<button>삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>