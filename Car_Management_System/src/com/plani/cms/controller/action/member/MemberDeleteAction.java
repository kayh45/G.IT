package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;
import com.plani.cms.dto.MemberVO;

/**
 * 사원 정보 삭제(관리자) 기능을 구현한 액션 클래스
 * 
 * 모든 기능 수행 후 사원 등록 화면으로 이동
 * 
 * @author PC38219
 *
 */
public class MemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=member_search_form";			
		
		String mem_id = request.getParameter("mem_id");
		String mem_name = new String(request.getParameter("mem_name").getBytes("8859_1"),"UTF-8");
		
		HttpSession session = request.getSession();
		MemberVO logSession = (MemberVO)session.getAttribute("LoginUser");
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberDelete(mem_id);
				
		if(logSession.getMem_id().equals(mem_id)) {
			session.invalidate();
		}
		
		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>사원 삭제 성공!</strong> &nbsp 삭제한 사원 : " + mem_name + "(" + mem_id+ ")");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
