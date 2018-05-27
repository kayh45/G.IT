package com.plani.cms.controller.action.repa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.RepaDAO;
import com.plani.cms.dto.RepaVO;

public class RepaCarWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "repa/repa_check.jsp";
		String car_reg_no = null;
		
		if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
			car_reg_no = request.getParameter("car_reg_no");
		} else {
			car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"),"UTF-8");
		}
		
		
		System.out.println("받은 파라미터 : " + car_reg_no);
		
		RepaDAO rDao = RepaDAO.getInstance();
		List<RepaVO> rVoList = rDao.repaSearchByCarRegNoLike(car_reg_no);
		
		request.setAttribute("car_reg_no", car_reg_no);
		
		if(rVoList.isEmpty()) { // 부분 일치의 결과가 없는 경우
			request.setAttribute("isLike", "no");
		} else { // 부분일치의 결과가 있는 경우
			RepaVO rVoMatch = rDao.repaSearchByCarRegNo(car_reg_no);
			
			request.setAttribute("isLike", "yes");
			request.setAttribute("centList", rVoList);
			
			System.out.println(rVoMatch.getCent_no());
			
			if(rVoMatch.getCent_no() == 0) {	// 부분 일치하지만 완전 일치하지 않은 경우			 
				request.setAttribute("isMatch", "no");
			}else { // 부분 일치와 완전 일치를 모두 만족하는 경우
				request.setAttribute("isMatch", "yes");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
