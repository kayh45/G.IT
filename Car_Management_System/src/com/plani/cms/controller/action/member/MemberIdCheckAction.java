package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;

public class MemberIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "member/idCheck.jsp";
		String id = request.getParameter("mem_id");		
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		request.setAttribute("mem_id", id);
		request.setAttribute("isExist", mDao.idDupCheck(id));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
