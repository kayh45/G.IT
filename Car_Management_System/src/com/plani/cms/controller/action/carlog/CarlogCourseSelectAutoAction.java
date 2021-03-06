package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CourseDAO;
import com.plani.cms.dto.PlaceCourVO;

/**
 * 운행일지 장소 검색 화면으로 이동해주는 액션 클래스
 * 
 * @author kayh_develope
 *
 */
public class CarlogCourseSelectAutoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String place_name = new String(request.getParameter("place_name").getBytes("UTF-8"));
		String cour_divi = request.getParameter("cour_divi");
		String rownum = request.getParameter("rownum");
		
        System.out.println("레그넘 = "+ place_name);
		CourseDAO cDao = CourseDAO.getInstance();
		
		request.setAttribute("place_name", place_name);

		/* ------------------ car 체크----------------------- */
		String url = "carlog/carlog_course_search_auto.jsp";
		List<PlaceCourVO> s_placeList = null;
		
		System.out.println(cour_divi);
		if(cour_divi.equals("0")) {
			s_placeList = cDao.courAllplaceSearchByNameLike(place_name);		
		} else if(cour_divi.equals("1")) {
			s_placeList = cDao.courSplaceSearchByNameLike(place_name);					
		} else if(cour_divi.equals("2")) {
			s_placeList = cDao.courEplaceSearchByNameLike(place_name);
		}
		request.setAttribute("s_placeList", s_placeList);
		request.setAttribute("place_name", place_name);
		request.setAttribute("rownum", rownum);
/*		List<CarVO> carAllList = cDao.selectAllCar();
		request.setAttribute("carAllList", carAllList);*/

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
