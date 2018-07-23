package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;

/**
 * 부서 정보 삭제 기능을 구현한 액션 클래스
 * 모든 기능 수행 후 dept_write_form 액션으로 이동
 * 
 * @author 강현
 *
 */
public class DeptDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=dept_write_form";			
		
		int dept_no = Integer.parseInt(request.getParameter("dept_no"));

		DeptDAO dDao = DeptDAO.getInstance();
		dDao.deptDelete(dept_no);
		
		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>부서 삭제 성공!</strong> &nbsp 삭제한 부서 번호 : " + dept_no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
