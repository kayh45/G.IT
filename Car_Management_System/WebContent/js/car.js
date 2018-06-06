/**
 * 법인차 유효성 검사
 */
function carNoCheck() {

	document.frm.car_reg_no_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "car.do?popup=no&command=car_write_check_form&car_reg_no="
			+ encodeURIComponent(document.frm.car_reg_no.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function carSearch() {
	document.frm.car_reg_no_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "car.do?popup=no&command=car_search&car_reg_no="
			+ encodeURIComponent(document.frm.car_reg_no.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function carSrchSelect(car_reg_no) {

	opener.frm.car_reg_no.value = car_reg_no;
	opener.frm.car_reg_no_ok.value = 1;
	opener.frm.car_usable_no.value = car_reg_no;

	self.close();
}

function useCarNo() {

	opener.frm.car_reg_no.value = document.frm.car_reg_no.value;
	opener.frm.car_reg_no_ok.value = document.frm.car_reg_no_ok.value;
	opener.frm.car_usable_no.value = document.frm.car_reg_no.value;
	/*
	 * if (opener.frm.car_reg_no.value == '') {
	 * opener.document.getElementById("ins_btn").removeAttribute('disabled');
	 * opener.document.getElementById("mod_btn").disabled = "true";
	 * opener.document.getElementById("del_btn").disabled = "true";
	 * opener.frm.action = "car.do?command=car_write"; }
	 */
	opener.frm.action = "car.do?command=car_write";

	self.close();
}

function carSelect(name) {
	/*
	 * 사원 검색에서 사원 이름 누르면 부모 폼으로 들어가는 기능
	 * 
	 */

	if (document.getElementsByName(name + "car_divi")[0].value == "렌트"
			|| document.getElementsByName(name + "car_divi")[0].value == "리스") {
		var frmName = document.getElementsByName(name + "car_reg_no")[0].value;

		opener.frm.car_reg_no.value = document.getElementsByName(name
				+ "car_reg_no")[0].value;
		opener.frm.car_model.value = document.getElementsByName(name
				+ "car_model")[0].value;
		opener.frm.car_divi.value = document.getElementsByName(name
				+ "car_divi")[0].value;
		opener.frm.total_dist.value = document.getElementsByName(name
				+ "total_dist")[0].value;

		opener.frm.bo_name.value = document.getElementsByName(name + "bo_name")[0].value;
		opener.frm.bo_divi.value = document.getElementsByName(name + "bo_divi")[0].value;
		opener.frm.bo_age.value = document.getElementsByName(name + "bo_age")[0].value;
		opener.frm.bo_s_date.value = document.getElementsByName(name
				+ "bo_s_date")[0].value;
		opener.frm.bo_e_date.value = document.getElementsByName(name
				+ "bo_e_date")[0].value;

		opener.frm.co_name.value = document.getElementsByName(name + "co_name")[0].value;

		var tel = document.getElementsByName(name + "co_tel")[0].value;
		var splTel = tel.split("-");
		opener.frm.co_tel1.value = splTel[0];
		opener.frm.co_tel2.value = splTel[1];
		opener.frm.co_tel3.value = splTel[2];
		console.log(splTel);

		var fax = document.getElementsByName(name + "co_fax")[0].value;
		var splFax = fax.split("-");
		opener.frm.co_fax1.value = splFax[0];
		opener.frm.co_fax2.value = splFax[1];
		opener.frm.co_fax3.value = splFax[2];

		opener.frm.ct_date.value = document.getElementsByName(name + "ct_date")[0].value;
		opener.frm.ep_date.value = document.getElementsByName(name + "ep_date")[0].value;

		opener.paycar.style.display = "inline";
		opener.rental_lease.style.display = "inline";

	} else if (document.getElementsByName(name + "car_divi")[0].value == "구입") {
		var frmName = document.getElementsByName(name + "car_reg_no")[0].value;

		opener.frm.car_reg_no.value = document.getElementsByName(name
				+ "car_reg_no")[0].value;

		opener.frm.car_model.value = document.getElementsByName(name
				+ "car_model")[0].value;
		opener.frm.car_divi.value = document.getElementsByName(name
				+ "car_divi")[0].value;
		opener.frm.total_dist.value = document.getElementsByName(name
				+ "total_dist")[0].value;

		opener.frm.bo_name.value = document.getElementsByName(name + "bo_name")[0].value;
		opener.frm.bo_divi.value = document.getElementsByName(name + "bo_divi")[0].value;
		opener.frm.bo_age.value = document.getElementsByName(name + "bo_age")[0].value;
		opener.frm.bo_s_date.value = document.getElementsByName(name
				+ "bo_s_date")[0].value;
		opener.frm.bo_e_date.value = document.getElementsByName(name
				+ "bo_e_date")[0].value;

		opener.paycar.style.display = "inline";
		opener.rental_lease.style.display = "none";

	}
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "car.do?command=car_modify";

	self.close();
}

function carWriteCheckDivided() {

	if (document.frm.car_divi.value.equals("렌트")
			|| document.frm.car_divi.value.equals("리스")) {
		carWriteCheck2();
		return false;
	} else if (document.frm.car_divi.value.equals("구입")) {
		carWriteCheck1();
		return false;
	} else if (document.frm.car_divi.value.equals("선택")) {
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
	} else if (document.frm.car_reg_no_ok.value == "0") {
		alert("차량 등록 번호를 중복 검사 해주세요");
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
	} else if (document.frm.car_reg_no_ok.value == "0") {
		alert("차량 등록 번호를 중복 검사 해주세요");
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
	} else if (document.frm.co_name.value == "") {
		alert("렌트/리스 회사를 입력하세요");
		document.frm.co_name.focus();
		return false;
	} else if (document.frm.co_tel1.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel1.focus();
		return false;
	} else if (document.frm.co_tel2.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel2.focus();
		return false;
	} else if (document.frm.co_tel3.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_tel3.focus();
		return false;
	} else if (document.frm.co_fax1.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax1.focus();
		return false;
	} else if (document.frm.co_fax2.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax2.focus();
		return false;
	} else if (document.frm.co_fax3.value == "") {
		alert("렌트/리스 회사의 연락처를 입력하세요");
		document.frm.co_fax3.focus();
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

function carModifyCheckDivided() {

	if (document.frm.car_divi.value.equals("렌트")
			|| document.frm.car_divi.value.equals("리스")) {
		carWriteCheck2();
	} else if (document.frm.car_divi.value.equals("구입")) {
		carWriteCheck1();
	}
}

function carDelete() {
	
	if (document.frm.car_reg_no.value == "") {
		alert("삭제할 차량을 먼저 선택해 주세요");
		return false;
	} else {
		var name = document.frm.car_model.value;
		var isCorrect = confirm("'" + name + "'을 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "car.do?&command=car_delete&car_reg_no="
					+ document.frm.car_reg_no.value +"&car_model=" + document.frm.car_model.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
}

