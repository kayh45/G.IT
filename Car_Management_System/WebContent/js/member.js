function dept_check() {
	if (document.frm.dept_name.value == "") {
		alert('부서명을 입력하세요');
		document.frm.dept_name.focus();
		return;
	}
	var url = "member.do?command=dept_write_check_form&dept_name=" + document.frm.dept_name.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function doing() {
	alert('뭐라도 좀 해봐');
}
