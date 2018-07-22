package com.plani.cms.controller.action.repa;
/**
 * 정비내역 조회화면으로 이동 및  
 * 정비내역조회 시, 검색조건에 맞게 정비내역 데이터를  조회하는 액션 클래스
 * 
 * @author 윤한수
 *
 */
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
		String repa_s_date = (request.getParameter("repa_s_date") == null) ? "" : request.getParameter("repa_s_date"); //데이터가 null인 경우 ""으로 치환
		String repa_e_date = (request.getParameter("repa_e_date") == null) ? "" : request.getParameter("repa_e_date");
		String car_reg_no = (request.getParameter("car_reg_no") == null) ? "" : request.getParameter("car_reg_no");
		String cent_no = (request.getParameter("cent_no") == null) ? "" : request.getParameter("cent_no");
		String cent_name = (request.getParameter("cent_name") == null) ? "" : request.getParameter("cent_name");
		String car_model = (request.getParameter("car_model") == null) ? "" : request.getParameter("car_model");
		int count;
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
		Paging paging = new Paging(); //페이징 처리를 위해 페이징 객체 생성 Paging 이라는 VO가 존재함
		paging.setPageNo(page);
		paging.setPageSize(10);
		
		

		if(car_reg_no.equals("") && cent_no.equals("")&& repa_s_date.equals("") && repa_e_date.equals("") ){
			//최초 실행 시 모두 널 값(처음 정비내역 창이 띄워질 경우
			System.out.println("최초실행");
		}
		else if(car_reg_no.equals("") && cent_no.equals("")){ //정비 시작 날짜와 정비 종료 날짜만 입력했을 경우
			System.out.println("날짜만 입력");
			List<RepaVO> repaAllList = rDao.selectOnlyDate(repa_s_date, repa_e_date,page);
			count = rDao.selectOnlyDateCount(repa_s_date, repa_e_date);//페이징 처리를 위해 검색조건에 맞는 데이터의 갯수를 세는 메소드
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
		
		else{ //모두 입력 시 
			List<RepaVO> repaAllList = rDao.selectDateCentReg(repa_s_date,repa_e_date,cent_no,car_reg_no);
		request.setAttribute("repaAllList", repaAllList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
