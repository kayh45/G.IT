package com.plani.cms.controller.action.carlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plani.cms.controller.action.Action;

public class CarlogAutoWriteNextAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		
		String car_reg_no = request.getParameter("car_usable_no");
		String carlog_year = request.getParameter("car_reg_no");
		String carlog_month = request.getParameter("car_reg_no");
		String mem_id = request.getParameter("mem_id");
		int avg_oil = Integer.parseInt(request.getParameter("avg_oil"));
		int rate_oil = Integer.parseInt(request.getParameter("rate_oil"));
		String cour_no = request.getParameter("cour_no");
		String driv_purpo = request.getParameter("driv_purpo");
		String distance = request.getParameter("distance");
		
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
		total_dist -= (tol*0.02);
		System.out.println("총 주행거리(톨비 제외) : " + total_dist);
								
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	}