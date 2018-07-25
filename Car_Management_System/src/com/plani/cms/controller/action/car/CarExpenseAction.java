package com.plani.cms.controller.action.car;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;
import com.plani.cms.dao.RepaDAO;
import com.plani.cms.dto.CarexVO;
import com.plani.cms.dto.RepaVO;

/**
 * 차량 비용관리 화면을 출력하는 액션 클래스
 * @author 강현
 *
 */
public class CarExpenseAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "car/car_expense_form.jsp";
		
		String date_s = request.getParameter("date_s");
		String date_e = request.getParameter("date_e");
		String car_reg_no = request.getParameter("car_reg_no");
		String car_model = request.getParameter("car_model");
		
		System.out.println(date_s);
		System.out.println(date_e);
		System.out.println(car_reg_no);
		System.out.println(car_model);
		
		CarDAO cDao = CarDAO.getInstance();

		request.setAttribute("date_s", date_s);
		request.setAttribute("date_e", date_e);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("car_model", car_model);

		if(car_reg_no==""){
			List<CarexVO> carAllList = cDao.selectExpenCarOnlydate(date_s, date_e);
			request.setAttribute("carAllList", carAllList);
		}
		else{
			List<CarexVO> carAllList = cDao.selectExpenCarOnlydate(date_s, date_e, car_reg_no);
			request.setAttribute("carAllList", carAllList);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}		

}
