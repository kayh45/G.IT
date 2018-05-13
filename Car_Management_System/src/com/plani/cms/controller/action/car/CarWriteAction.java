package com.plani.cms.controller.action.car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;
import com.plani.cms.dto.CarVO;

public class CarWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String car_reg_no = request.getParameter("car_reg_no");
		String car_divi = request.getParameter("car_divi");
		String car_model = request.getParameter("car_model");
		String ct_date = request.getParameter("ct_date");
		String ep_date = request.getParameter("ep_date");
		String co_name = request.getParameter("co_name");
		String co_tel1 = request.getParameter("co_tel1");
		String co_tel2 = request.getParameter("co_tel2");
		String co_tel3 = request.getParameter("co_tel3");
		String co_fax1 = request.getParameter("co_fax1");
		String co_fax2 = request.getParameter("co_fax2");
		String co_fax3 = request.getParameter("co_fax3");
		String bo_name = request.getParameter("bo_name");
		String bo_divi = request.getParameter("bo_divi");
		String bo_age = request.getParameter("bo_age");
		String bo_s_date = request.getParameter("bo_s_date");
		String bo_e_date = request.getParameter("bo_e_date");
		String total_dist = request.getParameter("total_dist");

		CarVO cVo = new CarVO();

		
		cVo.setCar_reg_no(car_reg_no);
		cVo.setCar_divi(car_divi);
		cVo.setCar_model(car_model);
		cVo.setCt_date(ct_date);
		cVo.setEp_date(ep_date);
		cVo.setCo_name(co_name);
		cVo.setCo_tel1(co_tel1);
		cVo.setCo_tel2(co_tel2);
		cVo.setCo_tel3(co_tel3);
		cVo.setCo_fax1(co_fax1);
		cVo.setCo_fax2(co_fax2);
		cVo.setCo_fax3(co_fax3);
		cVo.setBo_name(bo_name);
		cVo.setBo_divi(bo_divi);
		cVo.setBo_age(Integer.parseInt(bo_age));
		cVo.setBo_s_date(bo_s_date);
		cVo.setBo_e_date(bo_e_date);
		cVo.setTotal_dist(Integer.parseInt(total_dist));

		CarDAO cDao = CarDAO.getInstance();
		int result = cDao.insertCar(cVo);
		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("car_model", cVo.getCar_model());

		} else {

		}

		new CarWriteFormAction().execute(request, response);

	}

}
