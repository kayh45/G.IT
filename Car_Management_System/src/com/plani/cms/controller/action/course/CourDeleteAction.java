package com.plani.cms.controller.action.course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CourseDAO;

public class CourDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course.do?command=cour_write_form";

		
		int cour_no = Integer.parseInt(request.getParameter("cour_no"));

		
		CourseDAO cDao = CourseDAO.getInstance();
		cDao.DeleteCourse(cour_no);

		System.out.println("삭제 성공");
		request.setAttribute("message", "<strong>정비소 삭제 성공!</strong>");

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
