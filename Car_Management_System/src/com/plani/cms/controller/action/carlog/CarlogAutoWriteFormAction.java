package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.ReserveDAO;

/**
 * 일지 일괄작성 화면으로 이동하는 기능을 구현한 액션클래스
 * 
 * @author 강현
 *
 */
public class CarlogAutoWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog/carlog_auto_write.jsp";
		
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		System.out.println(url);
		
		int curYear = Integer.parseInt(rDao.getSysDate().substring(0, 4));

		request.setAttribute("curYear", curYear);
		if(request.getParameter("message") != null) {
			request.setAttribute("message", request.getParameter("message"));			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}