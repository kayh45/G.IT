package com.plani.cms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 다양한 기능을 수행하는 Action들의 표준 형태를 
 * 규정하는 인터페이스
 * 
 * 모든 기능들은 execute 메소드 안에 정의되어야한다.
 * 
 * @author 강현
 *
 */
public interface Action {
	/**
	 * Action이 수행할 기능들을 정의
	 * 모든 기능이 수행된 후 
	 * RequestDispatcher의 forward() 메소드를 통해서 페이지 이동을 시켜줄 것을 권장
	 * 
	 * @see RequestDispatcher
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}