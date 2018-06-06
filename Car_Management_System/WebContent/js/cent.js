/**
 * 정비소 유효성 및 동적 스크립트
 */

function centWriteCheck() {
	if (document.frm.cent_name.value == "") {
		alert("정비소 이름을 입력하세요");
		document.frm.cent_name.focus();
		return false;
	} else if (document.frm.cent_name_ok.value == "0") {
		alert("정비소 이름 중복체크를 해주세요");
		document.frm.cent_name.focus();
		return false;
	} else if (document.frm.ceo_name.value == "") {
		alert("정비소 대표 이름을 입력하세요");
		document.frm.ceo_name.focus();
		return false;
	} else if (document.frm.ceo_name.value == "") {
		alert("정비소 대표 이름을 입력하세요");
		document.frm.ceo_name.focus();
		return false;
	}  else if (document.frm.cent_tell1.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell1.focus();
		return false;
	} else if (document.frm.cent_tell2.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell2.focus();
		return false;
	} else if (document.frm.cent_tell3.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell3.focus();
		return false;
	} else if (document.frm.cent_fax1.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax1.focus();
		return false;
	}else if (document.frm.cent_fax2.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax2.focus();
		return false;
	}else if (document.frm.cent_fax3.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax3.focus();
		return false;
	}
	else if (document.frm.cent_addr.value == ""
			&& document.frm.cent_addr_dtl.value != "") {
		alert("상세주소를 지우거나 주소를 입력해주세요");
		document.frm.cent_addr2.focus();
		return false;
}else {
	var name = document.frm.cent_name.value;
	var isCorrect = confirm(name + " 정비소를 등록하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}

function centModifyCheck() {
	if (document.frm.cent_name.value == "") {
		alert("정비소 이름을 입력하세요");
		document.frm.cent_name.focus();
		return false;
	}  else if (document.frm.ceo_name.value == "") {
		alert("정비소 대표 이름을 입력하세요");
		document.frm.ceo_name.focus();
		return false;
	} else if (document.frm.ceo_name.value == "") {
		alert("정비소 대표 이름을 입력하세요");
		document.frm.ceo_name.focus();
		return false;
	}  else if (document.frm.cent_tell1.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell1.focus();
		return false;
	} else if (document.frm.cent_tell2.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell2.focus();
		return false;
	} else if (document.frm.cent_tell3.value == "") {
		alert("대표전화를 입력하세요");
		document.frm.cent_tell3.focus();
		return false;
	} else if (document.frm.cent_fax1.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax1.focus();
		return false;
	}else if (document.frm.cent_fax2.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax2.focus();
		return false;
	}else if (document.frm.cent_fax3.value == "") {
		alert("팩스 번호를 입력하세요");
		document.frm.cent_fax3.focus();
		return false;
	}
	else if (document.frm.cent_addr.value == ""
			&& document.frm.cent_addr_dtl.value != "") {
		alert("상세주소를 지우거나 주소를 입력해주세요");
		document.frm.cent_addr_dtl.focus();
		return false;
}else {
	var name = document.frm.cent_name.value;
	var isCorrect = confirm(name + " 정비소를을 수정하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}

function centDelete() {
	if (document.frm.cent_no.value == "") {
		alert("삭제할 정비소를 먼저 선택해 주세요");
		return false;
	} else {
		var name = document.frm.cent_name.value;
		var isCorrect = confirm("'" + name + "'을 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "cent.do?&command=cent_delete&cent_no="
					+ document.frm.cent_no.value +"&cent_name=" + document.frm.cent_name.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

function useCentName() {

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

/*function modCentSelect(cent_no, cent_name, ceo_name, cent_tell1, cent_tell2, cent_tell3, 
		cent_fax1, cent_fax2, cent_fax3, cent_p_no, cent_addr1, cent_addr2) {

	opener.frm.cent_no.value = cent_no;
	opener.frm.cent_name.value = "";
	opener.frm.pre_cent_name.value = cent_name;
	opener.frm.ceo_name.value = ceo_name;
	opener.frm.cent_tell1.value = cent_tell1;
	opener.frm.cent_tell2.value = cent_tell2;
	opener.frm.cent_tell3.value = cent_tell3;
	opener.frm.cent_fax1.value = cent_fax1;
	opener.frm.cent_fax2.value = cent_fax2;
	opener.frm.cent_fax3.value = cent_fax3;
	opener.frm.cent_p_no.value = cent_p_no;
	opener.frm.cent_addr1.value = cent_addr1;
	opener.frm.cent_addr2.value = cent_addr2;
	opener.document.getElementById("hdn_label").style.visibility = "visible";
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "cent.do?command=cent_modify";
	self.close();
}*/

function centSelect(name) {
	/*
	 * 사원 검색에서 사원 이름 누르면 부모 폼으로 들어가는 기능 
	 * 
	 */
	opener.frm.car_reg_no_ok.value = 1;

	var frmName = document.getElementsByName(name + "cent_name")[0].value;	
	
	opener.frm.cent_no.value = document.getElementsByName(name + "cent_no")[0].value;
	opener.frm.cent_name.value = document.getElementsByName(name + "cent_name")[0].value;
	
	
	opener.frm.ceo_name.value = document.getElementsByName(name + "ceo_name")[0].value;


	var tell = document.getElementsByName(name + "cent_tell")[0].value;
	opener.frm.cent_tell1.value = tell.substr(0,3);
	opener.frm.cent_tell2.value = tell.substr(3,4);
	opener.frm.cent_tell3.value = tell.substr(7,4);
	
	var fax = document.getElementsByName(name + "cent_fax")[0].value;
	opener.frm.cent_fax1.value = tell.substr(0,3);
	opener.frm.cent_fax2.value = tell.substr(3,4);
	opener.frm.cent_fax3.value = tell.substr(7,4);
	
	opener.frm.cent_p_no.value = document.getElementsByName(name + "cent_p_no")[0].value;
	opener.frm.cent_addr.value = document.getElementsByName(name + "cent_addr")[0].value;
	opener.frm.cent_addr_dtl.value = document.getElementsByName(name + "cent_addr_dtl")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "cent.do?command=cent_modify";
	self.close();
}

function centNameCheck() {
	var url = "cent.do?popup=no&command=cent_write_check_form&cent_name="
			+ encodeURIComponent(document.frm.cent_name.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}


