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
 * 운행일지 등록 창에서 경로를 조회하는 액션 클래스
 * 
 * @author 조성철
 *
 */
public class CarlogCourseSelectAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String place_name = new String(request.getParameter("place_name").getBytes("UTF-8"));
		String cour_divi = request.getParameter("cour_divi");
		
        System.out.println("레그넘 = "+ place_name);
		CourseDAO cDao = CourseDAO.getInstance();
		
		/*int result = cDao.confirmCarNo(car_reg_no);

		System.out.println(result);
*/
		request.setAttribute("place_name", place_name);

		/* ------------------ car 체크----------------------- */
		String url = "carlog/carlog_course_search.jsp";
		List<PlaceCourVO> s_placeList = null;
		
		System.out.println(cour_divi);
		
		// 검색 조건에 따라 검색 메소드를 분기
		if(cour_divi.equals("0")) {
			s_placeList = cDao.courAllplaceSearchByNameLike(place_name);		
		
		} else if(cour_divi.equals("1")) {
			s_placeList = cDao.courSplaceSearchByNameLike(place_name);					
		
		} else if(cour_divi.equals("2")) {
			s_placeList = cDao.courEplaceSearchByNameLike(place_name);
		}
	
		request.setAttribute("s_placeList", s_placeList);
		request.setAttribute("place_name", place_name);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
