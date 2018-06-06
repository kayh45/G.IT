/**
 * 장소 유효성 및 동적 스크립트
 */

function placeWriteCheck() {
	if (document.frm.place_name.value == "") {
		alert("장소명을 입력하세요");
		document.frm.place_name.focus();
		return false;
	} else if (document.frm.place_name_ok.value == "0") {
		alert("장소명을 중복체크를 해주세요");
		document.frm.place_name_ok.focus();
		return false;
	} else if (document.frm.place_p_no.value == "") {
		alert("우편번호를 입력하세요");
		document.frm.place_p_no.focus();
		return false;
	} else if (document.frm.place_addr.value == "") {
		alert("주소를 입력하세요");
		document.frm.place_addr.focus();
		return false;
	}  else if (document.frm.place_addr_dtl.value == "") {
		alert("상세 주소를 입력하세요");
		document.frm.place_addr_dtl.focus();
		return false;
	} 
	else {
	var name = document.frm.place_name.value;
	var isCorrect = confirm(name + " 장소를 등록 하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}

function placeModifyCheck() {
	if (document.frm.place_name.value == "") {
		alert("장소명을 입력하세요");
		document.frm.cent_name.focus();
		return false;
	} else if (document.frm.place_p_no.value == "") {
		alert("우편번호를 입력하세요");
		document.frm.place_p_no.focus();
		return false;
	} else if (document.frm.place_addr.value == "") {
		alert("주소를 입력하세요");
		document.frm.place_addr.focus();
		return false;
	}  else if (document.frm.place_addr_dtl.value == "") {
		alert("상세 주소를 입력하세요");
		document.frm.place_addr_dtl.focus();
		return false;
	} 
	else {
		var name = document.frm.place_name.value;
		var isCorrect = confirm(name + " 장소를 수정 하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function placeDelete() {
	if (document.frm.place_no.value == "") {
		alert("삭제할 정비소를 먼저 선택해 주세요");
		return false;
	} else {
		var name = document.frm.place_name.value;
		var isCorrect = confirm("'" + name + "'을 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "place.do?&command=place_delete&place_no="
					+ document.frm.place_no.value +"&place_name=" + document.frm.place_name.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

function usePlaceName() {

	opener.frm.place_name.value = document.frm.place_name.value;
	opener.frm.place_usable_name.value = document.frm.place_name.value;
	opener.frm.place_name_ok.value = document.frm.place_name_ok.value;
	if (opener.frm.place_no.value == '') {
		opener.document.getElementById("ins_btn").removeAttribute('disabled');
		opener.document.getElementById("mod_btn").disabled = "true";
		opener.document.getElementById("del_btn").disabled = "true";
		opener.frm.action = "place.do?command=place_write";
	}
	self.close();
}

function placeSelect(name) {
	/*
	 * 사원 검색에서 사원 이름 누르면 부모 폼으로 들어가는 기능 
	 * 
	 */
	
	var frmName = document.getElementsByName(name + "place_name")[0].value;	
	
	opener.frm.place_no.value = document.getElementsByName(name + "place_no")[0].value;
	opener.frm.place_name.value = document.getElementsByName(name + "place_name")[0].value;
	
	
	opener.frm.place_p_no.value = document.getElementsByName(name + "place_p_no")[0].value;
	opener.frm.place_addr.value = document.getElementsByName(name + "place_addr")[0].value;
	opener.frm.place_addr_dtl.value = document.getElementsByName(name + "place_addr_dtl")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "place.do?command=place_modify";
	self.close();
}

function placeNameCheck() {
	document.frm.place_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "place.do?popup=no&command=place_write_check_form&place_name="
			+ encodeURIComponent(document.frm.place_name.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}



