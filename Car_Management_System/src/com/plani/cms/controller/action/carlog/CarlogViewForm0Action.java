package com.plani.cms.controller.action.carlog;
/**(사용자용)
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
import javax.servlet.http.HttpSession;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarviewDAO;
import com.plani.cms.dto.CarviewVO;
import com.plani.cms.dto.MemberVO;
import com.plani.cms.dto.Paging;

public class CarlogViewForm0Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog/carlog_view_0.jsp";
		String repa_s_date = request.getParameter("repa_s_date");
		String repa_e_date = request.getParameter("repa_e_date");
		HttpSession session = request.getSession();
		MemberVO logSession = (MemberVO)session.getAttribute("LoginUser"); 
		String mem_id = logSession.getMem_id(); //회원이름은 현재 접속한 세션에서 가져옴 사용자는 자신의 운행일지 내역만 조회가능
		int count = 0;

		request.setAttribute("repa_s_date", repa_s_date);
		request.setAttribute("repa_e_date", repa_e_date);
		
		CarviewDAO vDao = CarviewDAO.getInstance();
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("현재 페이지:" + page);
		}
		Paging paging = new Paging(); //페이징 처리를 위해 페이징 객체 생성 Paging 이라는 VO가 존재함
		paging.setPageNo(page);
		paging.setPageSize(10);
	
		if(repa_s_date==null && repa_e_date==null ){
			//최초 실행 시 모두 널 값
		}

		else{ //모두 입력 시  
			System.out.println("모두 입력됨");
			List<CarviewVO> carlogAllList = vDao.selectDateCar0(repa_s_date,repa_e_date,mem_id,page);
			count = vDao.selectDateCar0(repa_s_date, repa_e_date,mem_id);
			paging.setTotalCount(count);
			System.out.println("카운트" + count);
			request.setAttribute("count", count);
			request.setAttribute("carlogAllList", carlogAllList);
			request.setAttribute("paging", paging);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		/*-----------------------List 불러오기 -----------------------*/

	}

}
