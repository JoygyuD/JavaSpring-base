package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {

	public static void main(String[] args) {
		/*
		 * try ~ catch 구문을 사용
		 * select SQL구문을 사용하여 members 테이블의 모든 레코드를 출력(console)
		 * (JDBCInsert 클래스를 통해서 5개의 레코드를 추가 후에 작업)
		 */
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from members";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				System.out.println("==========================");
				System.out.println("ID:"+id);
				System.out.println("PW:"+pw);
				System.out.println("name:"+name);
				System.out.println("email:"+email);
			}
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB로드 실패");
			System.out.println(cnfe.getMessage());
			
		} catch (SQLException sqle) {
			System.out.println("DB연결 및 sql문 오류");
			System.out.println(sqle.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
