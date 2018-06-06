package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;

public class CarlogDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_write_form";
		int driv_no = Integer.parseInt(request.getParameter("driv_no"));

		CarlogDAO cDao = CarlogDAO.getInstance();
		cDao.DeleteCarlog(driv_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>정비소 삭제 성공!</strong> &nbsp 삭제한 운행일지 : " + driv_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
