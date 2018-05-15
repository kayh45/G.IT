function deptNamecheck() {
	if (document.frm.dept_name.value == "") {
		alert('부서명을 입력하세요');
		document.frm.dept_name.focus();
		return;
	}
	document.frm.dept_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "member.do?popup=no&command=dept_write_check_form&dept_name=" + encodeURIComponent(document.frm.dept_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function useDeptName() {
	/*
	 * @deptCheck.jsp 에서 사용
	 * 
	 * 부서명을 검색하고 사용버튼을 누르게 되면 해당 내용이 부모 화면의 폼에 들어간다.
	 * 중복 검사를 통해 나온 값을 숨겨진 input타입에 값을 넣어준다.
	 * 부모 화면의 부서번호가 비어있으면 등록 버튼을 활성화하고 부모화면의 폼의 action을 등록에 맞춘다.
	 * 
	 * # 숨겨진 input 타입
	 * dept_usable_name -> 중복 검사를 진행한 부서명
	 * dept_name_ok -> 중복 검사가 진행됐는지에 대한 여부
	 * 
	 */
	opener.frm.dept_name.value = document.frm.dept_name.value;
	opener.frm.dept_usable_name.value = document.frm.dept_name.value;
	opener.frm.dept_name_ok.value = document.frm.dept_name_ok.value;
	if(opener.frm.dept_no.value == '') {
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
	    var url = "member.do?&command=dept_delete&dept_no=" + document.frm.dept_no.value;
	    location.replace(url);
	} else {
		return false;
	}
}

function modDeptSelect(dept_no, dept_name) {
	/*
	 * @deptCheck.jsp 에서 사용
	 * 
	 * 부서명을 검색하고 부서명을 누르면 해당 부서의 부서번호와 부서명이 부모화면의 폼으로 들어간다.
	 * 부모 화면의 등록버튼을 비활성화하고 수정, 삭제 버튼을 활성화 한다.
	 * 현재 선택된 부서명을 pre_dept_name에 넣고 visible시킨다.
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
	if (document.frm.dept_name.value == "") {
		alert('부서명을 입력하세요');
		document.frm.dept_name.focus();
		return;
	}
	var url = "member.do?popup=no&command=dept_search&dept_name=" + encodeURIComponent(document.frm.dept_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function deptWriteCheck() {
	if(document.frm.dept_name.value == ""){
		alert("부서명을 입력하세요.");
		document.frm.dept_name.focus();
		return false;
	} else if(document.frm.dept_name_ok.value == "0"){
		alert("부서명을 확인해주세요");
		document.frm.dept_name.focus();
		return false;
	} else if(document.frm.dept_name_ok.value == "0" && document.frm.dept_no.value != ""){
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

