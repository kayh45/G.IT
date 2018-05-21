<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인차량관리시스템</title>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
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
</script>
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
				<td class="form_normal-td"><input type="text"
					class="form_textbox" name="cent_name"></td>
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
							<input  name = "cent_addr1" type = "text" id = "roadAddress" class = "form_textbox" readonly>
							<button type = "button" onClick = "execDaumPostcode();" class = "quiet_btn">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">상세 주소</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input name = "cent_addr2" type = "text" id = "roadAddress-detail" class = "form_textbox">
						</td>
					</tr>


		</table>
	</div>
	<div class="form_btn-group">
		<button id="ins_btn" type="submit" >등록</button>
		<button id="mod_btn" type="submit" >수정</button>
		<button id="del_btn" type="button" >삭제</button>
	</div>
	</form>
	</section> </section>
</body>
</html>