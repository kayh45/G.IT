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
		
		String dateInPage = request.getParameter("date");
		ReserveDAO rDao = ReserveDAO.getInstance();
			
		if(dateInPage == null) {
			String date = rDao.getSysDate();				
			request.setAttribute("date", date);
		}		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}


