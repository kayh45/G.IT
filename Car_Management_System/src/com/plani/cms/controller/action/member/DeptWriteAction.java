package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;
import com.plani.cms.dto.DeptVO;

/**
 * 부서 정보 등록 기능을 구현한 액션 클래스
 * 
 * dept_name(부서 이름)을 파라미터로 받아와서 새로운 부서 정보로 등록하는 기능 수행
 * 
 * 모든 기능 수행 후 dept_write_form 액션으로 이동
 * 
 * @author 강현
 *
 */
public class DeptWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=dept_write_form";
		
		DeptVO dVo = new DeptVO();		
		
		String dept_name = request.getParameter("dept_usable_name");
		
		dVo.setDept_name(dept_name);
	
		DeptDAO dDao = DeptDAO.getInstance();
		dDao.deptInsert(dVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>부서 등록 성공!</strong> &nbsp 등록된 부서명 : " + dept_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
