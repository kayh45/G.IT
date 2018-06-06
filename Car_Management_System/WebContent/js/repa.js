/**
 정비등록 스크립트
 */



  function repaSelect(name){
	
	  var url = "repa.do?command=repa_search_move_form";
	document.frm.action=url; 	
	document.frm.temp_repa_no.value = document.getElementsByName(name + "repa_no")[0].value;
	document.frm.temp_car_reg_no.value =document.getElementsByName(name + "car_reg_no")[0].value;
	document.frm.temp_cent_no.value =document.getElementsByName(name + "cent_no")[0].value;
	document.frm.temp_repa_s_date.value =document.getElementsByName(name + "repa_s_date")[0].value;
	document.frm.temp_repa_e_date.value =document.getElementsByName(name + "repa_e_date")[0].value;
	document.frm.temp_mechanic_name.value =document.getElementsByName(name + "mechanic_name")[0].value;
	document.frm.temp_repa_fee.value =document.getElementsByName(name + "repa_fee")[0].value;
	document.frm.temp_repa_cont.value =document.getElementsByName(name + "repa_cont")[0].value;
	document.frm.temp_repa_divi.value =document.getElementsByName(name + "repa_divi")[0].value;
	document.frm.submit();
    }

  function repaDateCheck() {
		var repa_s_date = document.frm.repa_s_date.value;	
		var repa_e_date = document.frm.repa_e_date.value;	
		var car_reg_no = document.frm.car_reg_no.value;
		var car_reg_no_ok = document.frm.car_reg_no_ok.value;
	
		if(repa_s_date=="" || repa_s_date.length != 10 || repa_e_date=="" || repa_e_date.length != 10) {
			alert("날짜를 입력해주세요");
			document.frm.repa_s_date.value.focus();
			return false;
		}
			else if(car_reg_no !="" &&car_reg_no_ok==0){
				alert("차량 등록 번호 돋보기를 클릭하세요.");
		}else {
			return true;
		}
	}
  
 
  
  

function carNoCheck() {
	document.frm.car_reg_no_ok.value = 0; // 중복검사 여부를 0으로 초기화
   var url = "repa.do?popup=no&command=repa_car_write_check_form&car_reg_no="
         + encodeURIComponent(document.frm.car_reg_no.value);
   window
         .open(url, "_blank_1",
               "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}


function centNameCheck() {
	document.frm.cent_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "repa.do?popup=no&command=repa_cent_write_check_form&cent_name="
		+ encodeURIComponent(document.frm.cent_name.value);
window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
	
}

function repaMemSelect(mem_no, mem_name) {
	/*
	 * repa_cent_check.jsp 에서 사용
	 * 
	 * 정비소명 을 검색하고 정비소명을 누르면 해당 정비소의 정비소명과 정비번호가 부모화면의 폼으로 들어간다.
	 * 
	 */
	opener.frm.mem_no.value = mem_no;
	opener.frm.mem_name.value = mem_name;
	self.close();
}

		function repaCarSelect(car_reg_no) {
			/*
			 * repa_cent_check.jsp 에서 사용
			 * 
			 * 정비소명 을 검색하고 정비소명을 누르면 해당 정비소의 정비소명과 정비번호가 부모화면의 폼으로 들어간다.
			 * 
			 */
			opener.frm.car_reg_no_ok.value = document.frm.car_reg_no_ok.value;
			opener.frm.car_reg_no.value = car_reg_no;
		
			self.close();
		}


function repaCentSelect(cent_no, cent_name) {
	/*
	 * repa_cent_check.jsp 에서 사용


	 * 정비소명 을 검색하고 정비소명을 누르면 해당 정비소의 정비소명과 정비번호가 부모화면의 폼으로 들어간다.
	 * 
	 */
	opener.frm.cent_no.value = cent_no;
	opener.frm.cent_name.value = cent_name;
	self.close();
}
function regiCent(){
	window.close();
	 window.opener.location.href="cent.do?command=cent_write_form";
}
function regiCar(){
	window.close();
	 window.opener.location.href="car.do?command=car_write_form";
}



function repaWriteCheck() {
	if (document.frm.car_reg_no.value == "") {
		alert("차량 등록 번호를 입력하세요");
		document.frm.car_reg_no.focus();
		return false;
	}
	else if (document.frm.cent_no.value == "") {
		alert("정비소 번호를 입력하세요.");
		document.frm.cent_no.focus();
		return false;
	}
	else if (document.frm.repa_s_date.value == "") {
		alert("정비 시작 날짜를 입력하세요");
		document.frm.repa_s_date.focus();
		return false;
	} else if (document.frm.repa_e_date.value == "") {
		alert("정비 종료 날짜를 입력하세요");
		document.frm.repa_e_date.focus();
		return false;
	}   else if (document.frm.repa_fee.value == "") {
		alert("수비비용을 입력하세요");
		document.frm.repa_fee.focus();
		return false;
	} 
	else {
	var isCorrect = confirm(" 정비내역을 등록하시겠습니까?");
	if (isCorrect == true) {
		return true;
	} else {
		return false;
	}
}
}
function repaModifyCheck() {
	if (document.frm.car_reg_no.value == "") {
		alert("차량 등록 번호를 입력하세요");
		document.frm.car_reg_no.focus();
		return false;
	}
	
	else if (document.frm.cent_no.value == "") {
		alert("정비소 번호를 입력하세요.");
		document.frm.cent_no.focus();
		return false;
	}
	else if (document.frm.repa_s_date.value == "") {
		alert("정비 시작 날짜를 입력하세요");
		document.frm.repa_s_date.focus();
		return false;
	} else if (document.frm.repa_e_date.value == "") {
		alert("정비 종료 날짜를 입력하세요");
		document.frm.repa_e_date.focus();
		return false;
	}   else if (document.frm.repa_fee.value == "") {
		alert("수비비용을 입력하세요");
		document.frm.repa_fee.focus();
		return false;
	} 
	else {
	var isCorrect = confirm(" 정비내역을 수정하시겠습니까?");
	if (isCorrect == true) {
		 var url = "repa.do?command=repa_modify";
		document.frm.action=url; 	
		document.frm.submit();
		return true;
	} else {
		return false;
	}
}
}
function repaDelete() {
	if (document.frm.repa_no.value == "") {
		alert("삭제할 정비내역를 먼저 선택해 주세요");
		return false;
	} else {
		var name = document.frm.repa_no.value;
		var isCorrect = confirm("정비내역번호: '" + name + "'을 삭제하시겠습니까?");
		if (isCorrect == true) {
			var isisCorrect = confirm("삭제한 정보는 되돌릴수 없습니다.")
			if(isisCorrect == true) {
				var url = "repa.do?&command=repa_delete&repa_no="
					+ document.frm.repa_no.value;
			location.replace(url);
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
function onlyNumber2(loc) {
	/* 
	 * 숫자가 아닌 입력값을 받았을 때 오류출력해주는 기능
	 * onBlur = "onlyNumber2(this)" 형식으로 사용 (input 안에서) 
	 * 
	 */	
	if (/[^0123456789]/g.test(loc.value)) {
		alert("수리비용이 숫자가 아닙니다.\n\n0-9의 정수만 허용합니다.");
		loc.value = "";
		loc.focus();
	}
}