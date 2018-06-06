package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.MemberDAO;
import com.plani.cms.dto.MemberVO;

/*******************************************************
 * 
 * 	MemberSearchAction
 * 
 * 	사원 이름을 파라미터값으로 받아와 DB에서 검색하고 결과가 있을경우 list형태로 리턴한다
 * 
 *******************************************************/

public class CarlogMemberWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "carlog/carlog_member_popup.jsp";
		String mem_name = null;
		
		if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
			mem_name = request.getParameter("mem_name");
		} else {
			mem_name = new String(request.getParameter("mem_name").getBytes("8859_1"),"UTF-8");
		}
		
		
		System.out.println("받은 파라미터 : " + mem_name);
		
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberVO> mVoList = mDao.memberSearchByName(mem_name);
		
		request.setAttribute("memName", mem_name);
		
		if(mVoList.isEmpty()) { // 부분 일치의 결과가 없는 경우
			request.setAttribute("isLike", "no");
		} else { // 부분일치의 결과가 있는 경우			
			request.setAttribute("isLike", "yes");
			request.setAttribute("memList", mVoList);						
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
