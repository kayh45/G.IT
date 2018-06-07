package com.plani.cms.controller.action.repa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;

public class RepaSearchMoveFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "repa/repa_write.jsp";				
		String repa_no=request.getParameter("temp_repa_no");
		String car_reg_no=request.getParameter("temp_car_reg_no");
		String cent_no=request.getParameter("temp_cent_no");
		String cent_name=request.getParameter("temp_cent_name");
		String repa_s_date=request.getParameter("temp_repa_s_date");
		String repa_e_date=request.getParameter("temp_repa_e_date");
		String _mechanic_name=request.getParameter("temp_mechanic_name");
		String repa_fee=request.getParameter("temp_repa_fee");
		String repa_cont=request.getParameter("temp_repa_cont");
		String repa_divi=request.getParameter("temp_repa_divi");
		
		System.out.println("운행일지 번호:" + repa_no);
		System.out.println("차량 등록 번호:" + car_reg_no);
		System.out.println("정비소 번호:" + cent_no);
		System.out.println("정비소 번호:" + cent_name);
		System.out.println("정비 시작 날짜:" + repa_s_date);
		System.out.println("정비 종료 날짜:" + repa_e_date);
		System.out.println("정비 담당자:" + _mechanic_name);
		System.out.println("수리비용:" + repa_fee);
		System.out.println("수리내용:" + repa_cont);
		System.out.println("수리구분:" + repa_divi);
	
		request.setAttribute("repa_no", repa_no);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("cent_no", cent_no);
		request.setAttribute("cent_name", cent_name);
		request.setAttribute("repa_s_date", repa_s_date);
		request.setAttribute("repa_e_date", repa_e_date);
		request.setAttribute("mechanic_name", _mechanic_name);
		request.setAttribute("repa_fee", repa_fee);
		request.setAttribute("repa_cont", repa_cont);
		request.setAttribute("repa_divi", repa_divi);
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}


}
