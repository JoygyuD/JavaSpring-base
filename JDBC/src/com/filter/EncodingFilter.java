package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/enco")
public class EncodingFilter implements Filter {

    public EncodingFilter() {}

	public void destroy() {}
	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전작업
		
		HttpServletRequest hrequest = (HttpServletRequest)request; //편의상 적용
		
		if(hrequest.getMethod().equals("POST")) { // 대문자로 써야한다
			request.setCharacterEncoding("utf-8");
		}
		System.out.println("doFilter이전"+request.getAttribute("message"));
		
		chain.doFilter(request, response);
		// 사후작업
	
		System.out.println("doFilter이후"+request.getAttribute("message"));
		
	}

}
