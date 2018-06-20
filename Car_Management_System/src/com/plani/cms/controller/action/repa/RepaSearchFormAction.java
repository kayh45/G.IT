package com.plani.cms.controller.action.repa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.RepaDAO;
import com.plani.cms.dto.Paging;
import com.plani.cms.dto.RepaVO;

public class RepaSearchFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "repa/repa_search.jsp";
		String repa_s_date = (request.getParameter("repa_s_date") == null) ? "" : request.getParameter("repa_s_date");
		String repa_e_date = (request.getParameter("repa_e_date") == null) ? "" : request.getParameter("repa_e_date");
		String car_reg_no = (request.getParameter("car_reg_no") == null) ? "" : request.getParameter("car_reg_no");
		String cent_no = (request.getParameter("cent_no") == null) ? "" : request.getParameter("cent_no");
		String cent_name = (request.getParameter("cent_name") == null) ? "" : request.getParameter("cent_name");
		String car_model = (request.getParameter("car_model") == null) ? "" : request.getParameter("car_model");
		int count;
		System.out.println("배차 신청 날짜 :"+ repa_s_date);
		System.out.println("배차 종료 날짜 :"+ repa_e_date);
		System.out.println("정비소번호 :"+ cent_no);
		System.out.println("차량 번호 :"+ car_reg_no);
		System.out.println("정비소 명 :"+ cent_name);
		System.out.println("차 종 :"+ car_model);
		
		request.setAttribute("repa_s_date", repa_s_date);
		request.setAttribute("repa_e_date", repa_e_date);
		request.setAttribute("cent_no", cent_no);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("cent_name", cent_name);
		request.setAttribute("car_model", car_model);
		
		RepaDAO rDao = RepaDAO.getInstance();
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("현재 페이지:" + page);
		}
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(10);
		// paging.setTotalCount(44);
		// List<CarviewVO> list = vDao.selectAllCarview(page);
		

		if(car_reg_no.equals("") && cent_no.equals("")&& repa_s_date.equals("") && repa_e_date.equals("") ){
			//최초 실행 시 모두 널 값
			System.out.println("최초실행");
		}
		else if(car_reg_no.equals("") && cent_no.equals("")){ //정비 시작 날짜와 정비 종료 날짜만 입력했을 경우
			System.out.println("날짜만 입력");
			List<RepaVO> repaAllList = rDao.selectOnlyDate(repa_s_date, repa_e_date,page);
			count = rDao.selectOnlyDateCount(repa_s_date, repa_e_date);
			paging.setTotalCount(count);
			System.out.println("카운트:" + count);
			request.setAttribute("repaAllList", repaAllList);
			request.setAttribute("paging", paging);
			request.setAttribute("count", count);
			
		}
		else if(car_reg_no.equals("")){ //정비 시작 날짜,정비 종료, 정비소 번호만 입력
			List<RepaVO> repaAllList = rDao.selectDateCent(repa_s_date,repa_e_date,cent_no);
			request.setAttribute("repaAllList", repaAllList);
		}
		else if(cent_no.equals("")){ //정비 시작 날짜,정비 종료, 차량 번호만 입력
			List<RepaVO> repaAllList = rDao.selectDateReg(repa_s_date,repa_e_date,car_reg_no);
			request.setAttribute("repaAllList", repaAllList);
		}
		/*List<RepaVO> repaList = rDao.carSearchByNameLike(car_reg_no);
		request.setAttribute("repaList", repaList);*/
		else{ //모두 입력 시 
			List<RepaVO> repaAllList = rDao.selectDateCentReg(repa_s_date,repa_e_date,cent_no,car_reg_no);
		request.setAttribute("repaAllList", repaAllList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
