/**
 * 
 */
function regiPlace(){
	window.close();
	 window.opener.location.href="place.do?command=place_write_form";
}

function placeNameCheck() {
	document.frm.place_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "course.do?popup=no&command=cour_place_write_check_form&place_name="
			+ encodeURIComponent(document.frm.place_name.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}