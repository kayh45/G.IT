package com.plani.cms.controller.action.place;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.PlaceDAO;
import com.plani.cms.dto.PlaceVO;

/**
 * 장소 데이터를 수정해주는 액션 클래스
 * 
 * @author 조성철
 *
 */
public class PlaceModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String url = "place.do?command=place_write_form";
		
		PlaceVO pVo = new PlaceVO();	
		
		int place_no = Integer.parseInt(request.getParameter("place_no"));
		String place_name = request.getParameter("place_name");
		int place_p_no = Integer.parseInt(request.getParameter("place_p_no"));
		String place_addr = request.getParameter("place_addr");
		String place_addr_dtl = request.getParameter("place_addr_dtl");
		String place_divi = request.getParameter("place_divi");

		pVo.setPlace_no(place_no);
		pVo.setPlace_name(place_name);
		pVo.setPlace_p_no(place_p_no);
		pVo.setPlace_addr(place_addr);
		pVo.setPlace_addr_dtl(place_addr_dtl);
		pVo.setPlace_divi(place_divi);

		PlaceDAO pDao = PlaceDAO.getInstance();
	
		pDao.placeUpdate(pVo);
		
		System.out.println("수정 성공");
		request.setAttribute("message", "<strong>장소 수정 성공!</strong> &nbsp 수정된 장소 이름: " +  place_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
