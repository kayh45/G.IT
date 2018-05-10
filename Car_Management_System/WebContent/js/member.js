function deptNamecheck() {
	if (document.frm.dept_name.value == "") {
		alert('부서명을 입력하세요');
		document.frm.dept_name.focus();
		return;
	}
	document.frm.dept_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "member.do?command=dept_write_check_form&dept_name=" + document.frm.dept_name.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function useDeptName() {
	opener.frm.dept_usable_name.value = document.frm.dept_name.value;
	opener.frm.dept_name_ok.value = document.frm.dept_name_ok.value;
	self.close();
}

function deptWriteCheck() {
	if(document.frm.dept_name.value == ""){
		alert("부서명을 입력하세요.");
		document.frm.dept_name.focus();
		return false;
	} else if(document.frm.dept_name_ok.value == "0"){
		alert("등록할 수 없는 부서명입니다.");
		document.frm.mem_pw.focus();
		return false;
	} else if(document.frm.dept_name_ok.value == "0" && document.frm.dept_no.value != ""){
		alert("수정할 수 없는 부서명입니다.");
		document.frm.mem_pw.focus();
		return false;
	}
}

function doing() {
	alert('뭐라도 좀 해봐');
}
