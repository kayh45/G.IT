package com.plani.cms.controller.action.car;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;

public class CarDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "car.do?command=car_write_form";
		String car_reg_no = request.getParameter("car_reg_no");

		CarDAO cDao = CarDAO.getInstance();
		cDao.DeleteCar(car_reg_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>법인차 삭제 성공!</strong> &nbsp 삭제한 법인차 : " + car_reg_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
