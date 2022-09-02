package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String uid = "myjsp";
		String upw = "myjsp";
		
		// 객체
		Connection conn = null;
		Statement stmt = null; // SQL을 실행하기 위한 객체
		ResultSet re = null; // SQl 실행 결과를 저장하고 있는 객체
		
		// connection 연결을 확인하기 위한 변수
		boolean connect = false;
		
		try {
			// 1. 드라이버 로딩: Class.forName()
			Class.forName(driver);
			
			// 2. DB연결 - connection 객체 생성
			conn = DriverManager.getConnection(url, uid, upw);
			
			// 3. 
			
			
			connect = true; 
		} catch (ClassNotFoundException cnfe) {
			connect = false;
			System.out.println("DB드라이버 로딩 실패 \n"+cnfe.getMessage());
		} catch (SQLException sqle) {
			connect = false;
			System.out.println("DB접속 실패 \n" + sqle.getMessage());
		} catch (Exception e) {
			connect = false;
			System.out.println("Unknown Error: " + e.getMessage());
		}finally {
			
		}
		
		if(connect) {
			System.out.println("연결 성공");
		}else {
			System.out.println("연결 실패");
		}
	}
}
