package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;
import com.plani.cms.dao.CarlogDAO;
import com.plani.cms.dto.CarlogVO;

public class CarlogAutoWriteNextAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "carlog.do?command=carlog_auto_write_form";
		
		String car_reg_no = request.getParameter("car_usable_no");
		String carlog_year = request.getParameter("carlog_year");
		String carlog_month = request.getParameter("carlog_month");
		String mem_id = request.getParameter("mem_id");
		int avg_oil = Integer.parseInt(request.getParameter("avg_oil"));
		int rate_oil = Integer.parseInt(request.getParameter("rate_oil"));
		String cour_no = request.getParameter("cour_no");
		String driv_purpo = request.getParameter("driv_purpo");
		int distance = Integer.parseInt(request.getParameter("distance"));
		
		String[] card_day = request.getParameterValues("card_day");		
		String[] card_oil = request.getParameterValues("card_oil");		
		String[] card_trans = request.getParameterValues("card_trans");		
		String[] card_course = request.getParameterValues("card_course");		
		
		int extra_options = card_day.length;
		
		int card_arr[][] = new int[4][extra_options];
		for(int j = 0; j <= 3; j++) {
			for(int i = 0; i < extra_options; i++) {
				switch (j) {
				 case 0 : card_arr[0][i] = (card_day[i]==""?0:Integer.parseInt(card_day[i])); break;
				 case 1 : card_arr[1][i] = (card_oil[i]==""?0:Integer.parseInt(card_oil[i])); break;
				 case 2 : card_arr[2][i] = (card_trans[i]==""?0:Integer.parseInt(card_trans[i])); break;
				 case 3 : card_arr[3][i] = (card_course[i]==""?0:Integer.parseInt(card_course[i])); break;
				}
			}
		}
		
		int total_dist = 0, oil = 0, tol = 0;
		
		for(int i = 0; i < card_arr[0].length; i++) {			
			oil += card_arr[1][i];
			tol += card_arr[2][i];			
		}
		
		total_dist += (oil/avg_oil*rate_oil); // 유류비÷평균유가*연비　
		total_dist += (tol*0.02); // 톨비*0.02 (킬로당 50원으로 상정)
		total_dist *= 0.8;
		System.out.println("총 주행거리 : " + total_dist);		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(carlog_year), Integer.parseInt(carlog_month), 1);
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int workday = 0;
		
		for(int i = 1; i <= endDay; i++) {
			int week = cal.get(Calendar.DAY_OF_WEEK);
			if (!(week == 1 || week == 7)) {
				workday++;
			}
		}
		
		int remainDist = 0;
		if((total_dist/distance)>workday) {
			remainDist = total_dist - (distance * workday);
		}
		
		int[][] carlogArr = new int[5][32]; // 일자,거리,유류비,교통비,경로번호
		for(int i = 1; i <= endDay; i++) {
			boolean notTol = false;
			boolean isOil = false;
			int tol_fee = 0;
			int oil_fee = 0;
			int tol_cour = 0;
			for(int j = 0; j < card_arr[0].length; j++) {
				if(i == card_arr[0][j]) {
					if(card_arr[2][j] != 0) {
						notTol = false;
						isOil = false;
						tol_fee = card_arr[2][j];
						tol_cour = card_arr[3][j];
					}else if(card_arr[1][j] != 0){
						notTol = true;
						isOil = true;
						oil_fee = card_arr[1][j];
					}
				}else {
					notTol = true;
					isOil = false;
				}
			}
			cal.set(Integer.parseInt(carlog_year), Integer.parseInt(carlog_month), i);
			int week = cal.get(Calendar.DAY_OF_WEEK);
			if (!(week == 1 || week == 7)) {
				Random rnd = new Random();
				int rndNo = rnd.nextInt(5);
				int dayJump = 0;
				if(remainDist<0){
					dayJump = rnd.nextInt(-remainDist/200);
				}
				System.out.println(i);
				carlogArr[0][i] = i;
				System.out.println(total_dist + ", " + notTol + ", " + isOil);
				
				if(total_dist >= 0) {
					if(notTol) {
						if(!isOil) {
							if((remainDist-rndNo)>=0) {
								remainDist -= rndNo;
								carlogArr[1][i] = distance + rndNo;
							}else {
								carlogArr[1][i] = distance;
							}
						}else {
							if((remainDist-(rndNo*2))>=0) {
								remainDist -= rndNo;
								carlogArr[1][i] = distance + (rndNo*2);
							}else {
								carlogArr[1][i] = distance + 2;
							}
						}
					}else {
						carlogArr[1][i] = (int)(tol_fee * 0.02);
					}
					total_dist -= carlogArr[1][i];
				}else {
					carlogArr[1][i] = 0;
				}								
				carlogArr[2][i] = oil_fee;
				carlogArr[3][i] = tol_fee;
				carlogArr[4][i] = tol_cour;

					i += dayJump;

			}
			
		}
			
		CarlogDAO cDao = CarlogDAO.getInstance();
			int count = 0;
			for(int j = 1; j < carlogArr[0].length; j++) {				
				if(carlogArr[0][j] != 0) {
					String day_j;
					if(j < 10){
						day_j = "0" + j;
					}else {
						day_j = "" + j;
					}
					CarlogVO cVo = new CarlogVO();
					cVo.setDriv_s_date(carlog_year+"-"+carlog_month+"-"+day_j+" 09:00:00");
					cVo.setDriv_e_date(carlog_year+"-"+carlog_month+"-"+day_j+" 18:00:00");
					cVo.setCar_reg_no(car_reg_no);
					cVo.setMem_id(mem_id);
					if(carlogArr[3][j] != 0) {
						cVo.setCour_no(carlogArr[4][j]);
						cVo.setDriv_purpo("거래처 방문");
					}else {
						cVo.setCour_no(Integer.parseInt(cour_no));
						cVo.setDriv_purpo(driv_purpo);
					}
					int c_year = Integer.parseInt(carlog_year);
					int c_month = Integer.parseInt(carlog_month);
					if(count == 0) {
						if (c_month == 1) {
							cVo.setBefo_dist(cDao.getPreMonthBefoDist(car_reg_no, c_year-1, 12));
						}else {
							cVo.setBefo_dist(cDao.getPreMonthBefoDist(car_reg_no, c_year, c_month-1));
						}						
					}else {
						cVo.setBefo_dist(count);
					}
					
					cVo.setDriv_dist(carlogArr[1][j]);
					count = cVo.getBefo_dist() + cVo.getDriv_dist();
					
					cVo.setCard_divi("법인카드");
					cVo.setOil_fee(carlogArr[2][j]);
					cVo.setTrans_fee(carlogArr[3][j]);
					
					cDao.writeOneAutoCarlog(cVo);
				}											
			}
			cDao.autoUpdateCarDist(car_reg_no, count);
			
						
			
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}