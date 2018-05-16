package com.plani.cms.controller;

import com.plani.cms.controller.action.Action;
import com.plani.cms.controller.action.LoginAction;
import com.plani.cms.controller.action.LogoutAction;
import com.plani.cms.controller.action.MainAction;
import com.plani.cms.controller.action.car.CarWriteAction;
import com.plani.cms.controller.action.car.CarWriteFormAction;
import com.plani.cms.controller.action.course.CourseWriteFormAction;
import com.plani.cms.controller.action.member.DeptDeleteAction;
import com.plani.cms.controller.action.member.DeptModifyAction;
import com.plani.cms.controller.action.member.DeptSearchAction;
import com.plani.cms.controller.action.member.DeptWriteAction;
import com.plani.cms.controller.action.member.DeptWriteCheckFormAction;
import com.plani.cms.controller.action.member.DeptWriteFormAction;
import com.plani.cms.controller.action.member.MemberIdCheckAction;
import com.plani.cms.controller.action.member.MemberWriteAction;
import com.plani.cms.controller.action.member.MemberWriteFormAction;
import com.plani.cms.controller.action.place.PlaceWriteFormAction;


/* ===============================================
 * 
 * 
 * 	ActionFactory
 * 
 * 		설명: request로 받아온 parameter중에 command의 값으로 각 액션을 분기한다.
 * 
 * 		작성자 : 강현
 * 
 * 		작성일 : 2018.5.9
 * 
 * 		참고 : action추가 시 최대한 기능별로 정렬될 수 있도록 한다.
 * 			  수정이 잦은 class이므로 주의하여 편집!!
 *
 *
 *==================================================*/

public class ActionFactory {

	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
	
		if(command.equals("main")){
			action = new MainAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("member_write_form")) {
			action = new MemberWriteFormAction();
		} else if (command.equals("member_write")) {
			action = new MemberWriteAction();
		} else if (command.equals("member_id_check")) {
			action = new MemberIdCheckAction();
		} else if (command.equals("dept_search")) {
			action = new DeptSearchAction();
		} else if (command.equals("dept_write")) {
			action = new DeptWriteAction();
		} else if (command.equals("dept_write_form")) {
			action = new DeptWriteFormAction();
		} else if (command.equals("dept_write_check_form")) {
			action = new DeptWriteCheckFormAction();
		} else if (command.equals("dept_modify")) {
			action = new DeptModifyAction();
		} else if (command.equals("dept_delete")) {
			action = new DeptDeleteAction();
		} else if (command.equals("car_write_form")) {
			action = new CarWriteFormAction();
		} else if (command.equals("car_write")) {
			action = new CarWriteAction();
		} else if (command.equals("course_write_form")) {
			action = new CourseWriteFormAction();
		} else if (command.equals("place_write_form")) {
			action = new PlaceWriteFormAction();
		}
		
		return action;
	
	}
	
}