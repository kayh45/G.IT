package com.plani.cms.controller.action.car;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;
import com.plani.cms.dto.CarVO;
/**
 * 법인차를 등록하는 액션 클래스
 * 등록 후 등록 페이지로 초기화 이동
 * 
 * @author 조성철
 *
 */
public class CarWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "car.do?command=car_write_form";

		String car_reg_no = request.getParameter("car_reg_no");
		String car_divi = request.getParameter("car_divi");
		String car_model = request.getParameter("car_model");
		String ct_date = request.getParameter("ct_date");
		String ep_date = request.getParameter("ep_date");
		String co_name = request.getParameter("co_name");
		String co_tel = request.getParameter("co_tel1")+"-"+request.getParameter("co_tel2")+"-"+request.getParameter("co_tel3");
		String co_fax = request.getParameter("co_fax1")+"-"+request.getParameter("co_fax2")+"-"+request.getParameter("co_fax3");
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
		cVo.setCo_tel(co_tel);
		cVo.setCo_fax(co_fax);
		cVo.setBo_name(bo_name);
		cVo.setBo_divi(bo_divi);
		cVo.setBo_age(Integer.parseInt(bo_age));
		cVo.setBo_s_date(bo_s_date);
		cVo.setBo_e_date(bo_e_date);
		cVo.setTotal_dist(Integer.parseInt(total_dist));

		// 렌탈/리스와 구입 기준으로 분기한 코드 내용
		CarDAO cDao = CarDAO.getInstance();
		if (car_divi.equals("렌트") || car_divi.equals("리스")) {
			cDao.insertCar_rentalCar(cVo);
		
		} else if(car_divi.equals("구입")){
			cDao.insertCar_payCar(cVo);
		}
		// 렌탈/리스와 구입 기준으로 분기한 코드 내용
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>법인 차 등록 성공!</strong> &nbsp 등록된 법인차 : " + car_reg_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
