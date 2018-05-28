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
import com.plani.cms.dto.DrivVO;

public class ReserveViewScheduleAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "rsrv.do?command=reserve_write_form";
		
		String car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"),"UTF-8");
		String date = request.getParameter("date");
		
		List<DrivVO> dVoList = new ArrayList<DrivVO>();
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		dVoList = rDao.oneDaySchedule(date, car_reg_no);
		
		request.setAttribute("date", date);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("dVoList", dVoList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
