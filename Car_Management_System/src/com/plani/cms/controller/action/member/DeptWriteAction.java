package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;
import com.plani.cms.dto.DeptVO;

public class DeptWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=dept_write_form";
		
		DeptVO dVo = new DeptVO();		
		
		String dept_name = request.getParameter("dept_name");
		
		dVo.setDept_name(dept_name);
	
		DeptDAO mDao = DeptDAO.getInstance();
		mDao.deptInsert(dVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "부서 등록 성공 : " + dept_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
