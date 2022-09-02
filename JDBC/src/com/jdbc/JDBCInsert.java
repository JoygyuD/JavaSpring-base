package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("id>>");
		String id = scan.next();
		System.out.print("pw>>");
		String pw = scan.next();
		System.out.print("name>>");
		String name = scan.next();
		System.out.print("email>>");
		String email = scan.next();
		
		// DB연결을 위한 변수
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		// 객체 생성
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		//SQL 구문
		String sql = "insert into members values('"+id+"','"+pw+"','"+name+"','"+email+"')";
		try {
			// 1. jdbc드라이버로드
			Class.forName(driver);
			// 2. Connection
			conn = DriverManager.getConnection(url, user, password);
			// 3. sql전달 객체 Statement
			stmt = conn.createStatement();
			// 4. 실행
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException cnfe) {
			
			System.out.println("Driver로드 실패");
			System.out.println(cnfe.getMessage());
		} catch (SQLException sqle) {
			
			System.out.println("DB연결 및 SQL오류");
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {
				// 5. 객체 종료
				if(conn != null)conn.close();
				if(stmt != null)stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(result==1) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		
		

	}
}
