package com.ok;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete_ok() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * delete from 테이블명 where id = ?
		 * 
		 * 1. 아이디는 세션을 통해서 얻는다.
		 * 2. pstmt를 이용하여 삭제를 진행
		 * 3. executeUpdate()메서드를 통해서 sql을 실행하고,
		 * 	1을 반환하면 세션 전부다 삭제 후 login.jsp로 이동
		 * 	0을 반환하면 mypage.jsp로 이동
		 */
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
//		String user = "myjsp";
//		String password = "myjsp";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			Class.forName(driver);
//			
//			conn = DriverManager.getConnection(url, user, password);
//			
//			String sql = "delete from members where id = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, id);
//			
//			int result = pstmt.executeUpdate();
//			
//			if(result ==1) {
//				System.out.println("대성공");
//				session.invalidate();
//				response.sendRedirect("login.jsp");
//			} else {
//				System.out.println("대실패");
//				response.sendRedirect("mypage.jsp");
//			}
//			
//		} catch (ClassNotFoundException cnfe) {
//			System.out.println(cnfe.toString());
//		} catch (SQLException sqle) {
//			System.out.println(sqle.toString());
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//			} catch (Exception e2) {
//			}
//		}
		
		/*
		 * 1. ID는 session을 통해서 얻는다. DAO에 delete(id) 메서드를 생성
		 * 2. executeUpdate() 메서드를 사용
		 * 3-1. 성공시 1을 반환 받고 세션을 삭제 후 login.jsp로 이동
		 * 3-2. 실패시 1을 제외한 숫자를 반환 받고 mypage.jsp로 이동
		 */
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.delete(id);
		
		if(result == 1) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("mypage.jsp");
		}

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
