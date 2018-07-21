package com.plani.cms.controller.action.carlog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.CarlogVO;
/**
 * 운행일지를 등록하는 액션 클래스
 * 이동 후 운행일지 등록 페이지로 이동
 * 
 * @author CHO
 *
 */
public class CarlogWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_write_form";

		CarlogVO cVo = new CarlogVO();
		CarVO caVo = new CarVO();

		int driv_no = Integer.parseInt(request.getParameter("driv_no"));
		int cour_no = Integer.parseInt(request.getParameter("cour_no"));
		String driv_purpo = request.getParameter("driv_purpo");
		String driv_divi = request.getParameter("driv_divi");
		int driv_dist = Integer.parseInt(request.getParameter("driv_dist"));
		String card_divi = request.getParameter("card_divi");
		int oil_fee = Integer.parseInt(request.getParameter("oil_fee"));
		int trans_fee = Integer.parseInt(request.getParameter("trans_fee"));
		String etc_text = request.getParameter("etc_text");
		int etc_fee = Integer.parseInt(request.getParameter("etc_fee"));
		String car_reg_no = request.getParameter("car_reg_no");
		
		System.out.println("래그넘 = " +  card_divi);

		cVo.setDriv_no(driv_no);
		cVo.setCour_no(cour_no);
		cVo.setDriv_purpo(driv_purpo);
		cVo.setDriv_divi(driv_divi);
		cVo.setDriv_dist(driv_dist);
		cVo.setCard_divi(card_divi);
		cVo.setOil_fee(oil_fee);
		cVo.setTrans_fee(trans_fee);
		cVo.setEtc_text(etc_text);
		cVo.setEtc_fee(etc_fee);
		caVo.setCar_reg_no(car_reg_no);

		System.out.println("번호" +driv_no);
		System.out.println("경로" +cour_no);
		System.out.println("목적" +driv_purpo);
		System.out.println("구분" +driv_divi);
		System.out.println("거리" +driv_dist);
		System.out.println("카드" +card_divi);
		System.out.println("유류" +oil_fee);
		System.out.println("통해" +trans_fee);
		System.out.println("기타텍스트" +etc_text);
		System.out.println("기타비" +etc_fee);
		System.out.println("차번호" +car_reg_no);
		
		CarlogDAO cDao = CarlogDAO.getInstance();
		
		// 카드 사용 내역 미사용과 사용을 분기하여 메소드 호출
		if (card_divi.equals("미사용")) {
			cDao.updateCarlogNofee(cVo);
			cDao.updateCarDist(caVo,cVo);
	
		}  else {
			cDao.updateCarlog(cVo);
			cDao.updateCarDist(caVo,cVo);
		}
		
		System.out.println(driv_dist);
		System.out.println("등록 성공");
		request.setAttribute("message", "<strong>운행일지 작성 성공!</strong>");

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}