package com.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/enco")
public class EncodigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EncodigServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		System.out.println("서블릿에서 전달된 파라미터 출력");
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(address);
		
		request.setAttribute("message", "이 메세지는 서블렛에서 추가한 내용입니다.");
	}

}
