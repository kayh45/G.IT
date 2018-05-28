package com.plani.cms.controller;

import com.plani.cms.controller.action.Action;
import com.plani.cms.controller.action.LoginAction;
import com.plani.cms.controller.action.LogoutAction;
import com.plani.cms.controller.action.MainAction;
import com.plani.cms.controller.action.car.CarDeleteAction;
import com.plani.cms.controller.action.car.CarModifyAction;
import com.plani.cms.controller.action.car.CarWriteAction;
import com.plani.cms.controller.action.car.CarWriteCheckFormAction;
import com.plani.cms.controller.action.car.CarWriteFormAction;
import com.plani.cms.controller.action.cent.CentDeleteAction;
import com.plani.cms.controller.action.cent.CentModifyAction;
import com.plani.cms.controller.action.cent.CentWriteAction;
import com.plani.cms.controller.action.cent.CentWriteCheckFormAction;
import com.plani.cms.controller.action.cent.CentWriteFormAction;
import com.plani.cms.controller.action.course.CourDeleteAction;
import com.plani.cms.controller.action.course.CourEPlaceWriteCheckFormAction;
import com.plani.cms.controller.action.course.CourModifyAction;
import com.plani.cms.controller.action.course.CourSPlaceWriteCheckFormAction;
import com.plani.cms.controller.action.course.CourWriteAction;
import com.plani.cms.controller.action.course.CourWriteFormAction;
import com.plani.cms.controller.action.member.DeptDeleteAction;
import com.plani.cms.controller.action.member.DeptModifyAction;
import com.plani.cms.controller.action.member.DeptSearchAction;
import com.plani.cms.controller.action.member.DeptWriteAction;
import com.plani.cms.controller.action.member.DeptWriteCheckFormAction;
import com.plani.cms.controller.action.member.DeptWriteFormAction;
import com.plani.cms.controller.action.member.MemberDeleteAction;
import com.plani.cms.controller.action.member.MemberIdCheckAction;
import com.plani.cms.controller.action.member.MemberModifyAction;
import com.plani.cms.controller.action.member.MemberSearchAction;
import com.plani.cms.controller.action.member.MemberSearchFormAction;
import com.plani.cms.controller.action.member.MemberWriteAction;
import com.plani.cms.controller.action.member.MemberWriteFormAction;
import com.plani.cms.controller.action.place.PlaceDeleteAction;
import com.plani.cms.controller.action.place.PlaceModifyAction;
import com.plani.cms.controller.action.place.PlaceWriteAction;
import com.plani.cms.controller.action.place.PlaceWriteCheckFormAction;
import com.plani.cms.controller.action.place.PlaceWriteFormAction;
import com.plani.cms.controller.action.repa.RepaCarWriteCheckFormAction;
import com.plani.cms.controller.action.repa.RepaCentWriteCheckFormAction;
import com.plani.cms.controller.action.repa.RepaMemberSearchAction;
import com.plani.cms.controller.action.repa.RepaSearchFormAction;
import com.plani.cms.controller.action.repa.RepaWriteAction;
import com.plani.cms.controller.action.repa.RepaWriteFormAction;
import com.plani.cms.controller.action.reserve.ReserveWriteFormAction;

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

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("member_write_form")) { // 여기서 부터 멤버
			action = new MemberWriteFormAction();
		} else if (command.equals("member_write")) {
			action = new MemberWriteAction();
		} else if (command.equals("member_id_check")) {
			action = new MemberIdCheckAction();
		} else if (command.equals("member_search_form")) {
			action = new MemberSearchFormAction();
		} else if (command.equals("member_search")) {
			action = new MemberSearchAction();
		} else if (command.equals("member_modify")) {
			action = new MemberModifyAction();
		} else if (command.equals("member_delete")) {
			action = new MemberDeleteAction();
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
		}
		/* 법인차 기능 구현 start */
		else if (command.equals("car_write_form")) {
			action = new CarWriteFormAction();
		} else if (command.equals("car_write")) {
			action = new CarWriteAction();
		} else if (command.equals("car_modify")) {
			action = new CarModifyAction();
		} else if (command.equals("car_delete")) {
			action = new CarDeleteAction();
		} else if (command.equals("car_write_check_form")) {
			action = new CarWriteCheckFormAction();

			/* 법인차 기능 구현 end */
		}
		/* 정비소 기능 구현 start */
		else if (command.equals("cent_write_form")) {
			action = new CentWriteFormAction();
		} else if (command.equals("cent_write_check_form")) {
			action = new CentWriteCheckFormAction();
		} else if (command.equals("cent_write")) {
			action = new CentWriteAction();
		} else if (command.equals("cent_modify")) {
			action = new CentModifyAction();
		} else if (command.equals("cent_delete")) {
			action = new CentDeleteAction();
		} else if (command.equals("cent_write_check_form")) {
			action = new CentWriteCheckFormAction();
			/* 정비소 기능 구현 end */
		}  /* 장소 기능 구현 start */
		else if (command.equals("place_write_form")) {
			action = new PlaceWriteFormAction();
		}else if (command.equals("place_write")) {
				action = new PlaceWriteAction();
		}else if (command.equals("place_modify")) {
			action = new PlaceModifyAction();
		}else if (command.equals("place_delete")) {
			action = new PlaceDeleteAction();
		}else if (command.equals("place_write_check_form")) {
			action = new PlaceWriteCheckFormAction();
        /* 장소 기능 구현 end */
			 /* 경로 기능 구현 start */
		}else if (command.equals("cour_write_form")) {
				action = new CourWriteFormAction();
			}else if (command.equals("cour_write")) {
					action = new CourWriteAction();
			}else if (command.equals("cour_modify")) {
				action = new CourModifyAction();
			}else if (command.equals("cour_delete")) {
				action = new CourDeleteAction();
			}else if (command.equals("cour_splace_write_check_form")) {
				action = new CourSPlaceWriteCheckFormAction();
			}else if (command.equals("cour_eplace_write_check_form")) {
					action = new CourEPlaceWriteCheckFormAction();
	        /* 경로 기능 구현 end */
		/* 배차관리 기능 구현 start */
		} else if (command.equals("course_write_form")) {
			action = new CourSPlaceWriteCheckFormAction();
		} else if (command.equals("reserve_write_form")) {
			action = new ReserveWriteFormAction();
			/* 배차관리 기능 구현 end */
		} /* 정비내역 등록 구현 start */
		else if (command.equals("repa_write")) {
			action = new RepaWriteAction();
		} else if (command.equals("repa_write_form")) {
			action = new RepaWriteFormAction();
		} else if (command.equals("repa_car_write_check_form")) {
			action = new RepaCarWriteCheckFormAction();
		} else if (command.equals("repa_cent_write_check_form")) {
			action = new RepaCentWriteCheckFormAction();
		} else if (command.equals("repa_search_form")) {
			action = new RepaSearchFormAction();
		} else if (command.equals("repa_member_search")) {
			action = new RepaMemberSearchAction();
		} /* 정비내역 등록 구현 End */

		return action;

	}

}