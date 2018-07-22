package com.plani.cms.controller;

import com.plani.cms.controller.action.Action;
import com.plani.cms.controller.action.LoginAction;
import com.plani.cms.controller.action.LogoutAction;
import com.plani.cms.controller.action.MainAction;
import com.plani.cms.controller.action.car.CarDeleteAction;
import com.plani.cms.controller.action.car.CarExpenseAction;
import com.plani.cms.controller.action.car.CarExpenseFormAction;
import com.plani.cms.controller.action.car.CarModifyAction;
import com.plani.cms.controller.action.car.CarSearchAction;
import com.plani.cms.controller.action.car.CarWriteAction;
import com.plani.cms.controller.action.car.CarWriteCheckFormAction;
import com.plani.cms.controller.action.car.CarWriteFormAction;
import com.plani.cms.controller.action.carlog.CarlogAutoCheckAction;
import com.plani.cms.controller.action.carlog.CarlogAutoWriteFormAction;
import com.plani.cms.controller.action.carlog.CarlogAutoWriteNextAction;
import com.plani.cms.controller.action.carlog.CarlogCourseSelectAction;
import com.plani.cms.controller.action.carlog.CarlogCourseSelectAutoAction;
import com.plani.cms.controller.action.carlog.CarlogCourseSelectFormAction;
import com.plani.cms.controller.action.carlog.CarlogCourseSelectFormAutoAction;
import com.plani.cms.controller.action.carlog.CarlogDeleteAction;
import com.plani.cms.controller.action.carlog.CarlogMemberSearchAction;
import com.plani.cms.controller.action.carlog.CarlogMemberWriteFormAction;
import com.plani.cms.controller.action.carlog.CarlogSelectAction;
import com.plani.cms.controller.action.carlog.CarlogViewForm0Action;
import com.plani.cms.controller.action.carlog.CarlogViewFormAction;
import com.plani.cms.controller.action.carlog.CarlogWriteAction;
import com.plani.cms.controller.action.carlog.CarlogWriteFormAction;
import com.plani.cms.controller.action.carlog.ExcelFormAction;
import com.plani.cms.controller.action.cent.CentDeleteAction;
import com.plani.cms.controller.action.cent.CentModifyAction;
import com.plani.cms.controller.action.cent.CentWriteAction;
import com.plani.cms.controller.action.cent.CentWriteCheckFormAction;
import com.plani.cms.controller.action.cent.CentWriteFormAction;
import com.plani.cms.controller.action.course.CourDeleteAction;
import com.plani.cms.controller.action.course.CourEPlaceWriteCheckFormAction;
import com.plani.cms.controller.action.course.CourModifyAction;
import com.plani.cms.controller.action.course.CourSPlaceWriteCheckFormAction;
import com.plani.cms.controller.action.course.CourSelectAction;
import com.plani.cms.controller.action.course.CourSelectFormAction;
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
import com.plani.cms.controller.action.member.MyPageHomeAction;
import com.plani.cms.controller.action.member.MyPageInfoUpdateFormAction;
import com.plani.cms.controller.action.member.MyPagePwUpdateAction;
import com.plani.cms.controller.action.member.MyPagePwUpdateFormAction;
import com.plani.cms.controller.action.place.PlaceDeleteAction;
import com.plani.cms.controller.action.place.PlaceModifyAction;
import com.plani.cms.controller.action.place.PlaceWriteAction;
import com.plani.cms.controller.action.place.PlaceWriteCheckFormAction;
import com.plani.cms.controller.action.place.PlaceWriteFormAction;
import com.plani.cms.controller.action.repa.RepaCarWriteCheckFormAction;
import com.plani.cms.controller.action.repa.RepaCentWriteCheckFormAction;
import com.plani.cms.controller.action.repa.RepaDeleteAction;
import com.plani.cms.controller.action.repa.RepaModifyAction;
import com.plani.cms.controller.action.repa.RepaSearchFormAction;
import com.plani.cms.controller.action.repa.RepaSearchMoveFormAction;
import com.plani.cms.controller.action.repa.RepaWriteAction;
import com.plani.cms.controller.action.repa.RepaWriteFormAction;
import com.plani.cms.controller.action.reserve.ReserveDeleteAction;
import com.plani.cms.controller.action.reserve.ReserveViewCarsAction;
import com.plani.cms.controller.action.reserve.ReserveViewScheduleAction;
import com.plani.cms.controller.action.reserve.ReserveWriteAction;
import com.plani.cms.controller.action.reserve.ReserveWriteFormAction;


