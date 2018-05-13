package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;
import com.plani.cms.dto.DeptVO;

public class DeptDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=dept_write_form";			
		
		int dept_no = Integer.parseInt(request.getParameter("dept_no"));

		DeptDAO mDao = DeptDAO.getInstance();
		mDao.deptDelete(dept_no);
		
		System.out.println("수정 성공");
		request.setAttribute("message", "<strong>부서 삭제 성공!</strong> &nbsp 삭제한 부서 번호 : " + dept_no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
