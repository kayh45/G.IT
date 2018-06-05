package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dao.CourseDAO;
import com.plani.cms.dto.CarlogVO;
import com.plani.cms.dto.CourseVO;

public class CarlogWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_write_form";

		CarlogVO cVo = new CarlogVO();
/*		String driv_no = request.getParameter("driv_no");
		String mem_id = request.getParameter("mem_id");
		String car_reg_no = request.getParameter("car_reg_no");
		String driv_s_date = request.getParameter("driv_s_date");
		String driv_e_date = request.getParameter("driv_e_date");*/
		String cour_no = request.getParameter("cour_no");
		String driv_purpo = request.getParameter("driv_purpo");
		String befo_dist = request.getParameter("befo_dist");
		String card_divi = request.getParameter("card_divi");
		String oil_fee = request.getParameter("oil_fee");
		String trans_fee = request.getParameter("trans_fee");
		String etc_text = request.getParameter("etc_text");
		String etc_fee = request.getParameter("etc_fee");
		
		

		

		CarlogDAO cDao = CarlogDAO.getInstance();
		cDao.updateCarlog(cVo);

		System.out.println("등록 성공");
		request.setAttribute("message", "<strong>운행일지 작성 성공!</strong>");

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}