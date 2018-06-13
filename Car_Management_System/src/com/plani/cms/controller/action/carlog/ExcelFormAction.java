package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarviewDAO;
import com.plani.cms.dto.CarviewVO;

public class ExcelFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog/carlog_view_excel.jsp";
		String repa_s_date = request.getParameter("repa_s_date");
		String repa_e_date = request.getParameter("repa_e_date");
		String car_reg_no = request.getParameter("car_reg_no");
		String car_model = request.getParameter("car_model");
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		
		System.out.println("배차 신청 날짜 :"+ repa_s_date);
		System.out.println("배차 종료 날짜 :"+ repa_e_date);
		System.out.println("차량 번호 :"+ car_reg_no);
		System.out.println("차량 모델 :"+ car_model);
		System.out.println("사원이름 :"+ mem_name);
		System.out.println("사원아이디 :"+ mem_id);
		
		request.setAttribute("repa_s_date", repa_s_date);  //조회 클릭 후  jsp화면에 검색조건을 보여주기 위해서
		request.setAttribute("repa_e_date", repa_e_date);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("car_model", car_model);
		request.setAttribute("mem_name", mem_name);
		request.setAttribute("mem_id", mem_id);
		
		CarviewDAO vDao = CarviewDAO.getInstance();


		if(car_reg_no==null && repa_s_date==null && repa_e_date==null && mem_id==null ){
			//최초 실행 시 모두 널 값
		}
		else if(repa_s_date!=null && repa_e_date!=null && mem_id.equals("") && car_reg_no.equals("")){//운행기간만 입력할 경우
			System.out.println("운행기간만 입력");
			List<CarviewVO> carlogAllList = vDao.selectDate(repa_s_date,repa_e_date);
			request.setAttribute("carlogAllList", carlogAllList);
		}
		
		else if(repa_s_date!=null && repa_e_date!=null && mem_id.equals("") && car_reg_no!=null){
			System.out.println("운행기간,차량등록 번호 입력"); //운행기간, 차량등록번호 입력
			List<CarviewVO> carlogAllList = vDao.selectDateCar(repa_s_date,repa_e_date,car_reg_no);
			request.setAttribute("carlogAllList", carlogAllList);
		}
		else if(repa_s_date!=null && repa_e_date!=null && mem_id != null && car_reg_no.equals("")){
			System.out.println("운행기간,사원이름 입력");//운행기간 사원이름 입력
			List<CarviewVO> carlogAllList = vDao.selectDateMem(repa_s_date,repa_e_date,mem_id);
			request.setAttribute("carlogAllList", carlogAllList);
		}
		else{ //모두 입력 시 
			System.out.println("모두 입력됨");
			List<CarviewVO> carlogAllList = vDao.selectAll(repa_s_date,repa_e_date,car_reg_no, mem_id);
		request.setAttribute("carlogAllList", carlogAllList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/
	}

}
