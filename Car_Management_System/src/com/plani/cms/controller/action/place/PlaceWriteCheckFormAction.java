package com.plani.cms.controller.action.place;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.PlaceDAO;
import com.plani.cms.dto.PlaceVO;

/**
 * 장소 데이터 중복체크 후 조회 창을 보여주는 액션 클래스
 * 
 * @author 조성철
 *
 */
public class PlaceWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String place_name = null;
		
		if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수 있도록 하기 위함 
			place_name = request.getParameter("place_name");
		} else {
			place_name = new String(request.getParameter("place_name").getBytes("8859_1"),"UTF-8");
		}

        System.out.println("레그넘 = "+ place_name);
		PlaceDAO pDao = PlaceDAO.getInstance();

		int result = pDao.confirmPlaceName(place_name);

		System.out.println(result);

		request.setAttribute("place_name", place_name);
		request.setAttribute("result", result);

		/* ------------------ place 체크----------------------- */
		String url = "place/place_check.jsp";

		List<PlaceVO> placeList = pDao.placeSearchByNameLike(place_name);
		request.setAttribute("placeList", placeList);
		List<PlaceVO> placeAllList = pDao.selectAllPlace();
		request.setAttribute("placeAllList", placeAllList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
