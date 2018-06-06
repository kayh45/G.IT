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
		String url = "carlog/carlog_view_excel1.jsp";
		String repa_s_date = request.getParameter("repa_s_date");
		String repa_e_date = request.getParameter("repa_e_date");
		String car_reg_no = request.getParameter("car_reg_no");
		
		System.out.println("배차 신청 날짜 :"+ repa_s_date);
		System.out.println("배차 종료 날짜 :"+ repa_e_date);
		System.out.println("차량 번호 :"+ car_reg_no);
		
		request.setAttribute("repa_s_date", repa_s_date);
		request.setAttribute("repa_e_date", repa_e_date);
		request.setAttribute("car_reg_no", car_reg_no);
		
		CarviewDAO vDao = CarviewDAO.getInstance();


		if(car_reg_no==null && repa_s_date==null && repa_e_date==null ){
			//최초 실행 시 모두 널 값
		}

		else{ //모두 입력 시 
			System.out.println("모두 입력됨");
			List<CarviewVO> carlogAllList = vDao.selectDateCar(repa_s_date,repa_e_date,car_reg_no);
		request.setAttribute("carlogAllList", carlogAllList);
		}
		System.out.println("차량등록번호은?!!?!?!?"+car_reg_no);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
