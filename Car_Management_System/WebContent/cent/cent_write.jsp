<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>정비소 등록 :: 법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/post.js"></script>
<script type="text/javascript" src="js/cent.js?ver=1"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include file="sideMenu.jsp"%> </aside> <section id="content">
		<form name="frm" method="post" action="cent.do?command=cent_write">
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">정비소 등록</p>
	</div>
	<div class="content_cont-box">
			<p class="content_cont-text">정비소 번호</p>
			<input type="text" class="form_textbox" name="cent_no" readonly>
	</div>
	<div class="content_cont-box">
		<p class="content_cont-text">*정비소 기본 정보</p>
		<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">정비소 이름</p>
					<p class="must">*</p>
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
					<td class="form_label">
					<p class="label">대표자</p>
				</td>
				<td class="form_normal-td"><input type="text"
					class="form_textbox" name="ceo_name"></td>
			</tr>
			<tr>
						<td class = "form_label">
							<p class = "label">대표 전화</p>
							<p class = "must">*</p>					
						</td>
						<td  class = "form_phone-td">
							<input name = "cent_tell1" type = "text" class = "form_textbox" size = "6" maxlength="3" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input name = "cent_tell2" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input name = "cent_tell3" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
						</td>
						<td class = "form_label">
							<p class = "label">FAX</p>
						</td>
						<td  class = "form_phone-td">
							<input name = "cent_fax1" type = "text" class = "form_textbox" size = "6" maxlength="3" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input name = "cent_fax2" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input name = "cent_fax3" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">우편번호</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input name = "cent_p_no" type = "text" id = "postcode" size = "13" class = "form_textbox" readonly>
						</td>
					</tr>	
					<tr>
						<td class = "form_label">
							<p class = "label">주소</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input  name = "cent_addr" type = "text" id = "roadAddress" class = "form_textbox" readonly>
							<button type = "button" onclick="sample6_execDaumPostcode()" class = "quiet_btn">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">상세 주소</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input name = "cent_addr_dtl" type = "text" id = "roadAddress-detail" class = "form_textbox">
						</td>
					</tr>


		</table>
	</div>
	<div class="form_btn-group">
		<button id="ins_btn" type="submit" onclick = "return centWriteCheck()">등록</button>
		<button id="mod_btn" type="submit" onclick = "return centModifyCheck()" disabled>수정</button>
		<button id="del_btn" type="button" onclick = "centDelete()" disabled>삭제</button>
		
	</div>
	</form>
	</section> </section>
</body>
</html>