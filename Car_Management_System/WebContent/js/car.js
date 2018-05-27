/**
 * 법인차 유효성 검사
 */

function carWriteCheckDivided() {

	if (document.frm.car_divi.equals("2") || document.frm.car_divi.equals("3")) {
		carWriteCheck2();
		return false;
	} else if (document.frm.car_divi.equals("1")) {
		carWriteCheck1();
		return false;
	} else if (document.frm.car_divi.equals("0")) {
		alert("법인차 구분을 선택하세요");
		document.frm.car_divi.focus();
		return false;
	}
}



function carWriteCheck1() {
	if (document.frm.car_reg_no.value == "") {
		alert("차량 등록 번호를 입력하세요");
		document.frm.car_reg_no.focus();
		return false;
	} else if (document.frm.car_model.value == "") {
		alert("차종을 입력해주세요");
		document.frm.car_model.focus();
		return false;
	} else if (document.frm.total_dist.value == "") {
		alert("주행거리를 입력하세요");
		document.frm.total_dist.focus();
		return false;
	} else if (document.frm.bo_name.value == "") {
		alert("보험 이름을 입력하세요");
		document.frm.bo_name.focus();
		return false;
	} else if (document.frm.bo_divi.value == "") {
		alert("보험 구분을 입력하세요");
		document.frm.bo_divi.focus();
		return false;
	} else if (document.frm.bo_age.value == "") {
		alert("보험 나이제한을 입력하세요");
		document.frm.bo_age.focus();
		return false;
	} else if (document.frm.bo_s_date.value == "") {
		alert("보험 계약 날짜를 입력하세요");
		document.frm.bo_s_date.focus();
		return false;
	} else if (document.frm.bo_e_date.value == "") {
		alert("보험 만기 날짜를 입력하세요");
		document.frm.bo_e_date.focus();
		return false;
	} else {
		var name = document.frm.car_reg_no.value;
		var isCorrect = confirm(name + " 법인차를 등록하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function carWriteCheck2() {
	if (document.frm.car_reg_no.value == "") {
		alert("차량 등록 번호를 입력하세요");
		document.frm.car_reg_no.focus();
		return false;
	}  else if (document.frm.car_model.value == "") {
		alert("차종을 입력해주세요");
		document.frm.car_model.focus();
		return false;
	} else if (document.frm.total_dist.value == "") {
		alert("주행거리를 입력하세요");
		document.frm.total_dist.focus();
		return false;
	} else if (document.frm.bo_name.value == "") {
		alert("보험 이름을 입력하세요");
		document.frm.bo_name.focus();
		return false;
	} else if (document.frm.bo_divi.value == "") {
		alert("보험 구분을 입력하세요");
		document.frm.bo_divi.focus();
		return false;
	} else if (document.frm.bo_age.value == "") {
		alert("보험 나이제한을 입력하세요");
		document.frm.bo_age.focus();
		return false;
	} else if (document.frm.bo_s_date.value == "") {
		alert("보험 계약 날짜를 입력하세요");
		document.frm.bo_s_date.focus();
		return false;
	} else if (document.frm.bo_e_date.value == "") {
		alert("보험 만기 날짜를 입력하세요");
		document.frm.bo_e_date.focus();
		return false;
	}else if (document.frm.co_name.value == "") {
		alert("렌트/리스 회사를 입력하세요");
		document.frm.co_name.focus();
		return false;
	}else if (document.frm.co_tel1.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel1.focus();
		return false;
	} else if (document.frm.co_tel2.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel2.focus();
		return false;
	}else if (document.frm.co_tel3.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel3.focus();
		return false;
	}else if (document.frm.co_fax1.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax1.focus();
		return false;
	}else if (document.frm.co_fax2.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax2.focus();
		return false;
	}else if (document.frm.co_fax3.value == "") {
		alert("렌탈/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax3.focus();
		return false;
	}else {
		var name = document.frm.car_reg_no.value;
		var isCorrect = confirm(name + " 법인차를 등록하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function carModifyCheckDivided() {

	if (document.frm.car_divi.equals("2") || document.frm.car_divi.equals("3")) {
		carWriteCheck2();
	} else if (document.frm.car_divi.equals("1")) {
		carWriteCheck1();
	}
}