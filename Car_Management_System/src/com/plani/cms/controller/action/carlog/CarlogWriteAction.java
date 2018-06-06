package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.CarlogVO;

public class CarlogWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_write_form";

		CarlogVO cVo = new CarlogVO();
		CarVO caVo = new CarVO();
		/*
		 * String driv_no = request.getParameter("driv_no"); String mem_id =
		 * request.getParameter("mem_id"); String car_reg_no =
		 * request.getParameter("car_reg_no"); String driv_s_date =
		 * request.getParameter("driv_s_date"); String driv_e_date =
		 * request.getParameter("driv_e_date");
		 */

		int driv_no = Integer.parseInt(request.getParameter("driv_no"));
		int cour_no = Integer.parseInt(request.getParameter("cour_no"));
		String driv_purpo = request.getParameter("driv_purpo");
		int befo_dist = Integer.parseInt(request.getParameter("befo_dist"));
		int driv_dist = Integer.parseInt(request.getParameter("driv_dist"));
		String card_divi = request.getParameter("card_divi");
		int oil_fee = Integer.parseInt(request.getParameter("oil_fee"));
		int trans_fee = Integer.parseInt(request.getParameter("trans_fee"));
		String etc_text = request.getParameter("etc_text");
		int etc_fee = Integer.parseInt(request.getParameter("etc_fee"));
		String car_reg_no = request.getParameter("car_reg_no");
		
		System.out.println("래그넘 = " +  card_divi);

		cVo.setDriv_no(driv_no);
		cVo.setCour_no(cour_no);
		cVo.setDriv_purpo(driv_purpo);
		cVo.setBefo_dist(befo_dist);
		cVo.setDriv_dist(driv_dist);
		cVo.setCard_divi(card_divi);
		cVo.setOil_fee(oil_fee);
		cVo.setTrans_fee(trans_fee);
		cVo.setEtc_text(etc_text);
		cVo.setEtc_fee(etc_fee);
		caVo.setCar_reg_no(car_reg_no);

		
		CarlogDAO cDao = CarlogDAO.getInstance();
		
		if (card_divi.equals("미사용")) {
			cDao.updateCarlogNofee(cVo);
			cDao.updateCarDist(caVo,cVo);
		}  else {
			cDao.updateCarlog(cVo);
			cDao.updateCarDist(caVo,cVo);
		}
		
		System.out.println(driv_dist);
		System.out.println("등록 성공");
		request.setAttribute("message", "<strong>운행일지 작성 성공!</strong>");

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}