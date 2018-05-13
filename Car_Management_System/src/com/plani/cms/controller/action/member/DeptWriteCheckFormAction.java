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

/*******************************************************
 * 
 * 	DeptWriteCheckFormAction
 * 
 * 	부서명을 파라미터값으로 받아와 DB에서 검색하고 결과가 있을경우 list형태로 리턴한다
 * 
 *******************************************************/

public class DeptWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/deptCheck.jsp";
		String dept_name = null;
		
		if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
			dept_name = request.getParameter("dept_name");
		} else {
			dept_name = new String(request.getParameter("dept_name").getBytes("8859_1"),"UTF-8");
		}
		
		
		System.out.println("받은 파라미터 : " + dept_name);
		
		DeptDAO dDao = DeptDAO.getInstance();
		List<DeptVO> dVoList = dDao.deptSearchByNameLike(dept_name);
		
		request.setAttribute("deptName", dept_name);
		
		if(dVoList.isEmpty()) { // 부분 일치의 결과가 없는 경우
			request.setAttribute("isLike", "no");
		} else { // 부분일치의 결과가 있는 경우
			DeptVO dVoMatch = dDao.deptSearchByName(dept_name);
			
			request.setAttribute("isLike", "yes");
			request.setAttribute("deptList", dVoList);
			
			System.out.println(dVoMatch.getDept_no());
			
			if(dVoMatch.getDept_no() == 0) {	// 부분 일치하지만 완전 일치하지 않은 경우			 
				request.setAttribute("isMatch", "no");
			}else { // 부분 일치와 완전 일치를 모두 만족하는 경우
				request.setAttribute("isMatch", "yes");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
