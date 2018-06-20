package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarlogVO;
import com.plani.cms.dto.CourseVO;

public class CarlogAutoWriteNextAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_auto_write_form";
		
		String car_reg_no = request.getParameter("car_usable_no");
		String carlog_year = request.getParameter("carlog_year");
		String carlog_month = request.getParameter("carlog_month");
		String mem_id = request.getParameter("mem_id");
		int month_dist = Integer.parseInt(request.getParameter("driv_month_dist"));
		int cour_no = Integer.parseInt(request.getParameter("cour_no"));	
		int driv_dist = Integer.parseInt(request.getParameter("driv_dist"));	
		
		String[] card_day = request.getParameterValues("card_day");		
		String[] card_oil = request.getParameterValues("card_oil");		
		String[] card_trans = request.getParameterValues("card_trans");		
		String[] card_course = request.getParameterValues("card_course");
		
		CarlogAutoModel caModel = new CarlogAutoModel();
		List<CarlogAutoModel> caList = new ArrayList<CarlogAutoModel>();
		
		CourseVO cVo = new CourseVO();
		List<CourseVO> cList = new ArrayList<CourseVO>();
		
		Random rnd = new Random();
		
		int extra_options = card_day.length; // 추가 비용의 숫자
		int tol_day = 0;
		
		for(int i = 0; i < extra_options; i++) {
			caModel = new CarlogAutoModel();
			
			if (card_day[i].equals("")) {
				continue;
			}else {
				caModel.setAuto_day(Integer.parseInt(card_day[i]));
			}			
			if (card_oil[i].equals("")){
				caModel.setOil_fee(0);
			}else {
				caModel.setOil_fee(Integer.parseInt(card_oil[i]));
				caModel.setDistance(driv_dist + rnd.nextInt(3));
			}
			if (card_trans[i].equals("")){
				caModel.setTrans_fee(0);
			}else {
				caModel.setTrans_fee(Integer.parseInt(card_trans[i]));
				caModel.setDistance((int)(Integer.parseInt(card_trans[i])*0.02));
			}
			if (card_course[i].equals("")){
				caModel.setCour_no(1);
			}else {
				caModel.setCour_no(Integer.parseInt(card_course[i]));
				tol_day++;
			}
			
			caModel.setCard_divi("법인카드");
			caModel.setS_hour(9);
			caModel.setE_hour(18);
			
			caList.add(caModel);
		}
		
		/*
		 * 특정 달의 근무일수(평일)구하는 부분
		 * carlog_year => 선택한 연도
		 * carlog_month => 선택한 달
		 */		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(carlog_year), Integer.parseInt(carlog_month), 1);
		
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int workday = 0; // 이 달의 최대 근무일수
		
		for(int i = 1; i <= endDay; i++) {
			cal.set(Integer.parseInt(carlog_year), Integer.parseInt(carlog_month), i);
			int week = cal.get(Calendar.DAY_OF_WEEK);
			if (!(week == 1 || week == 7)) { // 1: 일요일 , 7: 토요일
				workday++;
				int check = 0;
				for(CarlogAutoModel model : caList) {
					if (model.getAuto_day() == i) {
						check++;
					}
				}
				if(check == 0) {
					caModel = new CarlogAutoModel();
					caModel.setAuto_day(i-1);
					caList.add(caModel);
				}
			}
		}
		
		int monthly_commute_dist = (workday-tol_day)*(driv_dist*2)-sumOfDistance(cList); 
		// (근무일수-톨비사용일수)*(출근거리+퇴근거리)-카드사용한거리
		
		if(monthly_commute_dist < month_dist) {
			int gap = month_dist - monthly_commute_dist;
			int divi = 1;			
			
			if(gap <= 20) {
				divi = 1;
			}else if(gap <= 50) {
				divi = 2;
			}else {				
				divi = rnd.nextInt(3) + 2;
			}
			System.out.println("==1==");
			for(int i = 0; i <= divi; i++) {
				int rnd_date = rnd.nextInt(endDay);
				boolean isDone = false;
				while(isDone) {
					for(CarlogAutoModel model : new ArrayList<>(caList)) {
						if(rnd_date == model.getAuto_day()) {
							if(model.getDistance() == 0) {
								int tempGap = gap/divi;
								CourseVO tempcVo = getNearCourse(cList, tempGap);
								
								
								caModel = model;
								
								caModel.setS_hour(9);
								caModel.setE_hour(18);
								caModel.setAuto_day(model.getAuto_day());
								caModel.setDistance(tempcVo.getDistance());
								caModel.setCour_no(tempcVo.getCour_no());
								caModel.setDriv_purpo(tempcVo.getCour_purpo());
								caModel.setDriv_divi(tempcVo.getCour_divi());
								
								caList.set(caList.indexOf(model), caModel);
								isDone = true;
								break;
							}else {
								break;
							}
						}						
					}
				}
			}						
		}
		System.out.println("==2==");		
		for(CarlogAutoModel model : new ArrayList<>(caList)) {
			
			if(model.getDistance() == 0) {
				
				caModel = model;
				
				caModel.setDistance(driv_dist);
				caModel.setS_hour(9);
				caModel.setE_hour(10);
				caModel.setCour_no(cour_no);
				caModel.setDriv_purpo("1.출근용");
				caModel.setDriv_divi("1");
				
				caList.set(caList.indexOf(model), caModel);
				
				caModel = model;
				
				caModel.setDistance(driv_dist);
				caModel.setS_hour(17);
				caModel.setE_hour(18);
				caModel.setCour_no(cour_no);
				caModel.setDriv_purpo("2.퇴근용");
				caModel.setDriv_divi("2");
				
				caList.add(caModel);
				
			}
		}
		
		int use_dist = 0;
		for(CarlogAutoModel model : caList) {
			use_dist += model.getDistance();
		}
				
		
		CarlogVO carlogVo = new CarlogVO();
		CarlogDAO clDao = CarlogDAO.getInstance();
		
		clDao.deleteAllAutoOneMonth(car_reg_no, carlog_year, carlog_month);
		System.out.println("==4==");
		for(CarlogAutoModel model : caList) {
			carlogVo = new CarlogVO();
			
			String date = carlog_year + "-" + carlog_month + "-" + model.getAuto_day();
			int sHour = model.getS_hour();
			int eHour = model.getE_hour();
			
			carlogVo.setDriv_s_date(date + " " + (sHour>=10?sHour:"0"+sHour) + ":00:00");
			carlogVo.setDriv_e_date(date + " " + (eHour>=10?eHour:"0"+eHour) + ":00:00");
			carlogVo.setCour_no(model.getCour_no());
			carlogVo.setDriv_dist(model.getDistance());
			carlogVo.setDriv_purpo(model.getDriv_purpo());
			carlogVo.setDriv_divi(model.getDriv_divi());
			carlogVo.setOil_fee(model.getOil_fee());
			carlogVo.setTrans_fee(model.getTrans_fee());
			carlogVo.setCard_divi(model.getCard_divi());
			
			carlogVo.setCar_reg_no(car_reg_no);
			carlogVo.setMem_id(mem_id);
			
			
			
			clDao.writeOneAutoCarlog(carlogVo);
			
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private CourseVO getNearCourse(List<CourseVO> cList, int dist) {	
		
		// 1. 초기화 및 선언       
        int near = dist;                              // 찾을 숫자
        int min = Integer.MAX_VALUE;    // 기준데이터 최소값 - Interger형의 최대값으로 값을 넣는다.
        CourseVO near_cVo = null;
        
        // 2. process       
        for(CourseVO cVo : cList) {
        	int temp = Math.abs(cVo.getDistance()-near);
        	if(min > temp){
                min = temp;
                near_cVo = cVo;
        	}
        }      	
		return near_cVo;
	}
	
	private int sumOfDistance(List<CourseVO> cList) {
		
		int sum = 0;
		
		for(CourseVO cVo : cList) {
			sum += cVo.getDistance();
		}
		
		return sum;		
	}
		
}