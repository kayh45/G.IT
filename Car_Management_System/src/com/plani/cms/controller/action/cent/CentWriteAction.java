package com.plani.cms.controller.action.cent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CentDAO;
import com.plani.cms.dto.CentVO;

/**
 * 정비소를 등록해주는 액션 클래스 
 * 
 * @author 조성철
 *
 */

public class CentWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "cent.do?command=cent_write_form";
		
		CentVO cVo = new CentVO();	
		

		
		String cent_name = request.getParameter("cent_name");
		String ceo_name = request.getParameter("ceo_name");
		String cent_tell = request.getParameter("cent_tell1") + request.getParameter("cent_tell2") + request.getParameter("cent_tell3");
		String cent_fax = request.getParameter("cent_fax1") + request.getParameter("cent_fax2") + request.getParameter("cent_fax3");
		String cent_p_no = request.getParameter("cent_p_no");
		String cent_addr = request.getParameter("cent_addr");
		String cent_addr_dtl = request.getParameter("cent_addr_dtl");
		
		
		cVo.setCent_name(cent_name);
		cVo.setCeo_name(ceo_name);
		cVo.setCent_tell(cent_tell);	
		cVo.setCent_fax(cent_fax);	
		cVo.setCent_p_no(Integer.parseInt(cent_p_no));	
		cVo.setCent_addr(cent_addr);	
		cVo.setCent_addr_dtl(cent_addr_dtl);	
		
		CentDAO cDao = CentDAO.getInstance();
		cDao.insertCent(cVo);
		
		System.out.println("등록성공");
		request.setAttribute("message", "<strong>정비소 등록 성공!</strong> &nbsp 등록된 정비소 이름 : " + cent_name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}

