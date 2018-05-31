package com.plani.cms.controller.action.cent;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
import com.plani.cms.dto.CentVO;

public class CentWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cent/cent_check.jsp";
		String cent_name = null;
		
		if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
			cent_name = request.getParameter("cent_name");
		} else {
			cent_name = new String(request.getParameter("cent_name").getBytes("8859_1"),"UTF-8");
		}
		
		
		System.out.println("받은 파라미터 : " + cent_name);
		
		CentDAO cDao = CentDAO.getInstance();
		List<CentVO> cVoList = cDao.centSearchByNameLike(cent_name);
		
		request.setAttribute("cent_name", cent_name);
		
		if(cVoList.isEmpty()) { // 부분 일치의 결과가 없는 경우
			request.setAttribute("isLike", "no");
		} else { // 부분일치의 결과가 있는 경우
			CentVO cVoMatch = cDao.centSearchByName(cent_name);
			
			request.setAttribute("isLike", "yes");
			request.setAttribute("centList", cVoList);
			
			System.out.println(cVoMatch.getCent_no());
			
			if(cVoMatch.getCent_no() == 0) {	// 부분 일치하지만 완전 일치하지 않은 경우			 
				request.setAttribute("isMatch", "no");
			}else { // 부분 일치와 완전 일치를 모두 만족하는 경우
				request.setAttribute("isMatch", "yes");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
