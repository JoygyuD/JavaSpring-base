package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCQuiz01 {

	public static void main(String[] args) {
		/*
		 * 회원 ID를 Sanner를 통해서 입력 받아 해당 회원 정보만 출력
		 * members테이블에는 임의의 레코드 5개를 생성
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("ID입력: ");
		String id = scan.next();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String sql = "select * from members where id='"+id+"'";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("=========검색한 ID:" + rs.getString("name") + "님의 정보==========");
				System.out.println("ID: "+rs.getString("id"));
				System.out.println("PW: "+rs.getString("pw"));
				System.out.println("이름: "+rs.getString("name"));
				System.out.println("핸드폰: "+rs.getString("phone1"));
				System.out.println("집: "+rs.getString("phone2"));
				if(rs.getString("gender").equals("M")) {
					System.out.println("성별: 남자");
				}else if(rs.getString("gender").equals("W")) {
					System.out.println("성별: 여자");
				}
			}else {
				System.out.println("없는 아이디 입니다.");
			}
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
				if(conn != null)conn.close();
				if(stmt != null)stmt.close();
				if(rs != null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
