/**
 정비등록 스크립트
 */

function repaNameCheck() {
	if (document.frm.car_reg_no.value == "") {
		alert('차량등록번호를 입력하세요');
		document.frm.cent_name.focus();
		return;
	}
	document.frm.car_reg_no_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "repa.do?popup=no&command=repa_car_write_check_form&car_reg_no="
			+ encodeURIComponent(document.frm.car_reg_no.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function centNameCheck() {
	document.frm.cent_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "repa.do?popup=no&command=repa_cent_write_check_form&cent_name="
		+ encodeURIComponent(document.frm.cent_name.value);
window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
	
}

function repaCentSelect(cent_no, cent_name) {
	/*
	 * repa_cent_check.jsp 에서 사용
	 * 
	 * 정비소명 을 검색하고 정비소명을 누르면 해당 정비소의 정비소명과 정비번호가 부모화면의 폼으로 들어간다.
	 * 
	 */
	opener.frm.cent_no.value = cent_no;
	opener.frm.cent_name.value = cent_name;
	self.close();
}
function regiCent(){
	window.close();
	 window.opener.location.href="cent.do?command=cent_write_form";

	
}


function useRepaName() {

	opener.frm.cent_name.value = document.frm.cent_name.value;
	opener.frm.cent_usable_name.value = document.frm.cent_name.value;
	opener.frm.cent_name_ok.value = document.frm.cent_name_ok.value;
	if (opener.frm.cent_no.value == '') {
		opener.document.getElementById("ins_btn").removeAttribute('disabled');
		opener.document.getElementById("mod_btn").disabled = "true";
		opener.document.getElementById("del_btn").disabled = "true";
		opener.frm.action = "cent.do?command=cent_write";
	}
	self.close();
}