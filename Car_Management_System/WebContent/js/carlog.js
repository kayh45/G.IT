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

function carlongSearch(){
	var url = "carlog.do?command=carlog_select_form"
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}