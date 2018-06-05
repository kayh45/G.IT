package com.plani.cms.controller.action.place;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.PlaceDAO;
import com.plani.cms.dto.PlaceVO;

public class PlaceWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "place.do?command=place_write_form";
		
		PlaceVO pVo = new PlaceVO();	
		
		
		String place_name = request.getParameter("place_name");
		int place_p_no = Integer.parseInt(request.getParameter("place_p_no"));
		String place_addr = request.getParameter("place_addr");
		String place_addr_dtl = request.getParameter("place_addr_dtl");
		
	
		pVo.setPlace_name(place_name);
		pVo.setPlace_p_no(place_p_no);
		pVo.setPlace_addr(place_addr);
		pVo.setPlace_addr_dtl(place_addr_dtl);
		
		PlaceDAO pDao = PlaceDAO.getInstance();
		pDao.placeInsert(pVo);
		
		System.out.println("등록 성공");
		request.setAttribute("message", "<strong>장소 등록 성공!</strong> &nbsp 등록된 장소이름 : ");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}