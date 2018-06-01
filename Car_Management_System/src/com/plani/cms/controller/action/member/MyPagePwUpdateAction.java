package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;
import com.plani.cms.dto.MemberVO;

public class MyPagePwUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "myPage/mp_pwUpdate.jsp";
		
		String mem_id = request.getParameter("mem_id");
		String currPass = request.getParameter("currPass");
		String modiPass = request.getParameter("modiPass");
		
		MemberVO mVo = new MemberVO();
		
		mVo.setMem_id(mem_id);
		mVo.setMem_pw(currPass);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int isCorrect = mDao.loginCheck(mVo); // 로그인 검사기능을 활용
		
		String message = "";
		String msgType = "success";
		
		if (isCorrect == 1) {
			mVo.setMem_pw(modiPass);
			mDao.passwordUpdate(mVo);
			message = "비밀번호가 성공적으로 변경되었습니다.";
		}else {
			message = "현재 비밀번호를 잘못 입력하셨습니다.";
			msgType = "danger";	
		}
		
		request.setAttribute("message", message);
		request.setAttribute("msgType", msgType);		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

	
}
