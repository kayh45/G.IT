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
				<td>				
					<div id = "bo_s_date">
						<input type="text" class="form_textbox" name = "bo_s_date">
					</div>
					<script type="text/javascript">
						$('#bo_s_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">보험 만기 날짜</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "bo_e_date">
						<input type="text" class="form_textbox" name = "bo_e_date">
					</div>
					<script type="text/javascript">
						$('#bo_e_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>										
					</td>
			</tr>
		</table>
</body>
</html>