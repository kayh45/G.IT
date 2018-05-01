package com.plani.cms.controller;

import com.plani.cms.controller.action.Action;
import com.plani.cms.controller.action.member.MemberJoinFormAction;

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
	
		if(command.equals("member_join_form")){
			action = new MemberJoinFormAction();
		} 
		
		return action;
	
	}
	
}