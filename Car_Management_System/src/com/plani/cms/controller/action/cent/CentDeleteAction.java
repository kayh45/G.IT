package com.plani.cms.controller.action.cent;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
/**
 * 정비소를 삭제해주는 액션 클래스
 * 
 * @author 조성철
 *
 */
public class CentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "car.do?command=cent_write_form";
		int cent_no = Integer.parseInt(request.getParameter("cent_no"));

		CentDAO cDao = CentDAO.getInstance();
		cDao.DeleteCent(cent_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>정비소 삭제 성공!</strong> &nbsp 삭제한 정비소 : " + cent_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