/**
 * request로 받아온 매개변수의 command의 값으로 
 * 각 기능을 수행할 액션을 분기하는 클래스
 * <br>
 * action추가 시 최대한 기능별로 정렬될 수 있도록 한다.
 * 수정이 잦은 class이므로 주의하여 편집!!
 * 
 * @author 강현
 *
 */
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
		} else if (command.equals("mypage_home")) {
			action = new MyPageHomeAction();
		} else if (command.equals("mypage_pwupdate_form")) {
			action = new MyPagePwUpdateFormAction();
		} else if (command.equals("mypage_pwupdate")) {
			action = new MyPagePwUpdateAction();
		} else if (command.equals("mypage_infoupdate_form")) {
			action = new MyPageInfoUpdateFormAction();
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
		} else if (command.equals("car_search")) {
			action = new CarSearchAction();
		} else if (command.equals("car_write_check_form")) {
			action = new CarWriteCheckFormAction();

		}else if (command.equals("car_expense_form")) {
			action = new CarExpenseFormAction();

		}else if (command.equals("car_expense")) {
			action = new CarExpenseAction();

		}
		/* 법인차 기능 구현 end */
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
		} /* 장소 기능 구현 start */
		else if (command.equals("place_write_form")) {
			action = new PlaceWriteFormAction();
		} else if (command.equals("place_write")) {
			action = new PlaceWriteAction();
		} else if (command.equals("place_modify")) {
			action = new PlaceModifyAction();
		} else if (command.equals("place_delete")) {
			action = new PlaceDeleteAction();
		} else if (command.equals("place_write_check_form")) {
			action = new PlaceWriteCheckFormAction();
			/* 장소 기능 구현 end */
			/* 경로 기능 구현 start */
		} else if (command.equals("cour_write_form")) {
			action = new CourWriteFormAction();
		} else if (command.equals("cour_write")) {
			action = new CourWriteAction();
		} else if (command.equals("cour_modify")) {
			action = new CourModifyAction();
		} else if (command.equals("cour_delete")) {
			action = new CourDeleteAction();
		} else if (command.equals("cour_splace_write_check_form")) {
			action = new CourSPlaceWriteCheckFormAction();
		} else if (command.equals("cour_eplace_write_check_form")) {
			action = new CourEPlaceWriteCheckFormAction();
		} else if (command.equals("cour_select")) {
			action = new CourSelectAction();
		} else if (command.equals("cour_select_form")) {
			action = new CourSelectFormAction();
			/* 경로 기능 구현 end */
			/* 배차관리 기능 구현 start */
		} else if (command.equals("course_write_form")) {
			action = new CourWriteFormAction();
		} else if (command.equals("place_write_form")) {
			action = new PlaceWriteFormAction();
		} else if (command.equals("reserve_write_form")) {
			action = new ReserveWriteFormAction();
		} else if (command.equals("reserve_view_cars")) {
			action = new ReserveViewCarsAction();
		} else if (command.equals("reserve_write")) {
			action = new ReserveWriteAction();
		} else if (command.equals("reserve_view_schedule")) {
			action = new ReserveViewScheduleAction();
			/* 배차관리 기능 구현 end */
		} /* 정비내역 등록 구현 start */

		else if (command.equals("reserve_delete")) {
			action = new ReserveDeleteAction();
		}
		/* 배차관리 기능 구현 end */
		/* 정비내역 등록 구현 start */

		else if (command.equals("repa_write")) {
			action = new RepaWriteAction();
		}else if (command.equals("repa_modify")){
			action = new RepaModifyAction();
		}else if (command.equals("repa_delete")){
			action = new RepaDeleteAction();
		}else if (command.equals("repa_write_form")) {
			action = new RepaWriteFormAction();
		} else if (command.equals("repa_car_write_check_form")) {
			action = new RepaCarWriteCheckFormAction();
		} else if (command.equals("repa_cent_write_check_form")) {
			action = new RepaCentWriteCheckFormAction();
		} else if (command.equals("repa_search_form")) {
			action = new RepaSearchFormAction();
		} 
		else if (command.equals("repa_search_move_form")) {
			action = new RepaSearchMoveFormAction();
		} /* 정비내역 등록 구현 End */

			/* 정비내역 등록 구현 End */
			/* 운행일지 기능 구현 start */
		 else if (command.equals("carlog_write_form")) {
			action = new CarlogWriteFormAction();
		} else if (command.equals("carlog_write")) {
			action = new CarlogWriteAction();
		} else if (command.equals("carlog_delete")) {
			action = new CarlogDeleteAction();
		}else if (command.equals("carlog_select")) {
			action = new CarlogSelectAction();
		} else if (command.equals("carlog_course_select_form")) {
			action = new CarlogCourseSelectFormAction();
		} else if (command.equals("carlog_course_select")) {
			action = new CarlogCourseSelectAction();
		} else if (command.equals("carlog_auto_write_form")) {
			action = new CarlogAutoWriteFormAction();
		} else if (command.equals("carlog_view_form")) { //세션 권한이 관리자일 경우 이쪽폼으로 이동
			action = new CarlogViewFormAction();
		} else if (command.equals("carlog_view_form_0")) {//세션권한이 일반사용자면 이쪽폼으로 이동
			action = new CarlogViewForm0Action();
		} else if (command.equals("carlog_member_search")) {
			action = new CarlogMemberWriteFormAction();	
		}else if (command.equals("excel_form")) {
			action = new ExcelFormAction();
		}else if (command.equals("carlog_member_search")) {
			action = new CarlogMemberWriteFormAction();	
		} else if (command.equals("carlog_auto_write_next")) {
			action = new CarlogAutoWriteNextAction();
		} else if (command.equals("carlog_auto_check")) {
			action = new CarlogAutoCheckAction();
		} else if (command.equals("carlog_course_select_form_auto")) {
			action = new CarlogCourseSelectFormAutoAction();
		} else if (command.equals("carlog_course_select_auto")) {
			action = new CarlogCourseSelectAutoAction();
		} else if (command.equals("carlog_member_search")) {
		action = new CarlogMemberSearchAction();
	}
		return action;
	}

}