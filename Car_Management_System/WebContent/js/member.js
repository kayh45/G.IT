function deptNamecheck() {
	if (document.frm.dept_name.value == "") {
		alert('부서명을 입력하세요');
		document.frm.dept_name.focus();
		return;
	}
	document.frm.dept_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "member.do?popup=no&command=dept_write_check_form&dept_name="
			+ encodeURIComponent(document.frm.dept_name.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function memIdCheck() {
	if (document.frm.mem_id.value == "") {
		alert('아이디를 입력하세요');
		document.frm.mem_id.focus();
		return;
	}
	document.frm.mem_id_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "member.do?popup=no&command=member_id_check&mem_id="
			+ encodeURIComponent(document.frm.mem_id.value);
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function useMemID() {
	opener.frm.mem_id.value = document.frm.mem_id.value;
	opener.frm.mem_usable_id = document.frm.mem_id.value;
	opener.frm.mem_id_ok.value = document.frm.mem_id_ok.value;
	self.close();
}

function useDeptName() {
	/*
	 * @deptCheck.jsp 에서 사용
	 * 
	 * 부서명을 검색하고 사용버튼을 누르게 되면 해당 내용이 부모 화면의 폼에 들어간다. 중복 검사를 통해 나온 값을 숨겨진
	 * input타입에 값을 넣어준다. 부모 화면의 부서번호가 비어있으면 등록 버튼을 활성화하고 부모화면의 폼의 action을 등록에
	 * 맞춘다.
	 *  # 숨겨진 input 타입 dept_usable_name -> 중복 검사를 진행한 부서명 dept_name_ok -> 중복 검사가
	 * 진행됐는지에 대한 여부
	 * 
	 */
	opener.frm.dept_name.value = document.frm.dept_name.value;
	opener.frm.dept_usable_name.value = document.frm.dept_name.value;
	opener.frm.dept_name_ok.value = document.frm.dept_name_ok.value;
	if (opener.frm.dept_no.value == '') {
		opener.document.getElementById("ins_btn").removeAttribute('disabled');
		opener.document.getElementById("mod_btn").disabled = "true";
		opener.document.getElementById("del_btn").disabled = "true";
		opener.frm.action = "member.do?command=dept_write";
	}
	self.close();
}

function deptDelete() {
	var name = document.frm.pre_dept_name.value;
	var isCorrect = confirm("'" + name + "'을 삭제하시겠습니까?");
	if (isCorrect == true) {
		var url = "member.do?&command=dept_delete&dept_no="
				+ document.frm.dept_no.value;
		location.replace(url);
	} else {
		return false;
	}
}

function modDeptSelect(dept_no, dept_name) {
	/*
	 * @deptCheck.jsp 에서 사용
	 * 
	 * 부서명을 검색하고 부서명을 누르면 해당 부서의 부서번호와 부서명이 부모화면의 폼으로 들어간다. 부모 화면의 등록버튼을 비활성화하고
	 * 수정, 삭제 버튼을 활성화 한다. 현재 선택된 부서명을 pre_dept_name에 넣고 visible시킨다.
	 * 
	 */
	opener.frm.dept_no.value = dept_no;
	opener.frm.dept_name.value = "";
	opener.frm.pre_dept_name.value = dept_name;
	opener.document.getElementById("hdn_label").style.visibility = "visible";
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	opener.frm.action = "member.do?command=dept_modify";
	self.close();
}

function memWriteDeptSelect(dept_no, dept_name) {
	/*
	 * @deptSearch.jsp 에서 사용
	 * 
	 * 부서명을 검색하고 부서명을 누르면 해당 부서의 부서번호와 부서명이 부모화면의 폼으로 들어간다.
	 * 
	 */
	opener.frm.dept_no.value = dept_no;
	opener.frm.dept_name.value = dept_name;
	self.close();
}

function deptSearch() {
	/*
	 * @deptSearch.jsp 에서 사용
	 * 
	 * 
	 */
	var url = "member.do?popup=no&command=dept_search&dept_name="
			+ encodeURIComponent(document.frm.dept_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function memSearchByName() {
	/*
	 * @member_search.jsp 에서 사용
	 * 
	 * 
	 */
	var url = "member.do?popup=no&command=member_search&mem_name="
			+ encodeURIComponent(document.frm.mem_search_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function memSelect(name) {
	/*
	 * 사원 검색에서 사원 이름 누르면 부모 폼으로 들어가는 기능 
	 * 
	 */
	
	var frmName = document.getElementsByName(name + "mem_id")[0].value;	
	
	opener.frm.mem_id.value = document.getElementsByName(name + "mem_id")[0].value;
	opener.frm.mem_name.value = document.getElementsByName(name + "mem_name")[0].value;
	
	var jumin = document.getElementsByName(name + "mem_jumin")[0].value;
	opener.frm.mem_jumin1.value = jumin.substr(0,6);
	opener.frm.mem_jumin2.value = jumin.substr(6,7);
	
	var hp = document.getElementsByName(name + "mem_hp")[0].value;
	opener.frm.mem_hp1.value = hp.substr(0,3);
	opener.frm.mem_hp2.value = hp.substr(3,4);
	opener.frm.mem_hp3.value = hp.substr(7,4);
	
	opener.frm.mem_p_no.value = document.getElementsByName(name + "mem_p_no")[0].value;
	opener.frm.mem_addr1.value = document.getElementsByName(name + "mem_addr")[0].value;
	opener.frm.mem_addr2.value = document.getElementsByName(name + "mem_addr_dtl")[0].value;
	opener.frm.mem_auth.value = document.getElementsByName(name + "mem_auth")[0].value;
	switch (document.getElementsByName(name + "mem_posi")[0].value) {
		case "인턴" : 	opener.frm.mem_posi.value ="1"; break;
		case "사원" :	opener.frm.mem_posi.value ="2"; break;
		case "대리" : 	opener.frm.mem_posi.value ="3"; break;
		case "팀장" : 	opener.frm.mem_posi.value ="4"; break;
		case "그룹장" : 	opener.frm.mem_posi.value ="5"; break;
		case "임원" : 	opener.frm.mem_posi.value ="6"; break;
		case "사장" : 	opener.frm.mem_posi.value ="7"; break;
		default : opener.frm.mem_posi.value ="0"; break;
	}
	opener.frm.dept_no.value = document.getElementsByName(name + "dept_no")[0].value;
	opener.frm.dept_name.value = document.getElementsByName(name + "dept_name")[0].value;
	self.close();
}

function deptWriteCheck() {
	if (document.frm.dept_name.value == "") {
		alert("부서명을 입력하세요.");
		document.frm.dept_name.focus();
		return false;
	} else if (document.frm.dept_name_ok.value == "0") {
		alert("부서명을 확인해주세요");
		document.frm.dept_name.focus();
		return false;
	} else if (document.frm.dept_name_ok.value == "0"
			&& document.frm.dept_no.value != "") {
		alert("수정할 수 없는 부서명입니다.");
		document.frm.dept_name.focus();
		return false;
	} else {
		var name = document.frm.dept_usable_name.value;
		var isCorrect = confirm("부서명이 '" + name + "'이 확실합니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function memWriteCheck() {
	if (document.frm.mem_id.value == "") {
		alert("아이디를 입력하세요.");
		document.frm.mem_id.focus();
		return false;
	} else if (document.frm.mem_id_ok.value == "0") {
		alert("아이디 중복체크를 해주세요");
		document.frm.dept_name.focus();
		return false;
	} else if (document.frm.mem_name.value == "") {
		alert("이름을 입력하세요");
		document.frm.mem_name.focus();
		return false;
	} else if (document.frm.mem_jumin1.value == "") {
		alert("주민등록번호를 입력하세요");
		document.frm.mem_jumin1.focus();
		return false;
	} else if (document.frm.mem_jumin2.value == "") {
		alert("주민등록번호를 입력하세요");
		document.frm.mem_jumin2.focus();
		return false;
	} else if (document.frm.dept_no.value == "") {
		alert("부서를 확인해주세요");
		document.frm.dept_name.focus();
		return false;
	} else if (document.frm.mem_posi.value == "0") {
		alert("직책을 선택해주세요");
		document.frm.mem_posi.focus();
		return false;
	} else if (document.frm.mem_hp1.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp1.focus();
		return false;
	} else if (document.frm.mem_hp2.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp2.focus();
		return false;
	} else if (document.frm.mem_hp3.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp3.focus();
		return false;
	} else if (document.frm.mem_addr1.value == ""
			&& document.frm.mem_addr2.value != "") {
		alert("상세주소를 지우거나 주소를 입력해주세요");
		document.frm.mem_addr2.focus();
		return false;
	} else {
		var name = document.frm.mem_name.value;
		var isCorrect = confirm(name + " 사원을 등록하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function memModifyCheck() {
	if (document.frm.mem_id.value == "") {
		alert("수정할 사원을 선택해 주세요");
		document.frm.mem_search_name.focus();
		return false;
	}else if (document.frm.mem_name.value == "") {
		alert("이름을 입력하세요");
		document.frm.mem_name.focus();
		return false;
	} else if (document.frm.mem_jumin1.value == "") {
		alert("주민등록번호를 입력하세요");
		document.frm.mem_jumin1.focus();
		return false;
	} else if (document.frm.mem_jumin2.value == "") {
		alert("주민등록번호를 입력하세요");
		document.frm.mem_jumin2.focus();
		return false;
	} else if (document.frm.dept_no.value == "") {
		alert("부서를 확인해주세요");
		document.frm.dept_name.focus();
		return false;
	} else if (document.frm.mem_posi.value == "0") {
		alert("직책을 선택해주세요");
		document.frm.mem_posi.focus();
		return false;
	} else if (document.frm.mem_hp1.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp1.focus();
		return false;
	} else if (document.frm.mem_hp2.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp2.focus();
		return false;
	} else if (document.frm.mem_hp3.value == "") {
		alert("휴대전화 번호를 입력하세요");
		document.frm.mem_hp3.focus();
		return false;
	} else if (document.frm.mem_addr1.value == ""
			&& document.frm.mem_addr2.value != "") {
		alert("상세주소를 지우거나 주소를 입력해주세요");
		document.frm.mem_addr2.focus();
		return false;
	} else {
		var name = document.frm.mem_name.value;
		var isCorrect = confirm(name + " 사원정보를 수정하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function memberDelete() {
	if (document.frm.mem_id.value == "") {
		alert("삭제할 사원을 먼저 선택해 주세요");
		document.frm.mem_search_name.focus();
		return false;
	} else {
		var id = document.frm.mem_id.value;
		var isCorrect = confirm("'" + id + "'을 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "member.do?&command=member_delete&mem_id="
					+ document.frm.mem_id.value +"&mem_name=" + document.frm.mem_name.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

function passCheck() {
	
	var mem_id = document.frm.mem_id.value;
	var currPass = document.frm.currPass.value;
	var modiPass = document.frm.modiPass.value;
	var modiPassOk = document.frm.modiPassOk.value;
	
	if(currPass == "") {
		alert("현재 비밀번호를 입력해주세요");
		document.frm.currPass.focus();
		return false;
	}else if(modiPass == "") {
		alert("변경할 비밀번호를 입력해주세요");
		document.frm.modiPass.focus();
		return false;
	}else if(modiPass == currPass) {
		alert("같은 비밀번호로 변경할 수 없습니다.");
		document.frm.modiPass.focus();
		return false;
	}else if(modiPassOk == "") {
		alert("변경할 비밀번호를 확인해주세요");
		document.frm.modiPassOk.focus();
		return false;
	}else if(modiPassOk != modiPass) {
		alert("변경할 비밀번호를 확인해주세요");
		document.frm.modiPassOk.focus();
		return false;
	}else {
		return true;
	}
	
}

