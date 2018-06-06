package com.plani.cms.controller.action.repa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.RepaDAO;

public class RepaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "repa.do?command=repa_write_form";
		int repa_no = Integer.parseInt(request.getParameter("repa_no"));
		System.out.println("정비내역번호"+repa_no);
		RepaDAO rDao = RepaDAO.getInstance();
		rDao.DeleteRepa(repa_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>정비내역 삭제 성공!</strong> &nbsp 삭제한 정비내역번호 : " + repa_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
