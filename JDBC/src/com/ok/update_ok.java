package com.ok;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_ok")
public class update_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public update_ok() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form데이터 처리
		// 전달 받은 데이터를 통해서 update를 진행하는 코드를 작성하세요.
		// 성공시: update_success.jsp => 회원정보가 수정되었습니다. 링크로 mypage이동
		// 실패시: mypage.jsp 
		// update sql : update members set pw=?, name=?, phone1=?, phone2=?, gender=?
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String gender = request.getParameter("gender");
		
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
//			String sql = "update members set pw=?, name=?, phone1=?, phone2=?, gender=? where id=?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, pw);
//			pstmt.setString(2, name);
//			pstmt.setString(3, phone1);
//			pstmt.setString(4, phone2);
//			pstmt.setString(5, gender);
//			pstmt.setString(6, id);
//			
//			int result = pstmt.executeUpdate();
//			
//			if(result==1) {
//				System.out.println("대성공");
//				response.sendRedirect("update_success.jsp");
//			}else {
//				System.out.println("대실패");
//				System.out.println("1개만 바뀌어야 한다고!");
//				System.out.println("바뀐 갯수:"+result);
//				response.sendRedirect("mypage.jsp");
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//			} catch (Exception e2) {
//
//			}
//		}
		
		/*
		 * 1. form데이터 값을 vo에 저장
		 * 2. dao객체를 생성하고 update메서드를 불러와, vo객체를 전달
		 * 3. update메서드 안에서는 executeUpdate()메서드를 실행하고
		 * 4-1. 1을 반환하면 update_success.jsp로
		 * 4-2. 0을 반환하면 mypage.jsp
		 */
		MemberVO vo = new MemberVO(id, pw, name, phone1, phone2, gender);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.update(vo);
		
		if(result == 1) {
			response.sendRedirect("update_success.jsp");
		}else {
			response.sendRedirect("auth/mypage.jsp");
		}

	}

}
