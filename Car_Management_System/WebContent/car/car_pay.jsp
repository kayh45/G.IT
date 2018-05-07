<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인 차량 관리 시스템</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>

	<p class = "content_cont-text">
					*보험 정보
				</p>
	<form name="frm" action=" ">
	<table class="table table-bordered" id="form_table">
	<tr>
		<td class="form_label">
			<p class="label">보험명</p>
			<p class="must">*</p>
		</td>
		<td><input type="text" class="form_textbox"></td>
		<td class="form_label">
			<p class="label">보험 나이 제한</p>
			<p class="must">*</p>
		</td>
		<td class="form_normal-td"><input type="text"
			class="form_textbox"></td>
	</tr>
	<tr>
		<td class="form_label">
			<p class="label">보험 계약 날짜</p>
			<p class="must">*</p>
		</td>
		<td><input type="text" class="form_textbox"></td>
		<td class="form_label">
			<p class="label">보험 만기 날짜</p>
			<p class="must">*</p>
		</td>
		<td class="form_normal-td"><input type="text"
			class="form_textbox"></td>
	</tr>
	</table>
	</form>

</body>
</html>