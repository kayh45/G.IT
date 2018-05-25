function viewOneDay(car_reg_no) {
	
	var date = document.frm.date.value;
	
	location.href = "rsrv.do?command=reserve_view_schedule&car_reg_no=" + car_reg_no +"&date=" + date;
	
}