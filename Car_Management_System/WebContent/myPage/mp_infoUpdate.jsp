<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/member.js?ver=2"></script>
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
	<header>
			<%@ include file = "../header.jsp" %>
			<!-- 헤더 -->
	</header>
	<section id = "main">
		<aside id = "side">
			<%@ include file = "sideMenu.jsp" %>
		</aside>
		<section id = "content">
			<c:if test = "${message ne null}">
				<div class="alert alert-success alert-dismissible" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  ${message}
				</div>
			</c:if>	
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-search" aria-hidden="true">
				</span>
				<p class = "content_title-text">내 정보 수정</p>
			</div>
			<form method = "post" action = "member.do?command=member_modify" name = "frm">
			<div class = "content_cont-box">
				<p class = "content_cont-text">
					* 사원 기본 정보
				</p>			
				<table class="table table-bordered" id = "form_table">
					<tr>
						<td class = "form_label">
							<p class = "label">사원 아이디</p>
							<p class = "must">*</p>					
						</td>
						<td class = "form_normal-td" colspan = "3">
							<input value = "${LoginUser.mem_id}" name = "mem_id" type = "text" class = "form_textbox" readonly>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">사원 이름</p>
							<p class = "must">*</p>			
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input value = "${LoginUser.mem_name}" name = "mem_name" type = "text" class = "form_textbox">
						</td>						
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">주민등록번호</p>
							<p class = "must">*</p>			
						</td>
						<td class = "form_jumin-td" colspan = "3">
							<input value = "${fn:substring(LoginUser.mem_jumin,0,6)}" name = "mem_jumin1" type = "text" size = "6" maxlength="6" class = "form_textbox" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input value = "${fn:substring(LoginUser.mem_jumin,6,13)}" name = "mem_jumin2" type = "text" size = "7" maxlength="7" class = "form_textbox" onBlur = "onlyNumber2(this)">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">부서</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input value = "${LoginUser.dept_name}" name = "dept_name" type = "text" class = "form_textbox">
							<input value = "${LoginUser.dept_no}" name = "dept_no" type = "hidden" class = "form_textbox">
							<button type = "button" onClick = "deptSearch();" class = "quiet_btn">
								<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</td>
						<td class = "form_label">
							<p class = "label">직책</p>		
						</td>
						<c:choose>
							<c:when test="${LoginUser.mem_posi eq '인턴'}">
								<c:set var = "mem_posi" value = "1"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '사원'}">
								<c:set var = "mem_posi" value = "2"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '대리'}">
								<c:set var = "mem_posi" value = "3"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '팀장'}">
								<c:set var = "mem_posi" value = "4"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '그룹장'}">
								<c:set var = "mem_posi" value = "5"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '임원'}">
								<c:set var = "mem_posi" value = "6"></c:set>
							</c:when>
							<c:when test="${LoginUser.mem_posi eq '사장'}">
								<c:set var = "mem_posi" value = "7"></c:set>
							</c:when>
						</c:choose>						
						<td class = "form_normal-td" >
						<script type="text/javascript">
							function memPosi(){
								  document.getElementsByName("mem_posi")[0].value = ${mem_posi};
								 }
							window.onload = memPosi;
						</script>
							<select name = "mem_posi" class = "form_textbox">
								<option value = "0">==선택==</option>
								<option value = "1">인턴</option>
								<option value = "2">사원</option>
								<option value = "3">대리</option>
								<option value = "4">팀장</option>
								<option value = "5">그룹장</option>
								<option value = "6">임원</option>
								<option value = "7">사장</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">휴대전화</p>
							<p class = "must">*</p>					
						</td>
						<td colspan = "3" class = "form_phone-td">
							<input value = "${fn:substring(LoginUser.mem_hp,0,3)}" name = "mem_hp1" type = "text" class = "form_textbox" size = "6" maxlength="3" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input value = "${fn:substring(LoginUser.mem_hp,3,7)}" name = "mem_hp2" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
							<p>-</p>
							<input value = "${fn:substring(LoginUser.mem_hp,7,11)}" name = "mem_hp3" type = "text" class = "form_textbox" size = "6" maxlength="4" onBlur = "onlyNumber2(this)">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">우편번호</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input value = "${LoginUser.mem_p_no}" name = "mem_p_no" type = "text" id = "postcode" size = "13" class = "form_textbox" readonly>
						</td>
					</tr>	
					<tr>
						<td class = "form_label">
							<p class = "label">주소</p>				
						</td>
						<td class = "form_normal-td"  colspan = "3">
							<input  value = "${LoginUser.mem_addr}" name = "mem_addr1" type = "text" id = "roadAddress" class = "form_textbox" readonly>
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
							<input value = "${LoginUser.mem_addr_dtl}" name = "mem_addr2" type = "text" id = "roadAddress-detail" class = "form_textbox">
						</td>
					</tr>											
				</table>
			</div>
			<input type = "hidden" name = "mem_auth" value = "${LoginUser.mem_auth}">
			<input type = "hidden" name = "isMypage" value = "1">
			<div class = "form_btn-group">
				<button id = "mod_btn" type = "submit" onclick = "return memModifyCheck()">수정</button>
				<button id = "del_btn" type = "button" onclick = "memberDelete()">탈퇴</button>
			</div>
			</form>
		</section>
	</section>
</body>
</html>