package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarlogVO;

/**
 * 선택한 이전 달에 입력된 일지가 있는지 확인하는
 * 기능을 구현한 액션 클래스
 * 
 * 
 * @author 강현
 *
 * @deprecated 2018/07/23 더이상 사용하지 않음 
 */
@Deprecated
public class CarlogAutoCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog/carlog_auto_check.jsp";
		
		String car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"),"UTF-8");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		
		// 첫 번째 DAO는 이전 달의 befo_dist가 없는 애들의 갯수를 파악하고 그 목록까지 가져온다
		
		CarlogDAO cDao = CarlogDAO.getInstance();
		List<CarlogVO> preMonthList = new ArrayList<CarlogVO>();
		List<CarlogVO> preMonthExistList = new ArrayList<CarlogVO>();
				
		if (month == 1) {
			preMonthList = cDao.preMonthNoneBefoDistCount(car_reg_no, (year - 1), 12);
			preMonthExistList = cDao.thisMonthDoneList(car_reg_no, (year - 1), 12);
		}else {
			preMonthList = cDao.preMonthNoneBefoDistCount(car_reg_no, year, (month -1));
			preMonthExistList = cDao.thisMonthDoneList(car_reg_no, year, (month -1));
		}
		
		int preExist = preMonthExistList.size();
		request.setAttribute("preExist", preExist);
		int preSize = preMonthList.size();		
		if (preSize > 0) {
			request.setAttribute("preMonthList", preMonthList);
			request.setAttribute("preSize", preSize);			
		}else {
			// 두 번째 DAO는 이번 달의 작성된 일지 목록을 가져온다			
			List<CarlogVO> thisMonthList = new ArrayList<CarlogVO>();
			
			thisMonthList = cDao.thisMonthDoneList(car_reg_no, year, month);	
			int thisSize = thisMonthList.size();
			request.setAttribute("thisMonthList", thisMonthList);
			request.setAttribute("thisSize", thisSize);
			System.out.println("ps = " + preSize + ", pre = " + preExist);
		}
		
		request.setAttribute("month", month);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}