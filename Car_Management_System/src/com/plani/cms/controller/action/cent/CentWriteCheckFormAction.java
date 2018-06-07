package com.plani.cms.controller.action.cent;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
import com.plani.cms.dao.PlaceDAO;
import com.plani.cms.dto.CentVO;
import com.plani.cms.dto.PlaceVO;

public class CentWriteCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cent/cent_check.jsp";
		String cent_name = null;

		if (request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로
															// 받을 수 있도록 하기 위함
			cent_name = request.getParameter("cent_name");
		} else {
			cent_name = new String(request.getParameter("cent_name").getBytes("8859_1"), "UTF-8");
		}

		System.out.println("레그넘 = " + cent_name);
		CentDAO cDao = CentDAO.getInstance();

		int result = cDao.confirmCentName(cent_name);

		System.out.println(result);
		request.setAttribute("cent_name", cent_name);
		request.setAttribute("result", result);
		/*
		 * =====================================================================
		 */
		List<CentVO> cVoList = cDao.centSearchByNameLike(cent_name);

		request.setAttribute("cent_name", cent_name);

		List<CentVO> centList = cDao.centSearchByNameLike(cent_name);
		request.setAttribute("centList", centList);
		List<CentVO> centAllList = cDao.selectAllCent();
		request.setAttribute("centAllList", centAllList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}

/*
 * String place_name = null;
 * 
 * if(request.getParameter("popup").equals("yes")) { // 한글로 입력 받았을 때 제대로 받을 수
 * 있도록 하기 위함 place_name = request.getParameter("place_name"); } else {
 * place_name = new
 * String(request.getParameter("place_name").getBytes("8859_1"),"UTF-8"); }
 * 
 * System.out.println("레그넘 = "+ place_name); PlaceDAO pDao =
 * PlaceDAO.getInstance();
 * 
 * int result = pDao.confirmPlaceName(place_name);
 * 
 * System.out.println(result);
 * 
 * request.setAttribute("place_name", place_name);
 * request.setAttribute("result", result);
 * 
 * ------------------ place 체크----------------------- String url =
 * "place/place_check.jsp";
 * 
 * List<PlaceVO> placeList = pDao.placeSearchByNameLike(place_name);
 * request.setAttribute("placeList", placeList); List<PlaceVO> placeAllList =
 * pDao.selectAllPlace(); request.setAttribute("placeAllList", placeAllList);
 * 
 * RequestDispatcher dispatcher = request.getRequestDispatcher(url);
 * dispatcher.forward(request, response);
 * 
 * -----------------------List 불러오기 -----------------------
 * 
 * }
 * 
 * }
 */