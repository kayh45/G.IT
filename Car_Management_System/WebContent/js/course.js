/**
 * 
 */
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
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}
function eplaceNameCheck() {
	document.frm.e_place_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "course.do?popup=no&command=cour_eplace_write_check_form&e_place_name="
		+ encodeURIComponent(document.frm.e_place_name.value);
	window
	.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}


function placeSelect(name) {
	/*
	 * 사원 검색에서 사원 이름 누르면 부모 폼으로 들어가는 기능 
	 * 
	 */
	
	var frmName = document.getElementsByName(name + "s_place_name")[0].value;	
	
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	
	
	opener.frm.s_place_addr.value = document.getElementsByName(name + "s_place_addr")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "course.do?command=cour_modify";
	self.close();
}