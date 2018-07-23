package com.plani.cms.controller.action.reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.ReserveDAO;

/**
 * 배차 등록 화면으로 이동하는 기능을 구현한 액션 클래스
 * 
 * 초기 날짜로 DB의 sysdate를 리턴
 * 
 * @author 강현
 *
 */
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


