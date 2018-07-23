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
import com.plani.cms.dto.MemberVO;

/**
 * 배차 등록 정보를 삭제하는 기능을 구현한 액션 클래스
 * 
 * 모든 기능 수행 후 배차 등록 화면으로 이동
 * 
 * @author 강현
 *
 */
public class ReserveDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "rsrv.do?command=reserve_view_schedule";
		
		int driv_no = Integer.parseInt(request.getParameter("driv_no"));
		String date = request.getParameter("date");
		String mem_id = request.getParameter("mem_id");
		
		DrivVO dVo = new DrivVO();
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		
		System.out.println(driv_no);
		dVo = rDao.selectOneDrive(driv_no);
		String deleteDate = dVo.getDate();
		String car_reg_no = dVo.getCar_reg_no();
				
		rDao.deleteReserve(driv_no);
		
		List<DrivVO> dVoList = new ArrayList<DrivVO>();
		dVoList = rDao.oneDaySchedule(deleteDate, car_reg_no);
					
		
		System.out.println("login user's name = " + mem_id);
		
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("date", date);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("dVoList", dVoList);
		request.setAttribute("message", "등록한 배차가 취소되었습니다.");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}


