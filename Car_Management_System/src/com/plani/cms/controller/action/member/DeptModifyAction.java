package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;
import com.plani.cms.dto.DeptVO;

public class DeptModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member.do?command=dept_write_form";
		
		DeptVO dVo = new DeptVO();		
		
		int dept_no = Integer.parseInt(request.getParameter("dept_no"));
		String dept_name = request.getParameter("dept_usable_name");
		
		dVo.setDept_no(dept_no);
		dVo.setDept_name(dept_name);
	
		DeptDAO mDao = DeptDAO.getInstance();
		mDao.deptUpdate(dVo);
		
		System.out.println("수정 성공");
		request.setAttribute("message", "부서 수정 성공 : " + dept_no + ", " +  dept_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
