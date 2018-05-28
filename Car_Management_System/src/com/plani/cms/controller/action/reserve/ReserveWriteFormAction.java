package com.plani.cms.controller.action.reserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarDAO;
import com.plani.cms.dao.ReserveDAO;
import com.plani.cms.dto.CarVO;

public class ReserveWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "reserve/reserve_write.jsp";
		
		List<CarVO> cVoList = new ArrayList<CarVO>();
		List<String> isUsingList = new ArrayList<String>();
		List<String> canUseList = new ArrayList<String>();
		
		String dateInPage = request.getParameter("date");
		
		CarDAO cDao = CarDAO.getInstance();
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		cVoList = cDao.selectAllCar();
		isUsingList = rDao.usingNow();
		canUseList = rDao.canUseNow();			
			
		for (CarVO cVo : cVoList) {
			System.out.println(cVo.getCar_reg_no());
			if(isUsingList.contains(cVo.getCar_reg_no())) {				
				cVo.setIsUsing(1);
			} else if(!canUseList.contains(cVo.getCar_reg_no())) {
				cVo.setCanUse(1);
			}
		}
			
		if(dateInPage == null) {
			String date = rDao.getSysDate();				
			request.setAttribute("date", date);
		}		
		
		request.setAttribute("CarList", cVoList);				
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}


