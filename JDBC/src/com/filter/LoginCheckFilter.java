package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/auth/*")
public class LoginCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request; // 매개변수를 타입을 붙여 새로운 객체에 저장
		HttpSession session = req.getSession(); // 세션 객체 생성
		HttpServletResponse res = (HttpServletResponse)response;
		System.out.println("LoginCheckFilter");
		
		if(session != null) {
			String id = (String)session.getAttribute("user_id");
			
			if(id == null) { // 로그인 하지 않아 세션이 없는 경우
				res.sendRedirect("/JDBC/login.jsp");
			}
		}
		
		chain.doFilter(request, response);
		
	}

}
