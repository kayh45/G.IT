package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=member_search_form";			
		
		String mem_id = request.getParameter("mem_id");
		String mem_name = new String(request.getParameter("mem_name").getBytes("8859_1"),"UTF-8");

		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberDelete(mem_id);
		
		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>부서 삭제 성공!</strong> &nbsp 삭제한 사원 : " + mem_name + "(" + mem_id+ ")");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
