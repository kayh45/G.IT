<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템 :: 부서 등록</title>
<script type = "text/javascript" src="js/member.js"></script>
</head>
<body>
	<header>
			<%@ include file = "../header.jsp" %>
			<!-- 헤더 -->
	</header>
	<section id = "main">
		<aside id = "side">
			<%@ include file = "sideMenu.jsp" %>
		</aside>
		<section id = "content">
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true">
				</span>
				<p class = "content_title-text">부서 등록</p>
			</div>
			<form name = "frm" method = "post" action = "member.do?command=dept_write">
			<div class = "content_cont-box">
				<p class = "content_cont-text">부서 번호</p>
				<input name = "dept_no"  id = "number_input" type = "text" class = "form_textbox" readonly>				
			</div>
			<div class = "content_cont-box">
				<p class = "content_cont-text">
					* 부서 기본 정보
				</p>				
				<table class="table table-bordered" id = "form_table">
					<tr>
						<td class = "form_label">
							<p class = "label">부서 이름</p>
							<p class = "must">*</p>					
						</td>
						<td class = "form_normal-td" colspan = "3">
							<input type = "text" name = "dept_name" class = "form_textbox">
							<input type = "hidden" name = "dept_name_ok" value = "0">
							<input type = "hidden" name = "dept_usable_name">
							<button type = "button" onClick = "deptNamecheck();" class = "quiet_btn" id = "deptCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
							<span id = "hdn_label" class = "hdn_label">기존: <input type = "text" class = "form_textbox" name = "pre_dept_name" readonly></span>
						</td>
					</tr>					
				</table>
			</div>
				<div class = "form_btn-group">
					<button id = "ins_btn" type = "submit" onclick = "return deptWriteCheck()">등록</button>
					<button id = "mod_btn" type = "submit" onclick = "return deptWriteCheck()" disabled>수정</button>
					<button id = "del_btn" type = "button" onclick = "deptDelete()" disabled>삭제</button>
				</div>
			</form>
		</section>
	</section>
</body>
</html>