package com.plani.cms.controller;

import com.plani.cms.controller.action.Action;
import com.plani.cms.controller.action.MainAction;
import com.plani.cms.controller.action.car.CarWriteFormAction;
import com.plani.cms.controller.action.member.DeptWriteFormAction;
import com.plani.cms.controller.action.member.MemberWriteFormAction;
import com.plani.cms.controller.action.place.PlaceWriteFormAction;


public class ActionFactory {

	//주석
	
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
		} else if (command.equals("member_write_form")) {
			action = new MemberWriteFormAction();
		} else if (command.equals("dept_write_form")) {
			action = new DeptWriteFormAction();
		} else if (command.equals("car_write_form")) {
			action = new CarWriteFormAction();
		} else if (command.equals("place_write_form")) {
			action = new PlaceWriteFormAction();
		}
		
		return action;
	
	}
	
}