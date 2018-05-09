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
			<div class = "content_cont-box">
				<p class = "content_cont-text">부서 번호</p>
				<input type = "text" class = "form_textbox" readonly>				
			</div>
			<div class = "content_cont-box">
				<p class = "content_cont-text">
					* 부서 기본 정보
				</p>
				<form name = "frm">
				<table class="table table-bordered" id = "form_table">
					<tr>
						<td class = "form_label">
							<p class = "label">부서 이름</p>
							<p class = "must">*</p>					
						</td>
						<td class = "form_normal-td" colspan = "3">
							<input type = "text" name = "dept_name" class = "form_textbox">
							<button type = "button" onClick = "dept_check();" class = "quiet_btn" id = "deptCheck">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</td>
					</tr>					
				</table>
				</form>
			</div>
			<div class = "form_btn-group">
				<button>등록</button>
				<button>수정</button>
				<button>삭제</button>
			</div>
		</section>
	</section>
</body>
</html>