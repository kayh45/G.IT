package com.plani.cms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plani.cms.dao.MemberDAO;
import com.plani.cms.dto.MemberVO;
import com.plani.cms.util.SHA256;

/**
 * 로그인 기능을 구현한 액션 클래스
 * 
 * 모든 기능 수행 후 메인화면으로 이동
 * 
 * @author 강현
 *
 */
public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "main.do?command=main";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LoginUser") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			MemberVO mVo = new MemberVO();
			MemberDAO mDao = MemberDAO.getInstance();
			
			String mem_pw = request.getParameter("mem_pw");
			String sha_pw = SHA256.getSHA256(mem_pw);
			
			mVo.setMem_id(request.getParameter("mem_id"));
			mVo.setMem_pw(sha_pw);
			
			System.out.println(sha_pw);
			
			System.out.println(mDao.loginCheck(mVo));
			
			switch (mDao.loginCheck(mVo)) {
				case 1: 
				{
					MemberVO sessionVo = mDao.getMemberInfoAll(mVo);
					session.setAttribute("LoginUser", sessionVo);
					System.out.println(sessionVo);
					break;
				}
				case 0: {
					request.setAttribute("message", "비밀번호를 확인하세요"); 
					url = "main.do?command=loginForm";
					break;
				}
				case -1: {					
					request.setAttribute("message", "존재하지 않는 회원입니다");
					url = "main.do?command=loginForm";
					break;
				}
				default : request.setAttribute("message", "오류가 발생했습니다");
			}					
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}
}
