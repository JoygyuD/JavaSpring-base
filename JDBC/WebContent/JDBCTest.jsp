<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JDBCTest</title>
	</head>
	<body>
		<%
			// driver, url, uid, upw
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
			String uid = "myjsp";
			String upw = "myjsp";
			
			// 객체: Connection, Statement, ResultSet
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			boolean connect = false;
			
			try{
				// 1. 드라이버 로딩
				Class.forName(driver);
				
				// 2. DB연결
				conn = DriverManager.getConnection(url, uid, upw);
				
				connect = true;
				
				// 3. 
				
			}catch(ClassNotFoundException cnfe){
				connect = false;
				System.out.println("DB드라이버 로딩 실패" + cnfe.getMessage());
			}catch(SQLException sqle){
				connect = false;
				System.out.println("DB접속 실패: " + sqle.getMessage());
			}catch(Exception e){
				connect = false;
				System.out.println("Unknown Error: " + e.getMessage());
			}
			
			if(connect){%>
				<h3>JDBC연결 성공</h3>	
			<%}else{%>
				<h3>JDBC연결 실패</h3>
			<%}%>
			
	</body>
</html>