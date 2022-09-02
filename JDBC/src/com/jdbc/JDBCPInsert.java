package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCPInsert {

	// PreparedStatement 방식으로 처리
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("이메일: ");
		String email = scan.next();
		
		//DB연결을 위해 필요한 변수 
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		//DB작업
		
		try {
			//1. driver로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 커넥션 객체 생성(Connection)
			conn = DriverManager.getConnection(url, user, password);
			
			//3. SQL작성			
			String sql = "insert into testusers values(?,?,?,?)";
			
			//4. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// 객체에 저장된 sql작업 진행 "?"를 인자로 순서대로 처리
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			//5. SQL DB로 넘기기
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
			
		}
		
	}

}
