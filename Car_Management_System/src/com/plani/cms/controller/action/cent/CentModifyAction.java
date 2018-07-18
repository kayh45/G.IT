package com.plani.cms.controller.action.cent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
import com.plani.cms.dto.CentVO;

public class CentModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "car.do?command=cent_write_form";		
		
		CentVO cVo = new CentVO();	
		
		
		String cent_no = request.getParameter("cent_no");
		String cent_name = request.getParameter("cent_name");
		String ceo_name = request.getParameter("ceo_name");
		String cent_tell = request.getParameter("cent_tell1") + request.getParameter("cent_tell2") + request.getParameter("cent_tell3");
		String cent_fax = request.getParameter("cent_fax1") + request.getParameter("cent_fax2") + request.getParameter("cent_fax3");
		String cent_p_no = request.getParameter("cent_p_no");
		String cent_addr = request.getParameter("cent_addr");
		String cent_addr_dtl = request.getParameter("cent_addr_dtl");
		
		
		cVo.setCent_no(Integer.parseInt(cent_no));
		cVo.setCent_name(cent_name);
		cVo.setCeo_name(ceo_name);
		cVo.setCent_tell(cent_tell);	
		cVo.setCent_fax(cent_fax);	
		cVo.setCent_p_no(Integer.parseInt(cent_p_no));	
		cVo.setCent_addr(cent_addr);	
		cVo.setCent_addr_dtl(cent_addr_dtl);	
		
		
		CentDAO cDao = CentDAO.getInstance();
		cDao.updateCent(cVo);
		
		System.out.println("�벑濡앹꽦怨�");
		request.setAttribute("message", "<strong>�젙鍮꾩냼 �닔�젙 �꽦怨�!</strong> &nbsp �닔�젙�맂 �젙鍮꾩냼 �씠由� : " + cent_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	}

