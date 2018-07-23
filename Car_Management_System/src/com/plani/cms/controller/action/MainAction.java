package com.plani.cms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.dao.MainDAO;

/**
 * 메인화면으로 이동시켜주는 기능을 구현한 액션클래스
 * 
 * @author 강현
 *
 */
public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "main.jsp";
		
		MainDAO mDao = MainDAO.getInstance();
		
		int numberOfCars = mDao.numberOfCars();
		int numberOfUsingCars = mDao.numberOfUsingCars();
		
		request.setAttribute("noc", numberOfCars);
		request.setAttribute("nouc", numberOfUsingCars);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
