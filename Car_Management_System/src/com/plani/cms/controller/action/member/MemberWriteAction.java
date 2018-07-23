package com.plani.cms.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;
import com.plani.cms.dto.MemberVO;

/**
 * 사원 정보 등록 기능을 구현한 액션 클래스
 * 
 * 모든 기능 수행 후 사원 등록 화면으로 이동
 * 
 * @author 강현
 *
 */
public class MemberWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member.do?command=member_write_form";
		
		MemberVO mVo = new MemberVO();	
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_jumin1");
		String mem_name = request.getParameter("mem_name");
		String mem_jumin = request.getParameter("mem_jumin1") + request.getParameter("mem_jumin2");
		String p_no = request.getParameter("mem_p_no");
		String mem_addr = request.getParameter("mem_addr1");
		String mem_addr_dtl = request.getParameter("mem_addr_dtl");
		String mem_hp = request.getParameter("mem_hp1") + request.getParameter("mem_hp2") + request.getParameter("mem_hp3");
		String mem_posi = request.getParameter("mem_posi");
		String mem_auth = request.getParameter("mem_auth");
		int dept_no = Integer.parseInt(request.getParameter("dept_no"));
		
		mVo.setMem_id(mem_id);
		mVo.setMem_pw(mem_pw);
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
		mDao.memberInsert(mVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>사원 등록 성공!</strong> &nbsp 등록된 사원이름 : " + mem_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}