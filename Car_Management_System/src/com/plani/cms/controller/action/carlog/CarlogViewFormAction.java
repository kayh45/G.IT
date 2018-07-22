package com.plani.cms.controller.action.carlog;
/**(관리자용)
 * 운행일지 조회 창으로 이동 및
 * 운행일지 조회 시, 검색조건에 맞게 운행일지 데이터를  조회하는 액션 클래스 
 *  
 * @author 윤한수
 *
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarviewDAO;
import com.plani.cms.dto.CarviewVO;
import com.plani.cms.dto.Paging;

public class CarlogViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog/carlog_view.jsp";
		String repa_s_date = (request.getParameter("repa_s_date") == null) ? "" : request.getParameter("repa_s_date");//null 발생 시 ""으로  처리
		String repa_e_date = (request.getParameter("repa_e_date") == null) ? "" : request.getParameter("repa_e_date");
		String car_reg_no = (request.getParameter("car_reg_no") == null) ? "" : new String(request.getParameter("car_reg_no").getBytes("UTF-8"));
		String car_model = (request.getParameter("car_model") == null) ? "" : new String(request.getParameter("car_model").getBytes("UTF-8"));
		String mem_name = (request.getParameter("mem_name") == null) ? "" : new String(request.getParameter("mem_name").getBytes("UTF-8"));
		String mem_id = (request.getParameter("mem_id") == null) ? "" : new String(request.getParameter("mem_id").getBytes("UTF-8"));
		int count = 0;
		request.setAttribute("repa_s_date", repa_s_date); // 조회 클릭 후 jsp화면에
		request.setAttribute("repa_e_date", repa_e_date);
		request.setAttribute("car_reg_no", car_reg_no);
		request.setAttribute("car_model", car_model);
		request.setAttribute("mem_name", mem_name);
		request.setAttribute("mem_id", mem_id);
		
		CarviewDAO vDao = CarviewDAO.getInstance();
		int page = 1;
		
		//검색 조건에 따라 if문으로 분기
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("현재 페이지:" + page);
		}
		Paging paging = new Paging();   //페이징 처리를 위해 페이징 객체 생성 Paging 이라는 VO가 존재함
		paging.setPageNo(page);
		paging.setPageSize(10);
	
		if (car_reg_no.equals("") && repa_s_date.equals("") && repa_e_date.equals("") && mem_id.equals("")) {
			// 최초 실행 시 모두 널 값 
			System.out.println("최초실행");
		} 
		
		else if (repa_s_date != null && repa_e_date != null && mem_id.equals("") && car_reg_no.equals("")) {// 운행기간만 입력할 경우
			System.out.println("운행기간만 입력");
			List<CarviewVO> carlogAllList = vDao.selectPageDate(repa_s_date, repa_e_date, page);
			count = vDao.selectPageDateCount(repa_s_date, repa_e_date); //페이징 처리를 위해 검색조건에 맞는 데이터의 갯수를 세는 메소드
			paging.setTotalCount(count);
			System.out.println("카운트:" + count);
			request.setAttribute("carlogAllList", carlogAllList);
			request.setAttribute("paging", paging);
			request.setAttribute("count", count);
		}

		else if (repa_s_date != null && repa_e_date != null && mem_id.equals("") && car_reg_no != null) {
			System.out.println("운행기간,차량등록 번호 입력"); // 운행기간, 차량등록번호 입력
			List<CarviewVO> carlogAllList = vDao.selectDateCar(repa_s_date, repa_e_date, car_reg_no, page);
			count = vDao.selectDateCar(repa_s_date, repa_e_date, car_reg_no); //페이징 처리를 위해 검색조건에 맞는 데이터의 갯수를 세는 메소드
			paging.setTotalCount(count);
			System.out.println("카운트" + count);
			request.setAttribute("carlogAllList", carlogAllList);
			request.setAttribute("paging", paging);
			request.setAttribute("count", count);
		} else if (repa_s_date != null && repa_e_date != null && mem_id != null && car_reg_no.equals("")) {
			System.out.println("운행기간,사원이름 입력");// 운행기간 사원이름 입력
			List<CarviewVO> carlogAllList = vDao.selectDateMem(repa_s_date, repa_e_date, mem_id, page);
			count = vDao.selectDateMem(repa_s_date, repa_e_date, mem_id); //페이징 처리를 위해 검색조건에 맞는 데이터의 갯수를 세는 메소드
			paging.setTotalCount(count);
			System.out.println("카운트" + count);
			request.setAttribute("carlogAllList", carlogAllList);
			request.setAttribute("paging", paging);
			request.setAttribute("count", count);
		} else { // 모두 입력 시
			System.out.println("모두 입력됨");
			List<CarviewVO> carlogAllList = vDao.selectAll(repa_s_date, repa_e_date, car_reg_no, mem_id, page);
			count = vDao.selectAll(repa_s_date, repa_e_date, car_reg_no, mem_id); //페이징 처리를 위해 검색조건에 맞는 데이터의 갯수를 세는 메소드
			paging.setTotalCount(count);
			System.out.println("카운트" + count);
			request.setAttribute("carlogAllList", carlogAllList);
			request.setAttribute("paging", paging);
			request.setAttribute("count", count);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
