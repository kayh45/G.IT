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
<!-- 헤더--> </header>
<section id="main"> <aside id="side"> <%@ include
file="sideMenu.jsp"%> </aside> <section id="content">
<form name="frm" method="post" action="course.do?command=course_write">
<div class="content_title-box">
<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
<p class="content_title-text">경로등록</p>
</div>
<div class="content_cont-box">
<p class="content_cont-text">
<b>경로번호<b>
</p>
<input type="text" class="form_textbox" name="cour_no" readonly>
</div>
<div class="content_cont-box">
<p class="content_cont-text">
<b>*경로기본정보</b>
</p>
<table class="table table-bordered">

<tr>
<td class="form_label">
<p class="label">출발지</p>
<p class="must">*</p>
</td>
<td><input type="text" name="s_place" class="form_textbox">
<span id="search-button" class="glyphicon glyphicon-search"
aria-hidden="true"></span></td>
<td class="form_label">
<p class="label">출발지주소</p>

</td>
<td><input type="text" class="form_textbox" readonly>
</td>
</tr>
<tr>
<td class="form_label">
<p class="label">도착지</p>
<p class="must">*</p>
</td>
<td><input type="text" name="e_place" class="form_textbox">
<span id="search-button" class="glyphicon glyphicon-search"
aria-hidden="true"></span></td>
<td class="form_label">
<p class="label">도착지주소</p>
</td>
<td><input type="text" class="form_textbox" readonly>
</td>
</tr>
<tr>
<td class="form_label">
<p class="label">경로목적</p>
<p class="must">*</p>
</td>
　　　　　　<td colspan="3"><select class="form_textbox">
<option value="선택" selected="">선택</option>
<option value="거래처방문">거래처방문</option>
<option value="회의참석">회의참석</option>
<option value="출·퇴근">출·퇴근</option>
<option value="기타업무목적">기타업무목적</option>
<option value="업무외사용">업무외사용</option>
</select> </td>

</tr>
<tr>
<td class="form_label">
<p class="label">거리</p>
<p class="must">*</p>
</td>
<td colspan="3" name="distance" class="form_phone-td"><input
type="text" class="form_textbox" size="6" maxlength="3"> <b>
km</b></td>
</tr>

</table>
</div>
<div class="form_btn-group">
<button id="ins_btn" type="submit">등록</button>
<button id="mod_btn" type="submit">수정</button>
<button id="del_btn" type="submit">삭제</button>

</div>
</form>
</section> </section>
</body>
</html>
