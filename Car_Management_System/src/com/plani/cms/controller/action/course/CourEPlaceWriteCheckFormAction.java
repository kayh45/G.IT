package com.plani.cms.controller.action.course;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.PlaceDAO;
import com.plani.cms.dto.PlaceVO;

public class CourEPlaceWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String place_name = new String(request.getParameter("e_place_name").getBytes("UTF-8"));

        System.out.println("레그넘 = "+ place_name);
		PlaceDAO pDao = PlaceDAO.getInstance();

		int result = pDao.confirmPlaceName(place_name);

		System.out.println(result);

		request.setAttribute("place_name", place_name);
		request.setAttribute("result", result);

		/* ------------------ place 체크----------------------- */
		String url = "course/cour_eplace_check.jsp";

		List<PlaceVO> placeList = pDao.placeSearchByNameLike(place_name);
		request.setAttribute("placeList", placeList);
		List<PlaceVO> placeAllList = pDao.selectAllPlace();
		request.setAttribute("placeAllList", placeAllList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

} 