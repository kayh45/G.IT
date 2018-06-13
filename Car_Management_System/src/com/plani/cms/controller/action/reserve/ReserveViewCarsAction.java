package com.plani.cms.controller.action.reserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.ReserveDAO;
import com.plani.cms.dto.CarVO;

public class ReserveViewCarsAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "rsrv.do?command=reserve_view_schedule";
		
		String date = request.getParameter("date");
		
		String[] times = request.getParameterValues("time");
		
		System.out.println("times = " + times);
		
		int min = 99, max = 0;
		
		for(String time : times) {			
			min = min > Integer.parseInt(time)?Integer.parseInt(time):min; 
			max = max < Integer.parseInt(time)?Integer.parseInt(time):max; 
		}
		
		String s_date = min + "";
		String e_date = (max+1) + "";
		
		ReserveDAO rDao = ReserveDAO.getInstance();
		List<CarVO> cVoList = new ArrayList<CarVO>();
		
		cVoList = rDao.unuseList(date, s_date, e_date);
		
		request.setAttribute("cVoList", cVoList);
		request.setAttribute("s_date", s_date);
		request.setAttribute("e_date", e_date);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
}
