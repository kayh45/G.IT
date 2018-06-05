/**
 정비등록 스크립트
 */



  function repaSelect(name){
	/*  window.opener.location.href="repa.do?command=repa_write_form";*/
	  var url = "repa.do?command=repa_write_form"
		  window.open(url);
		
	  opener.frm.repa_no.value = document.getElementsByName(name + "repa_no")[0].value;
		opener.frm.car_reg_no.value = document.getElementsByName(name + "car_reg_no")[0].value;
		
		/*
		opener.frm.s_place_name.value = document.getElementsByName(name + "s_place_name")[0].value;
		opener.frm.s_place_addr.value = document.getElementsByName(name + "s_place_addr")[0].value;
		opener.frm.e_place_no.value = document.getElementsByName(name + "e_place_no")[0].value;
		opener.frm.e_place_name.value = document.getElementsByName(name + "e_place_name")[0].value;
		opener.frm.e_place_addr.value = document.getElementsByName(name + "e_place_addr")[0].value;
		opener.frm.cour_purpo.value = document.getElementsByName(name + "cour_purpo")[0].value;
		opener.frm.distance.value = document.getElementsByName(name + "distance")[0].value;
		opener.document.getElementById("mod_btn").removeAttribute('disabled');
		opener.document.getElementById("del_btn").removeAttribute('disabled');
		opener.document.getElementById("ins_btn").disabled = "true";*/
	  
	  
    }

  function repaDateCheck() {
		var repa_s_date = document.frm.repa_s_date.value;	
		var repa_e_date = document.frm.repa_e_date.value;	
		if(repa_s_date=="" || repa_s_date.length != 10 || repa_e_date=="" || repa_e_date.length != 10) {
			alert("날짜를 입력해주세요");
			document.frm.repa_s_date.value.focus();
			return false;
		}else {
			return true;
		}
	}
  
 
  
  

function carNoCheck() {

   var url = "repa.do?popup=no&command=repa_car_write_check_form&car_reg_no="
         + encodeURIComponent(document.frm.car_reg_no.value);
   window
         .open(url, "_blank_1",
               "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}



/*function repaCentSearchByName() {

	document.frm.cent_name_ok.value = 0; // 중복검사 여부를 0으로 초기화
	var url = "repa.do?popup=no&command=repa_cent_search&cent_name="
			+ encodeURIComponent(document.frm.cent_name.value);
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}*/

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



function centWriteCheck() {
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
	}  else if (document.frm.mechanic_name.value == "") {
		alert("정비사 명을 입력하세요");
		document.frm.mechanic_name.focus();
		return false;
	} else if (document.frm.repa_fee.value == "") {
		alert("수비비용을 입력하세요");
		document.frm.repa_fee.focus();
		return false;
	} else if (document.frm.repa_cont.value == "") {
		alert("수리내용을 입력하세요");
		document.frm.repa_cont.focus();
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