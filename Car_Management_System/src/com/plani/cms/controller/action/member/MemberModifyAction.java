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

public class MemberModifyAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=member_search_form";
		
		MemberVO mVo = new MemberVO();	
		
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_jumin = request.getParameter("mem_jumin1") + request.getParameter("mem_jumin2");
		String p_no = request.getParameter("mem_p_no");
		String mem_addr = request.getParameter("mem_addr1");
		String mem_addr_dtl = request.getParameter("mem_addr2");
		String mem_hp = request.getParameter("mem_hp1") + request.getParameter("mem_hp2") + request.getParameter("mem_hp3");
		String mem_posi = request.getParameter("mem_posi");
		String mem_auth = request.getParameter("mem_auth");
		int dept_no = Integer.parseInt(request.getParameter("dept_no"));
		
		mVo.setMem_id(mem_id);
		mVo.setMem_name(mem_name);
		mVo.setMem_jumin(mem_jumin);
		mVo.setMem_p_no(p_no);
		mVo.setMem_addr(mem_addr);
		mVo.setMem_addr_dtl(mem_addr_dtl);
		mVo.setMem_hp(mem_hp);
		switch (mem_posi) {
			case "0" :	mVo.setMem_posi("사원"); break;
			case "1" : 	mVo.setMem_posi("인턴"); break;
			case "2" : 	mVo.setMem_posi("사원"); break;
			case "3" : 	mVo.setMem_posi("대리"); break;
			case "4" : 	mVo.setMem_posi("팀장"); break;
			case "5" : 	mVo.setMem_posi("그룹장"); break;
			case "6" : 	mVo.setMem_posi("임원"); break;
			case "7" : 	mVo.setMem_posi("사장"); break;
			default : mVo.setMem_posi("사원"); break;
		}
		mVo.setMem_auth(mem_auth);
		mVo.setDept_no(dept_no);
	
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberUpdate(mVo);
		
		System.out.println("수정 성공");
		request.setAttribute("message", "<strong>사원 수정 성공!</strong> &nbsp 수정한 사원 : " + mem_name + "(" + mem_id+ ")");
		
		// 마이페이지에서 내정보수정을 하면 다시 그 페이지로 리다이렉트되도록 하는 if문
		if(request.getParameter("isMypage").equals("1")) { 
			HttpSession session = request.getSession();
			url = "member.do?command=mypage_infoupdate_form";
			MemberVO sessionVo = mDao.getMemberInfoAll(mVo);
			session.setAttribute("LoginUser", sessionVo);
			System.out.println(sessionVo);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}