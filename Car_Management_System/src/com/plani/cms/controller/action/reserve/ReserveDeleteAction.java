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

public class ReserveDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "rsrv.do?command=reserve_write_form";
		
		int driv_no = Integer.parseInt(request.getParameter("driv_no"));
		
		DrivVO dVo = new DrivVO();
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		dVo = rDao.selectOneDrive(driv_no);
		String date = dVo.getDate();
		String car_reg_no = dVo.getCar_reg_no();
				
		rDao.deleteReserve(driv_no);
		
		List<DrivVO> dVoList = new ArrayList<DrivVO>();
		dVoList = rDao.oneDaySchedule(date, car_reg_no);
					
		request.setAttribute("date", date);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("dVoList", dVoList);
		request.setAttribute("message", "등록한 배차가 취소되었습니다.");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}


