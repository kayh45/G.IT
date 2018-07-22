package com.plani.cms.controller.action.repa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.RepaDAO;
import com.plani.cms.dto.RepaVO;
/**
 *정비내역을 수정하는 액션 클래스
 * 
 * @author 윤한수
 *
 */
public class RepaModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "repa.do?command=repa_write_form";
	
		RepaVO rVo = new RepaVO();	


		
		String repa_no = request.getParameter("repa_no");	
		String cent_no = request.getParameter("cent_no");
		String car_reg_no = request.getParameter("car_reg_no");
		String mechanic_name = request.getParameter("mechanic_name");
		String repa_s_date = request.getParameter("repa_s_date");
		String repa_e_date = request.getParameter("repa_e_date");
		String repa_cont = request.getParameter("repa_cont");
		String repa_fee = request.getParameter("repa_fee");
		String repa_divi = request.getParameter("repa_divi");
		
		
		rVo.setRepa_no(Integer.parseInt(repa_no));
		rVo.setCent_no(Integer.parseInt(cent_no));
		rVo.setCar_reg_no(car_reg_no);
		rVo.setMechanic_name(mechanic_name);
		rVo.setRepa_s_date(repa_s_date);	
		rVo.setRepa_e_date(repa_e_date);	
		rVo.setRepa_cont(repa_cont);	
		rVo.setRepa_fee(Integer.parseInt(repa_fee));	
		rVo.setRepa_divi(repa_divi);	
		RepaDAO rDao = RepaDAO.getInstance();
		rDao.updateRepa(rVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>정비 내역 수정 성공!</strong> &nbsp 등록된 정비 내역 번호 : "+ repa_no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}

