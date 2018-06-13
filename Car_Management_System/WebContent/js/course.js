/**
 * 
 */

function courseWrite(){
	if (document.frm.s_place_name.value == "") {
		alert("출발지를 입력하세요");
		document.frm.s_place_name.focus();
		return false;
	} else if (document.frm.e_place_name.value == "") {
		alert("도착지를 입력하세요");
		document.frm.e_place_name.focus();
		return false;
	} else if (document.frm.cour_purpo.value == "") {
		alert("경로 목적을 입력하세요");
		document.frm.cour_purpo.focus();
		return false;
	} else if (document.frm.distance.value == "") {
		alert("경로 거리를 입력하세요");
		document.frm.distance.focus();
		return false;
	} else {
		var isCorrect = confirm("경로로 등록하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}
function courseModify(){
	if(document.frm.cour_no.value == ""){
		alert("경로를 선택해주세요.");
		document.frm.cour_no.focus();
		return false;
	}else if (document.frm.s_place_name.value == "") {
		alert("출발지를 입력하세요");
		document.frm.s_place_name.focus();
		return false;
	} else if (document.frm.e_place_name.value == "") {
		alert("도착지를 입력하세요");
		document.frm.e_place_name.focus();
		return false;
	} else if (document.frm.cour_purpo.value == "") {
		alert("경로 목적을 입력하세요");
		document.frm.cour_purpo.focus();
		return false;
	} else if (document.frm.distance.value == "") {
		alert("경로 거리를 입력하세요");
		document.frm.distance.focus();
		return false;
	} 
	else {
		var isCorrect = confirm("경로를 경로로 수정하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}
function courseDelete() {
	
	if (document.frm.cour_no.value == "") {
		alert("삭제할 경로를 먼저 선택해 주세요");
		return false;
	} else {
		var isCorrect = confirm("선택 한 경로를 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "course.do?&command=cour_delete&cour_no="
					+ document.frm.cour_no.value +"&cour_no=" + document.frm.cour_no.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
}



function regiPlace(){
	window.close();
	 window.opener.location.href="place.do?command=place_write_form";
}

function splaceNameCheck() {
	document.frm.s_place_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "course.do?popup=no&command=cour_splace_write_check_form&s_place_name="
			+ encodeURIComponent(document.frm.s_place_name.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=400");
}
function eplaceNameCheck() {
	document.frm.e_place_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "course.do?popup=no&command=cour_eplace_write_check_form&e_place_name="
		+ encodeURIComponent(document.frm.e_place_name.value);
	window
	.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=400");
}


function courseSelect(name) {
	opener.frm.cour_no.value = document.getElementsByName(name + "cour_no")[0].value;
	opener.frm.s_place_no.value = document.getElementsByName(name + "s_place_no")[0].value;
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.s_place_addr.value = document.getElementsByName(name + "s_place_addr")[0].value;
	opener.frm.s_place_divi.value = document.getElementsByName(name + "s_place_divi")[0].value;
	opener.frm.e_place_no.value = document.getElementsByName(name + "e_place_no")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.e_place_addr.value = document.getElementsByName(name + "e_place_addr")[0].value;
	opener.frm.e_place_divi.value = document.getElementsByName(name + "e_place_divi")[0].value;
	opener.frm.cour_purpo.value = document.getElementsByName(name + "cour_purpo")[0].value;
	opener.frm.cour_divi.value = document.getElementsByName(name + "cour_divi")[0].value;
	opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "course.do?command=cour_modify";
	self.close();
}

function splaceSelect(name) {
	
	opener.frm.s_place_no.value = document.getElementsByName(name + "s_place_no")[0].value;
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.s_place_addr.value = document.getElementsByName(name + "s_place_addr")[0].value;
	opener.frm.s_place_divi.value = document.getElementsByName(name + "s_place_divi")[0].value;
	self.close();

}
function eplaceSelect(name) {
	opener.frm.e_place_no.value = document.getElementsByName(name + "e_place_no")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.e_place_addr.value = document.getElementsByName(name + "e_place_addr")[0].value;
	opener.frm.e_place_divi.value = document.getElementsByName(name + "e_place_divi")[0].value;
	self.close();

}


function courSearch(){
	var url = "course.do?command=cour_select_form"
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=400");
}

