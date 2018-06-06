/**
 * 유효성 검사.
 */
function excelConver(){
	 var url = "carlog.do?command=excel_form";
		document.frm.action=url; 	
		document.frm.submit();
	
}

function carNoCheck() {
	document.frm.car_reg_no_ok.value = 0; // 중복검사 여부를 0으로 초기화
   var url = "repa.do?popup=no&command=repa_car_write_check_form&car_reg_no="
         + encodeURIComponent(document.frm.car_reg_no.value);
   window
         .open(url, "_blank_1",
               "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}
  function carlogDateCheck() {
		var repa_s_date = document.frm.repa_s_date.value;	
		var repa_e_date = document.frm.repa_e_date.value;	
		var car_reg_no = document.frm.car_reg_no.value;
		var car_reg_no_ok = document.frm.car_reg_no_ok.value;
		if(repa_s_date=="" || repa_s_date.length != 10 || repa_e_date=="" || repa_e_date.length != 10) {
			alert("날짜를 입력해주세요");
			document.frm.repa_s_date.value.focus();
			return false;
		}
		else if(car_reg_no ==""){
			alert("차량 등록 번호를 입력하세요")
			return false;
		}
		else if(car_reg_no !="" && car_reg_no_ok==0){
				alert("차량 등록 번호 돋보기를 클릭하세요.");
				return false;
		}else{
			return true;
		}
	}
  
function carlogMemSelect(mem_id, mem_name) {
	/*
	 * repa_cent_check.jsp 에서 사용


	 * 정비소명 을 검색하고 정비소명을 누르면 해당 정비소의 정비소명과 정비번호가 부모화면의 폼으로 들어간다.
	 * 
	 */
	opener.frm.mem_id.value = mem_id;
	opener.frm.mem_search_name.value = mem_name;
	self.close();
}

function memSearchByName() {
	/*
	 * @member_search.jsp 에서 사용
	 * 
	 * 
	 */
	var url = "carlog.do?popup=no&command=carlog_member_search&mem_name="
			+ encodeURIComponent(document.frm.mem_search_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}


function carlogWriteCheck() {
	if (document.frm.driv_no.value == "") {
		alert("배차 신청 번호를 입력 하세요.");
		document.frm.driv_no.focus();
		return false;
	} else if (document.frm.cour_no.value == "") {
		alert("경로를 선택 하세요.");
		return false;
	} else if (document.frm.driv_purpo.value == "") {
		alert("사용 목적을 입력 하세요.");
		document.frm.driv_purpo.focus();
		return false;
	} else if (document.frm.distance.value == "") {
		alert("주행 거리를 입력하세요");
		document.frm.distance.focus();
		return false;
	} else {
	var name = document.frm.mem_name.value;
	var isCorrect = confirm(name + "님 차량운행일지를 등록하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}

function carlogModifyCheck() {
	if (document.frm.driv_no.value == "") {
		alert("배차 신청 번호를 입력 하세요.");
		document.frm.driv_no.focus();
		return false;
	} else if (document.frm.cour_no.value == "") {
		alert("경로를 선택 하세요.");
		return false;
	} else if (document.frm.driv_purpo.value == "") {
		alert("사용 목적을 입력 하세요.");
		document.frm.driv_purpo.focus();
		return false;
	} else if (document.frm.distance.value == "") {
		alert("주행 거리를 입력하세요");
		document.frm.distance.focus();
		return false;
	} else {
		var name = document.frm.mem_name.value;
		var isCorrect = confirm(name + "님 차량운행일지를 수정하시겠습니까?");
		if (isCorrect == true) {
			return true;
		} else {
			return false;
		}
	}
}

function carlogDelete() {
	if (document.frm.driv_no.value == "") {
		alert("삭제할 운행일지를 먼저 선택해 주세요");
		return false;
	} else {
		var isCorrect = confirm("선택한 운행일지를 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "carlog.do?&command=carlog_delete&driv_no="
					+ document.frm.driv_no.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

function carlogSearch(){
	var url = "carlog.do?command=carlog_select"
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function carlogCourseSearch(){
	var url = "carlog.do?command=carlog_course_select_form"
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function splaceSelect(name) {
	opener.frm.cour_no.value = document.getElementsByName(name + "cour_no")[0].value;
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.driv_purpo.value = document.getElementsByName(name + "driv_purpo")[0].value;
	opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
	
	self.close();
}

function nocarlogSelect(name) {
	opener.frm.driv_no.value = document.getElementsByName(name + "driv_no")[0].value;
	opener.frm.car_reg_no.value = document.getElementsByName(name + "car_reg_no")[0].value;
	opener.frm.car_model.value = document.getElementsByName(name + "car_model")[0].value;
	opener.frm.mem_name.value = document.getElementsByName(name + "mem_name")[0].value;
	opener.frm.driv_s_date.value = document.getElementsByName(name + "driv_s_date")[0].value;
	opener.frm.driv_e_date.value = document.getElementsByName(name + "driv_e_date")[0].value;
	self.close();
}

function carlogSelect(name) {
	opener.frm.driv_no.value = document.getElementsByName(name + "driv_no")[0].value;
	opener.frm.car_reg_no.value = document.getElementsByName(name + "car_reg_no")[0].value;
	opener.frm.car_model.value = document.getElementsByName(name + "car_model")[0].value;
	opener.frm.mem_name.value = document.getElementsByName(name + "mem_name")[0].value;
	opener.frm.driv_s_date.value = document.getElementsByName(name + "driv_s_date")[0].value;
	opener.frm.driv_e_date.value = document.getElementsByName(name + "driv_e_date")[0].value;
	opener.frm.cour_no.value = document.getElementsByName(name + "cour_no")[0].value;
	opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
	opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
	opener.frm.driv_purpo.value = document.getElementsByName(name + "driv_purpo")[0].value;
	opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
	switch (document.getElementsByName(name + "card_divi")[0].value) {
	case "법인카드" : 	opener.frm.card_divi.value ="법인카드"; break;
	case "개인카드" :	opener.frm.card_divi.value ="개인카드"; break;
	case "미사용" : 	opener.frm.card_divi.value ="미사용"; break;
	default : opener.frm.card_divi.value ="미사용"; break;
	}
	opener.frm.oil_fee.value = document.getElementsByName(name + "oil_fee")[0].value;
	opener.frm.trans_fee.value = document.getElementsByName(name + "trans_fee")[0].value;
	opener.frm.etc_text.value = document.getElementsByName(name + "etc_text")[0].value;
	opener.frm.etc_fee.value = document.getElementsByName(name + "etc_fee")[0].value;
	opener.document.getElementById("mod_btn").removeAttribute('disabled');
	opener.document.getElementById("del_btn").removeAttribute('disabled');
	opener.document.getElementById("ins_btn").disabled = "true";
	self.close();
}

function carLogAutoNext() {
	
	if (document.frm.car_usable_no.value == "") {
		alert("차량을 선택하세요");
		document.frm.car_reg_no.focus();
	}else if (document.frm.mem_id.value == "") {
		alert("운전자를 선택하세요");
		document.frm.mem_id.focus();		
	}else if (document.frm.avg_oil.value == "") {
		alert("평균 유가를 입력하세요");
		document.frm.avg_oil.focus();		
	}else if (document.frm.cour_no.value == "") {
		alert("주요 경로를 선택하세요");
		document.frm.s_place_name.focus();		
	}else if (document.frm.driv_purpo.value == "") {
		alert("사용 목적을 입력 하세요.");
		document.frm.driv_purpo.focus();
		return false;
	}else if (document.frm.distance.value == "") {
		alert("주행 거리를 입력하세요");
		document.frm.distance.focus();
		return false;
	}else {
		var lastItemNo = $("#example tr:last").attr("class").replace("item", "");
		var currItem;
		for(var i = 1; i <= lastItemNo; i++) {
			currItem = $(".item" + i);
			console.log(currItem);
			var td = currItem.children();
			console.log(td.eq(0).children("input").eq(0).val());
			if (td.eq(0).children("input").eq(0).val() == "") {
				if(td.eq(1).children("input").children("input").eq(0).val() != "" || td.eq(2).children("input").children("input").eq(0).val() != "" || td.children("input").children("input").eq(0).val() != "") {
					alert("일자를 입력하거나 다른 값을 지우세요");
					return false;
				}
			}else if(td.eq(0).children("input").eq(0).val() != "" && td.eq(1).children("input").eq(0).val() == "" && td.eq(2).children("input").eq(0).val() == "" && td.eq(3).children("input").eq(0).val() == ""){
				alert("일자를 지우거나 다른 값을 입력하세요");
				return false;
			}else if(td.eq(2).children("input").eq(0).val() != "" && td.eq(3).children("input").eq(0).val() == ""){
				alert("교통비를 지우거나 경로를 선택하세요");
				return false;
			}else {
				return true;
			}
		}
	}
}