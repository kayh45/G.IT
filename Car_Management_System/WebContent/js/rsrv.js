function viewOneDay(car_reg_no) {
	
	var date = document.frm.date.value;
	
	document.frm.car_reg_no.value = car_reg_no;
	location.href = "rsrv.do?command=reserve_view_schedule&car_reg_no=" + car_reg_no +"&date=" + date;
	
}

function checkboxControl(curr) {
	
	var chk_box = document.frm.elements['time[]'];	
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
		if (chk_box[i].value < cmin - 2 || chk_box[i].value > cmax + 2) {
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
			console.log("오니");	
			chk_box[curr_idx].checked = true;
		}
	}
	
}

