<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인 차량 관리 시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
	<p class="content_cont-text">*렌탈/리스 정보</p>
	<table class="table table-bordered" id="form_table">
		<tr>
			<td class="form_label">
				<p class="label">회사명</p>
				<p class="must">*</p>
			</td>
			<td colspan="3"><input type="text" class="form_textbox"
				name="co_name"></td>
		</tr>
		<tr>
			<td class="form_label">
				<p class="label">회사 전화번호</p>
				<p class="must">*</p>
			</td>
			<td class="form_phone-td"><input type="text"
				class="form_textbox" size="6" maxlength="3" name="co_tel1">-<input
				type="text" class="form_textbox" size="6" maxlength="4"
				name="co_tel2">-<input type="text" class="form_textbox"
				size="6" maxlength="4" name="co_tel3"></td>
			<td class="form_label">
				<p class="label">회사 FAX</p>
				<p class="must">*</p>
			</td>
			<td class="form_phone-td"><input type="text"
				class="form_textbox" size="6" maxlength="4" name="co_fax1">-<input
				type="text" class="form_textbox" size="6" maxlength="4"
				name="co_fax2">-<input type="text" class="form_textbox"
				size="6" maxlength="4" name="co_fax3"></td>

		</tr>
		<tr>
			<td class="form_label">
				<p class="label">계약 날짜</p>
				<p class="must">*</p>
			</td>
			<td>
				<div id="ct_date">
					<input type="text" class="form_textbox" name="ct_date">
				</div> <script type="text/javascript">
					$('#ct_date input').datepicker({
						dateFormat : "yy-mm-dd"
					});
				</script>
			</td>
			<td class="form_label">
				<p class="label">계약 만료 날짜</p>
				<p class="must">*</p>
			</td>
			<td>
				<div id="ep_date">
					<input type="text" class="form_textbox" name="ep_date">
				</div> <script type="text/javascript">
					$('#ep_date input').datepicker({
						dateFormat : "yy-mm-dd"
					});
				</script>
			</td>

		</tr>
	</table>
</body>
</html>