package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 id>>");
		String id = scan.next();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "delete from members where id='"+id+"'";
		
		int result = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println(id+"가 삭제되었습니다.");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
		}
	}

}
