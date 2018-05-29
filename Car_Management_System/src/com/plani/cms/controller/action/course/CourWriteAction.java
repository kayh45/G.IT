package com.plani.cms.controller.action.course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CourseDAO;
import com.plani.cms.dto.CourseVO;

public class CourWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "course.do?command=cour_write_form";
		
		CourseVO cVo = new CourseVO();	
		
		
		int s_place = Integer.parseInt(request.getParameter("s_place"));
		int e_place = Integer.parseInt(request.getParameter("e_place"));
		int distance = Integer.parseInt(request.getParameter("distance"));
		String cour_purpo = request.getParameter("cour_purpo");
		
		
		
		
		cVo.setS_place(s_place);
		cVo.setE_place(e_place);
		cVo.setDistance(distance);
		cVo.setCour_purpo(cour_purpo);	
		
		CourseDAO cDao = CourseDAO.getInstance();
		cDao.insertCourse(cVo);
		
		System.out.println("등록 성공");
		request.setAttribute("message", "<strong>경로 등록 성공!</strong>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}