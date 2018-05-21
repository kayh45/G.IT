package com.plani.cms.controller.action.cent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
import com.plani.cms.dto.CentVO;

public class CentWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "cent.do?command=cent_write_form";
		
		CentVO cVo = new CentVO();	
		

		
		String cent_name = request.getParameter("cent_name");
		String ceo_name = request.getParameter("ceo_name");
		String cent_tell1 = request.getParameter("cent_tell1");
		String cent_tell2 = request.getParameter("cent_tell2");
		String cent_tell3 = request.getParameter("cent_tell3");
		String cent_fax1 = request.getParameter("cent_fax1");
		String cent_fax2 = request.getParameter("cent_fax2");
		String cent_fax3 = request.getParameter("cent_fax3");
		String cent_p_no = request.getParameter("cent_p_no");
		String cent_addr1 = request.getParameter("cent_addr1");
		String cent_addr2 = request.getParameter("cent_addr2");
		
		
		cVo.setCent_name(cent_name);
		cVo.setCeo_name(ceo_name);
		cVo.setCent_tell1(cent_tell1);	
		cVo.setCent_tell2(cent_tell2);	
		cVo.setCent_tell3(cent_tell3);	
		cVo.setCent_fax1(cent_fax1);	
		cVo.setCent_fax2(cent_fax2);	
		cVo.setCent_fax3(cent_fax3);	
		cVo.setCent_p_no(Integer.parseInt(cent_p_no));	
		cVo.setCent_addr1(cent_addr1);	
		cVo.setCent_addr2(cent_addr2);	
		
		CentDAO cDao = CentDAO.getInstance();
		cDao.insertCent(cVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>정비소 등록 성공!</strong> &nbsp 등록된 정비소 이름 : " + cent_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}

