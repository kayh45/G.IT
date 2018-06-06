<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, user-scalable=no">
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
		file="sideMenu.jsp"%> </aside> 
	<section id="content">
		<c:if test = "${message ne null}">
			<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  ${message}
			</div>
		</c:if>	
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">장소등록</p>
	</div>
	<form method="post" action="place.do?command=place_write" name="frm">
		<div class="content_cont-box">
			<p class="content_cont-text">장소 번호</p>
			<input type="text" class="form_textbox" name="place_no" readonly>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*장소 기본 정보</p>
			<table class="table table-bordered">
				<tr>
					<td class="form_label">
						<p class="label">장소명</p>
						<p class="must">*</p>
					</td>
					<td colspan="3"><input type="text" class="form_textbox"
						name="place_name"> <input type="hidden"
						name="place_name_ok" class="form_textbox"> <input
						type="hidden" name="place_usable_name">
						<button type="button" onClick="placeNameCheck()" class="quiet_btn"
							id="idCheck">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button></td>


				</tr>
				<tr>
					<td class="form_label">
						<p class="label">우편 번호</p>
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
					<td class="form_normal-td" colspan="3">
					<input  name = "place_addr" type = "text" id = "roadAddress" class = "form_textbox" readonly>
							<button type = "button" onclick="sample6_execDaumPostcode()" class = "quiet_btn">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">상세주소</p>
						<p class="must">*</p>
					</td>
					<td colspan="3">
					<input name = "place_addr_dtl" type = "text" id = "roadAddress-detail" class = "form_textbox"></td>
				</tr>

			</table>
		</div>
		<div class="form_btn-group">
		<button id="ins_btn" type="submit" onclick = "return placeWriteCheck()">등록</button>
		<button id="mod_btn" type="submit" onclick = "return placeModifyCheck()" disabled>수정</button>
		<button id="del_btn" type="button" onclick = "placeDelete()" disabled>삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>