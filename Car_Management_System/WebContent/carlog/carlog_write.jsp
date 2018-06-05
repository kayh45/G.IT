<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>운행 일지 작성 :: 법인차량관리시스템</title>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="js/member.js?ver=3"></script>
<script type="text/javascript" src="js/common.js"></script>
<!-- <script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('roadAddress').value = fullRoadAddr;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script> -->
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<c:if test="${message ne null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}
		</div>
	</c:if>
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">운행일지 작성</p>
	</div>
	<form method="post" action="carlog.do?command=carlog_write" name="frm">
		<div class="content_cont-box">
			<p class="content_cont-text">* 운행 기본 정보</p>
			<p class="content_cont-text"></p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">배차 신청 번호</p>
						
					</td>
					<td class="form_normal-td" colspan="3"><input name="driv_no"
						type="text" class="form_textbox"> <input name="drive_no_ok"
						type="hidden" class="form_textbox">

						<button type="button" onClick="memIdCheck();" class="quiet_btn"
							id="idCheck">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button> <!-- 위에 있는거 나중에 js파일로 처리 --></td>
				</tr>
				
				<tr>
					<td class="form_label">
						<p class="label">차량 등록 번호</p>
					
					</td>
					<td><input name="car_reg_no" type="text" class="form_textbox">
						<input name="car_reg_no" type="hidden" class="form_textbox">

					</td>
					<td class="form_label">
						<p class="label">차종</p>
					</td>
					<td class="form_normal-td"><input name="dept_name"
						type="text" class="form_textbox"> <input name="dept_no"
						type="hidden" class="form_textbox"></td>
				</tr>

				<tr>
					<td class="form_label">
						<p class="label">사원 이름</p>
						
					</td>
					<td class="form_normal-td" colspan="3"><input name="mem_id"
						type="text" class="form_textbox"> <input name="mem_id"
						type="hidden" class="form_textbox"></td>
					
				</tr>
				
					<tr>
					<td class="form_label">
						<p class="label">사용 목적</p>
						
					</td>
					<td class="form_normal-td" colspan="3"><input name="driv_purpo"
						type="text" class="form_textbox"> <input name="driv_purpo"
						type="hidden" class="form_textbox"></td>
					
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">출발지</p>
						
					</td>
					<td><input name="dept_name" type="text" class="form_textbox">
						<input name="dept_no" type="hidden" class="form_textbox">

					</td>
					<td class="form_label">
						<p class="label">도착지</p>
					</td>
					<td class="form_normal-td"><input name="dept_name"
						type="text" class="form_textbox"> <input name="dept_no"
						type="hidden" class="form_textbox"></td>
				</tr>
				
				<tr>
			<td class="form_label" >
				<p class="label" >운행기간</p>
			</td>
			
			<td colspan="3">
				<div id="ct_date" colspan="3">
					<input type="text" class="form_textbox" name="ct_date">&nbsp; ~
					<input type="text" class="form_textbox" name="ct_date">
				</div> <script type="text/javascript">
					$('#ct_date input').datepicker({dateFormat : "yy-mm-dd"});
				</script>
			</td>


		</tr>
		
				<tr>
					<td class="form_label">
						<p class="label">주행거리</p>
					</td>
					<td class="form_normal-td" colspan="3"><input name="mem_p_no"
						type="text" id="postcode" size="13" class="form_textbox"> &nbsp;km
					</td>
				</tr>
						</table>
						</div>
						
		<form method="post" action="member.do?command=member_write" name="frm">
		<div class="content_cont-box">
			<p class="content_cont-text">* 추가 입력 정보</p>
			<p class="content_cont-text"></p>
			<table class="table table-bordered" id="form_table">
					
					<tr>
						<td class = "form_label">
							<p class = "label">카드 구분</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<div class = "radio-group">
								<input type = "radio" value = "0" name = "mem_auth" checked>법인카드
								<input type = "radio" value = "1" name = "mem_auth">개인카드
								<input type = "radio" value = "2" name = "mem_auth">미사용
								
							</div>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label"></p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<div class = "radio-group">
								<input type = "checkbox" value = "0" name = "carlog_auth" checked>유류비
								<input name="dept_name"
						type="text" class="form_textbox">원
								
							</div>
						</td>
					</tr>
					
					<tr>
						<td class = "form_label">
							<p class = "label">비용 구분</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<div class = "radio-group">
								<input type = "checkbox" value = "0" name = "carlog2_auth" checked>교통비
								<input name="dept_name"
						type="text" class="form_textbox">원
								
							</div>
						</td>
					</tr>
					
						<tr>
						<td class = "form_label">
							<p class = "label"></p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<div class = "radio-group">
								<input type = "checkbox" value = "0" name = "carlog2_auth" checked>기타(직접 입력)
								<input name="dept_name"
						type="text" class="form_textbox">
								<input name="dept_name"
						type="text" class="form_textbox">원
								
							</div>
						</td>
					</tr>
					
					
			
			
			</table>
			</div>
			
			
		
		<div class="form_btn-group">
		<button id = "ins_btn" type = "submit" onclick = "return deptWriteCheck()">등록</button>
					<button id = "mod_btn" type = "submit" onclick = "return deptWriteCheck()" disabled>수정</button>
					<button id = "del_btn" type = "button" onclick = "deptDelete()" disabled>삭제</button>
		</div>
	</form>
	</section> </section>
</body>
</html>
<!-- 
TODO 
- 이미 저장되어있는 정보 가져오는 부분 만들기 
- 모바일에 맞게 CSS등 수정
-->