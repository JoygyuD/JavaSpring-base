package com.ok;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/modify_ok")
public class modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public modify_ok() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수정 페이지로 이동을 위해 DB정보를 가져오는 작업
		// DB에서 가져올 정보는 Session을 통해서 "ID"값을 얻는다.
		HttpSession session = request.getSession(); // 세션 객체
		
		String id = (String)session.getAttribute("user_id");
		
//		// DB연동을 위한 변수 선언
//		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String user = "myjsp";
//		String password = "myjsp";
//		
//		// DB연결을 위한 객체 생성
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "select * from members where id = ?";
//		
//		try {
//			// 1. driver로드
//			Class.forName(driver);
//			
//			// 2. 커넥션 연결
//			conn = DriverManager.getConnection(url, user, password);
//			
//			// 3. PreparedStatement 
//			pstmt = conn.prepareCall(sql);
//			pstmt.setString(1, id);
//			
//			// 4. SQL실행
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				String name = rs.getString("name");
//				String pw = rs.getString("pw");
//				String phone1 = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String gender = rs.getString("gender");
//				
//				//request에 강제 저장해서 forward로 넘긴다.
//				request.setAttribute("user_name", name);
//				request.setAttribute("user_pw", pw);
//				request.setAttribute("user_phone1", phone1);
//				request.setAttribute("user_phone2", phone2);
//				request.setAttribute("user_gender", gender);
//				
//				//forward 작업
//				RequestDispatcher dp = request.getRequestDispatcher("update.jsp");
//				
//				dp.forward(request, response);
//				
//			} else {
//				response.sendRedirect("login.jsp");
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
//			}
//		}
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = dao.getInfo(id);
		
		//request에 강제 저장 
		request.setAttribute("vo", vo);
		
		RequestDispatcher dp =  request.getRequestDispatcher("update.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
