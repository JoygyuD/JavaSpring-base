package com.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharUpperWrapper extends HttpServletRequestWrapper {
	// 기본멤버가 있다. 상속받은 녀석
	HttpServletRequest request;

	public CharUpperWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		return super.getParameter(name).toUpperCase(); // 대문자 변환
	}

}
