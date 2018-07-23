package com.plani.cms.controller.action.carlog;

import com.plani.cms.dto.CarlogVO;

/**
 * 자동 작성 시 사용할 임시 모델
 * 
 * @author 강현
 *
 */
public class CarlogAutoModel extends CarlogVO{

	private int auto_day;

	public int getAuto_day() {
		return auto_day;
	}

	public void setAuto_day(int auto_day) {
		this.auto_day = auto_day;
	}
	
	
}
