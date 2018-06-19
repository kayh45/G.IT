package com.plani.cms.controller.action.reserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		String url = "rsrv.do?command=reserve_view_schedule";
		
		String car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"),"UTF-8");
		String date = request.getParameter("date");
		String mem_id = request.getParameter("mem_id");
		String min = request.getParameter("s_date");
		String max = request.getParameter("e_date");
		String driv_s_date = date + " " + min + ":00:00";
		String driv_e_date = date + " " + max + ":00:00";
		
		request.setAttribute("date", date);
		request.setAttribute("car_reg_no", car_reg_no);
	
		
		DrivVO dVo = new DrivVO();
		dVo.setDriv_s_date(driv_s_date);
		dVo.setDriv_e_date(driv_e_date);
		dVo.setCar_reg_no(car_reg_no);
		dVo.setMem_id(mem_id);
		
		ReserveDAO rDao = ReserveDAO.getInstance();
		rDao.insertReserve(dVo);		
		
		List<DrivVO> dVoList = new ArrayList<DrivVO>();
		dVoList = rDao.oneDaySchedule(date, car_reg_no);
		String message = date + " | " + min +"시 ~ " + max + "시 | " + car_reg_no +" 차량 " + "등록 완료";
				
		request.setAttribute("date", date);
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("dVoList", dVoList);	
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	

}
