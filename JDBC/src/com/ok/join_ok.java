package com.ok;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join_ok")
public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public join_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form으로 들어온 값을 처리(post)
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String gender = request.getParameter("gender");
		
//		//DB 연동에 필요한 변수 선언
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
//		String user = "myjsp";
//		String password = "myjsp";
//	
//		//DB에 회원가입을 위한 객체 생성
//		Connection conn = null;
////		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		
//		//DB에 전달할 sql문 작성
////		String sql = "insert into members values('"+id+"','"+pw+"','"+name+"','"+phone1+"','"+phone2+"','"+gender+"')";
////		String sql = "insert into members (id, pw, name, phone1, phone2, gender) values(?,?,?,?,?,?)";
//		String sql = "insert into members values(?,?,?,?,?,?)"; // 다 넣었기 때문에 이래도 상관 x
//		//DB작업
//		try {
//			//1.드라이버로드
//			Class.forName(driver);
//			
//			//2.Connection객체
//			conn = DriverManager.getConnection(url, user, password);
//			
//			//3.Statement객체 
////			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement(sql); // sql문을 바로 넣어준다.
//			
//			//4-1.sql을 stmt에 넣어서 실행
////			int result = stmt.executeUpdate(sql);
//			
//			//4-2.sql을 pstmt에 넣어서 실행
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			pstmt.setString(3, name);
//			pstmt.setString(4, phone1);
//			pstmt.setString(5, phone2);
//			pstmt.setString(6, gender);
//			
//			int result = pstmt.executeUpdate();
//			
//			if(result == 1) {
//				// DB에 데이터 입력 성공 - 회원가입 성공
//				response.sendRedirect("join_success.jsp");
//				System.out.println("성공");
//			}else {
//				// DB에 데이터 입력 실패 - 회원가입 실패
//				response.sendRedirect("join_fail.jsp");
//				System.out.println("실패");
//			}
//			
//		} catch (ClassNotFoundException cnfe) {
//			System.out.println(cnfe.getMessage());
//		} catch (SQLException sqle) {
//			System.out.println(sqle.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
////				if(stmt != null) stmt.close();
//				if(pstmt != null) pstmt.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
		// DAO객체 생성
		MemberDAO dao = MemberDAO.getInstance(); // 싱글톤 방식으로 만들어져있던 객체를 넣어준다.
		
		// VO객체 생성
		MemberVO vo = new MemberVO(id, pw, name, phone1, phone2, gender);
		int result = 0;
		
		if(dao.Duplicate(id) == 0) {
			result = dao.join(vo);
		}else {
			System.out.println("중복");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('ID 중복입니다.'); location.href='join.jsp';</script>"); 
			writer.close();
		}
		
		if(result == 1) {
			// DB에 데이터 입력 성공 - 회원가입 성공
			response.sendRedirect("join_success.jsp");
			System.out.println("대성공");
		}else {
			// DB에 데이터 입력 실패 - 회원가입 실패
			response.sendRedirect("join_fail.jsp");
			System.out.println("대실패");
		}
		
	}

}
