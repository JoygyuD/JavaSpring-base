package com.ok;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_ok")
public class login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 로그인 form태그로 부터 전달 받은 값 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB와 연동을 위한 변수 선언
//		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String user = "myjsp";
//		String password ="myjsp";
		
//		// DB접속 처리할 객체 생성
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		// PreparedStatement객체에서 처리할 SQL문 작성
//		String sql = "select * from members where id= ? and pw= ?";
//		try {
//			// 1. 드라이버 로드
//			Class.forName(driver);
//			
//			// 2. 커넥트 생성
//			conn = DriverManager.getConnection(url, user, password);
//			
//			// 3. PrepareStatemnet 객체 생성
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			
//			// 4. SQL실행
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				//로그인 성공: 자바에서 Session 생성해서 넘긴다
//				HttpSession session = request.getSession(); // request에 이미 만들어져 있는 객체를 세션에 넘겨 받는다
//				session.setAttribute("user_id", id); // 세션 객체 "user_id"에 id값을 저장
//				//로그인 성공시 페이지로 이동
//				response.sendRedirect("mypage.jsp"); // forward로 전달할만한 내용을 이미 세션에다가 넣어뒀기 때문에 사용필요 x
//			}else {
//				//로그인 실패: 아이디 혹은 비밀번호가 틀린 경우
//				response.sendRedirect("login_fail.jsp");
//			}
//			
//		} catch (ClassNotFoundException cnfe) {
//			System.out.println(cnfe.getMessage());
//		} catch (SQLException sqle) {
//			System.out.println(sqle.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close();
//			} catch (Exception e2) {
//				
//			}
//		}
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.login(id, pw);
		
		if(result == 1) {
			//로그인 성공: 자바에서 Session 생성해서 넘긴다
			HttpSession session = request.getSession(); // request에 이미 만들어져 있는 객체를 세션에 넘겨 받는다
			session.setAttribute("user_id", id); // 세션 객체 "user_id"에 id값을 저장
			//로그인 성공시 페이지로 이동
			response.sendRedirect("auth/mypage.jsp"); // forward로 전달할만한 내용을 이미 세션에다가 넣어뒀기 때문에 사용필요 x
		}else {
			//로그인 실패: 아이디 혹은 비밀번호가 틀린 경우
			response.sendRedirect("login_fail.jsp");
		}
		
	}
}
