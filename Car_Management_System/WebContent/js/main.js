function logout() {
	var isCorrect = confirm("정말 로그아웃 하시겠습니까?");
	if (isCorrect == true) {
	    var url = "main.do?command=logout";
	    location.replace(url);
	} else {
		return false;
	}
}