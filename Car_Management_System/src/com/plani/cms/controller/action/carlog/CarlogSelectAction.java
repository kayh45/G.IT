package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarlogVO;
import com.plani.cms.dto.MemberVO;

public class CarlogSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CarlogDAO cDao = CarlogDAO.getInstance();
			
			HttpSession session = request.getSession();
			MemberVO logSession = (MemberVO)session.getAttribute("LoginUser");
			String mem_id = logSession.getMem_id();
			
			/*mDao.getMemberInfoAll(mem_id);*/
					
			
			request.setAttribute("mem_id", mem_id);


			
			System.out.println(mem_id);
			System.out.println("레그넘 = " + mem_id);

	

		String url = "carlog/carlog_search.jsp";
		/*List<CarlogVO> carlogList = cDao.drivSearchAllByName(mem_id);
		request.setAttribute("carlogList", carlogList);*/
		
			List<CarlogVO> NocarlogList = cDao.drivSearchByNameNoncomplete(mem_id);
			request.setAttribute("NocarlogList", NocarlogList);
		
				List<CarlogVO> carlogList = cDao.drivSearchByNameComplete(mem_id);
				request.setAttribute("carlogList", carlogList);
		 

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}