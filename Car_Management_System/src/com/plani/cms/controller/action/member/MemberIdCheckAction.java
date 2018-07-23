package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;

/**
 * 사원 id 중복체크 기능을 구현한 액션 클래스
 * 
 * 모든 기능 수행 후 결과를 가지고 id 중복체크 팝업 화면으로 이동
 * 
 * @author 강현
 *
 */
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
