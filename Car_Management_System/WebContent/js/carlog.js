/**
 * 유효성 검사.
 */

function carlogWriteCheck() {
	if (document.frm.driv_no.value == "") {
		alert("배차 신청 번호를 입력 하세요.");
		document.frm.driv_no.focus();
		return false;
	} else if (document.frm.cour_no.value == "") {
		alert("경로를 선택 하세요.");
		document.frm.cour_no.focus();
		return false;
	} else if (document.frm.driv_purpo.value == "") {
		alert("사용 목적을 입력 하세요.");
		document.frm.driv_purpo.focus();
		return false;
	} else if (document.frm.distance.value == "") {
		alert("정비소 대표 이름을 입력하세요");
		document.frm.distance.focus();
		return false;
	} else {
	var name = document.frm.mem_name.value;
	var isCorrect = confirm(name + "님 차량운행일지를 등록하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}

function carlogSearch(){
	var url = "carlog.do?command=carlog_select"
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function carlogCourseSearch(){
	var url = "carlog.do?command=carlog_course_select_form"
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function splaceSelect(name) {
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.driv_purpo.value = document.getElementsByName(name + "driv_purpo")[0].value;
	opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
	
	self.close();
}

function nocarlogSelect(name) {
	opener.frm.driv_no.value = document.getElementsByName(name + "driv_no")[0].value;
	opener.frm.car_reg_no.value = document.getElementsByName(name + "car_reg_no")[0].value;
	opener.frm.car_model.value = document.getElementsByName(name + "car_model")[0].value;
	opener.frm.mem_name.value = document.getElementsByName(name + "mem_name")[0].value;
	opener.frm.driv_s_date.value = document.getElementsByName(name + "driv_s_date")[0].value;
	opener.frm.driv_e_date.value = document.getElementsByName(name + "driv_e_date")[0].value;
	self.close();
}

function carlogSelect(name) {
	opener.frm.driv_no.value = document.getElementsByName(name + "driv_no")[0].value;
	opener.frm.car_reg_no.value = document.getElementsByName(name + "car_reg_no")[0].value;
	opener.frm.car_model.value = document.getElementsByName(name + "car_model")[0].value;
	opener.frm.mem_name.value = document.getElementsByName(name + "mem_name")[0].value;
	opener.frm.driv_s_date.value = document.getElementsByName(name + "driv_s_date")[0].value;
	opener.frm.driv_e_date.value = document.getElementsByName(name + "driv_e_date")[0].value;
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.driv_purpo.value = document.getElementsByName(name + "driv_purpo")[0].value;
	opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
	switch (document.getElementsByName(name + "card_divi")[0].value) {
	case "법인카드" : 	opener.frm.card_divi.value ="1"; break;
	case "개인카드" :	opener.frm.card_divi.value ="2"; break;
	case "미사용" : 	opener.frm.card_divi.value ="0"; break;
	default : opener.frm.card_divi.value ="0"; break;
	}
	opener.frm.oil_fee.value = document.getElementsByName(name + "oil_fee")[0].value;
	opener.frm.trans_fee.value = document.getElementsByName(name + "trans_fee")[0].value;
	opener.frm.etc_text.value = document.getElementsByName(name + "etc_text")[0].value;
	opener.frm.etc_fee.value = document.getElementsByName(name + "etc_fee")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	self.close();
}