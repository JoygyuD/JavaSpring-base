package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/enco"})
public class Simplefilter implements Filter {

    public Simplefilter() {
    }
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("필터 실행됨");
		System.out.println(request.getParameter("name"));
		CharUpperWrapper reqWrapper = new CharUpperWrapper((HttpServletRequest)request);
		
		chain.doFilter(reqWrapper, response);
		System.out.println("서블릿 동작 후 필터 실행 종료(simple)");
		
	}


}
