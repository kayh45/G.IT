package com.plani.cms.controller.action.car;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;
import com.plani.cms.dto.CarVO;

/**
 * 법인 차 데이터를 조회하는 액션 클래스
 * 
 * @author CHO
 *
 */
public class CarSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car_reg_no = null;

		// 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함
		if (request.getParameter("popup").equals("yes")) {
			car_reg_no = request.getParameter("car_reg_no");

		} else {
			car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"), "UTF-8");
		}

		System.out.println("레그넘 = " + car_reg_no);
		CarDAO cDao = CarDAO.getInstance();

		int result = cDao.confirmCarNo(car_reg_no);

		System.out.println(result);

		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("result", result);

		/* ------------------ car 체크----------------------- */
		String url = "car/car_search.jsp";

		List<CarVO> carList = cDao.carSearchByNameLike(car_reg_no);
		request.setAttribute("carList", carList);
		List<CarVO> carAllList = cDao.selectAllCar();
		request.setAttribute("carAllList", carAllList);

		// 부분 일치의 결과가 없는 경우
		if (carList.isEmpty()) {
			request.setAttribute("isLike", "no");

		// 부분일치의 결과가 있는 경우
		} else {
			request.setAttribute("isLike", "yes");
			request.setAttribute("carList", carList);
		}

		System.out.println(carAllList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
