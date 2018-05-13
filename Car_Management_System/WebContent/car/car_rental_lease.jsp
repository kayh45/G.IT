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

	<p class="content_cont-text">*렌탈/리스 정보</p>
	<form name="frm" action=" ">
		<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">회사명</p>
					<p class="must">*</p>
				</td>
				<td colspan="3"><input type="text" class="form_textbox" name ="co_name">
				</td>
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
				<td><input type="text" class="form_textbox" name="ct_date">
				</td>
				<td class="form_label">
					<p class="label">계약 만료 날짜</p>
					<p class="must">*</p>
				</td>
				<td><input type="text" class="form_textbox" name="ep_date">
				</td>

			</tr>
		</table>
		<p class="content_cont-text">*보험 정보</p>
		<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">보험명</p>
					<p class="must">*</p>
				</td>
				<td><input type="text" class="form_textbox" name="bo_name"></td>
				<td class="form_label">
					<p class="label">보험 구분</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td"><select name="bo_divi"
					class="form_car_select">
						<option value="0">선택</option>
						<option value="0">일반 법인 차</option>
						<option value="1">임원 법인 차</option>
				</select></td>
			</tr>
			<tr>
				<td class="form_label">
					<p class="label">보험 나이 제한</p>
					<p class="must">*</p>
				</td>
				<td colspan="3" class="form_normal-td"><input type="text"
					class="form_textbox" name="bo_age"></td>
			</tr>
			<tr>
				<td class="form_label">
					<p class="label">보험 계약 날짜</p>
					<p class="must">*</p>
				</td>
				<td><input type="text" class="form_textbox" name="bo_s_date"></td>
				<td class="form_label">
					<p class="label">보험 만기 날짜</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td"><input type="text"
					class="form_textbox" name="bo_e_date"></td>
			</tr>
		</table>
	</form>
</body>
</html>