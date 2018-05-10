package com.plani.cms.controller.action.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.DeptDAO;
import com.plani.cms.dto.DeptVO;

/* ===============================================
 * 
 * 
 * 	DeptWriteCheckFormAction
 * 
 * 		설명: 부서명을 파라미터값으로 받아와 DB에서 검색하고 결과가 있을경우 list형태로 리턴한다
 * 
 * 		작성자 : 강현
 * 
 * 		작성일 : 2018.5.9
 * 
 * 		수정자 : 
 * 
 * 		수정일 : 
 *
 *
 *==================================================*/

public class DeptWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/deptCheck.jsp";
		
		String dept_name = new String(request.getParameter("dept_name").getBytes("8859_1"),"utf-8");
		// 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
		
		System.out.println("받은 파라미터 : " + dept_name);
		
		DeptDAO dDao = DeptDAO.getInstance();
		List<DeptVO> result = dDao.DeptSearchByName(dept_name);
		
		if(result.isEmpty()) {
			request.setAttribute("isExist", "no");
			request.setAttribute("deptName", dept_name);
		} else {
			request.setAttribute("isExist", "yes");
			request.setAttribute("deptList", result);
		}
		
		System.out.println("받은 파라미터 : " + dept_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
