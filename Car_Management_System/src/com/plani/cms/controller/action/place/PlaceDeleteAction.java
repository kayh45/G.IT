package com.plani.cms.controller.action.place;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.PlaceDAO;

public class PlaceDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "place.do?command=place_write_form";
		int place_no = Integer.parseInt(request.getParameter("place_no"));

		PlaceDAO pDao = PlaceDAO.getInstance();
		pDao.placeDelete(place_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>정비소 삭제 성공!</strong> &nbsp 삭제한 정비소 : " + place_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
