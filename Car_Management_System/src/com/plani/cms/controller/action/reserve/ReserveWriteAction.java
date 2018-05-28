package com.plani.cms.controller.action.reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.ReserveDAO;
import com.plani.cms.dto.DrivVO;

public class ReserveWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "rsrv.do?command=reserve_write_form";
		HttpSession session = request.getSession();
		
		String car_reg_no = request.getParameter("car_reg_no");
		String date = request.getParameter("date");
		String[] times = request.getParameterValues("time[]");
		String mem_id = request.getParameter("mem_id");
		
		System.out.println(times);
		
		int min = 99, max = 0;
		
		for(String time : times) {			
			min = min > Integer.parseInt(time)?Integer.parseInt(time):min; 
			max = max < Integer.parseInt(time)?Integer.parseInt(time):max; 
		}
		
		String driv_s_date = date + " " + min + ":00:00";
		String driv_e_date = date + " " + (max+2) + ":00:00";
		
		DrivVO dVo = new DrivVO();
		dVo.setDriv_s_date(driv_s_date);
		dVo.setDriv_e_date(driv_e_date);
		dVo.setCar_reg_no(car_reg_no);
		dVo.setMem_id(mem_id);
		
		ReserveDAO rDao = ReserveDAO.getInstance();
		rDao.insertReserve(dVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	

}
