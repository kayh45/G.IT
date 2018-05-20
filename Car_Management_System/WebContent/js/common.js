function onlyNumber2(loc) {
	/* 
	 * 숫자가 아닌 입력값을 받았을 때 오류출력해주는 기능
	 * onBlur = "onlyNumber2(this)" 형식으로 사용 (input 안에서) 
	 * 
	 */	
	if (/[^0123456789]/g.test(loc.value)) {
		alert("숫자가 아닙니다.\n\n0-9의 정수만 허용합니다.");
		loc.value = "";
		loc.focus();
	}
}