function viewOneDay() {
	
	var date = document.frm.date.value;
	var mem_id = document.frm.mem_id.value;
	
	if (rsrvDateCheck()) {
		location.href = "rsrv.do?command=reserve_view_schedule&mem_id=" + mem_id +"&date=" + date;				
	}		
}

function checkboxControl(curr) {
	
	var chk_box = document.frm.elements['time'];	
	var len = chk_box.length;
	var tempArr = new Array();
	var chkdArr = new Array();
	var curr_num = parseInt(curr);	
	
	for(var i = 0; i < len; i++) {
		tempArr[i] = parseInt(chk_box[i].value);
	}
	
	for(var i = 0; i < len; i++) {
		if(chk_box[i].checked){
			chkdArr[i] = parseInt(chk_box[i].value);
		}else {
			chkdArr[i] = 99;
		}
	}
	var cmin = Math.min.apply(null, chkdArr);
	
	for(var i = 0; i < len; i++) {
		if(chk_box[i].checked){
			chkdArr[i] = parseInt(chk_box[i].value);
		}else {
			chkdArr[i] = -1;
		}
	}
	var cmax = Math.max.apply(null, chkdArr);
	
	var min = Math.min.apply(null, tempArr);
	var max = Math.max.apply(null, tempArr);
	
	
	
	var curr_idx = tempArr.indexOf(curr_num);	
	
	console.log(cmin);	
	console.log(cmax);	
	
	for(var i = 0; i < len ; i++) {
		if (chk_box[i].value < cmin - 1 || chk_box[i].value > cmax + 1) {
			chk_box[i].disabled = true;
		}else {
			chk_box[i].removeAttribute('disabled');
		}
	}
	
	if(cmin < 0 || cmin > 98 || cmax > 98 || cmax < 0) {
		for(var i = 0; i < len ; i++) {
				chk_box[i].removeAttribute('disabled');
		}
	}
	
	if (chk_box[curr_idx].value > min && chk_box[curr_idx].value < max) {			
		if (chk_box[curr_idx-1].checked && chk_box[curr_idx+1].checked) {
			chk_box[curr_idx].checked = true;
		}
	}
	
}

function rsrvDateCheck() {
	var date = document.frm.date.value;	
	if(date=="" || date.length != 10) {
		alert("날짜를 확인해주세요");
		document.frm.date.value.focus();
		return false;
	}else {
		return true;
	}
}

function carlogWriteFrm(driv_no) {
	var url = "rsrv.do?&command=carlog_write_form&driv_no=" + driv_no;
	location.replace(url);
}

function rsrvDelete(driv_no) {
	var isCorrect = confirm("배차 등록을 취소하시겠습니까?");
	if (isCorrect == true) {
		var url = "rsrv.do?&command=reserve_delete&driv_no="
				+ driv_no;
		location.replace(url);
	} else {
		return false;
	}
}

function timeCheck() {
	
	var timecheckbox = document.frm.time.value;
	
	if(timecheckbox == null) {
		alert("시간을 선택해주세요");
		return false;
	}else {
		return true;
	}
	return false;
	
}

function selectThisCar(date, s_date, e_date, car_reg_no) {
	
	var mem_id = document.frm.mem_id.value;
	var url = "rsrv.do?&command=reserve_write" +
	"&mem_id=" + mem_id +
	"&date=" + date +
	"&s_date=" + s_date +
	"&e_date=" + e_date +
	"&car_reg_no=" + car_reg_no;
	
	var isCorrect = confirm("배차 정보 : " + date + " " + s_date + "시~" + e_date + 
			"시 " + car_reg_no + " 차량\n" + "등록하시겠습니까?");
	if (isCorrect == true) {
		location.replace(url);
	} else {
		return false;
	}
	
	location.replace(url);
}

