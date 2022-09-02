package com.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	/*
	 * DAO는 단수 DB연동을 담당하는 클래스
	 * 여러개 생성하도록 일반 클래스로 만들면, 메모리 과부하가 올 수 있다.
	 * 그렇기 때문에 싱글톤 패턴을 적용하여 객체를 하나로  제한한다.
	 */
	
	// 1. 스스로의 객체를 멤버 변수로 선언하고, 한개로 제한한다.
	private static MemberDAO instance = new MemberDAO();
	
	// 2. 외부에서 객체를 생성 할 수 없도록 생성자에 pivate처리
	private MemberDAO() {
		// 생성자가 한번 동작할 때에 다음의 내용이 동작 할 수 있도록 처리한다.
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			System.out.println("드라이버 호출 에러 발생");
			System.out.println(e.getMessage());
		}
	}
	
	// 3. 외부에서 객체를 요구할 경우, getter메서드만 써서 반환
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//======================================== 윗 단계 까지가 싱글톤 처리 =====================================
	
	// DB연동을 위한 변수와 객체를 선언
	private String url = "jdbc:oracle:thin:@192.168.100.105:1521/XEPDB1";
	private String user = "myjsp";
	private String password = "myjsp";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// ======================================= 중복 되는 코드를 멤버 변수로 선언 =================================
	
	// 기능을 메서드로 선언
	
	// 회원가입 메서드
	public int join(MemberVO vo) {
		int result = 0;
		
		String sql = "insert into members values(?,?,?,?,?,?)";
		
		try {
			//connection
			conn = DriverManager.getConnection(url, user, password);
			
			// PreparedStatement
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getGender());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {	
			}
		}
		return result;
	}
	
	// 로그인 메서드
	public int login(String id, String pw) {
		// 결과값을 0과 1로 받을 예정
		int result = 0;
		
		// sql
		String sql = "select * from members where id = ? and pw = ?";
		
		// DB
		try {
			// Connection
			conn = DriverManager.getConnection(url, user, password);
			
			//  PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// ResultSet
			rs = pstmt.executeQuery();
			
			if(rs.next()) return result = 1; // 로그인 성공 
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	// id를 이용해 DB에서 회원 정보를 불러오는 메서드
	public MemberVO getInfo(String id) {
		
		MemberVO vo = new MemberVO();
		
		//sql
		String sql = "select * from members where id = ?";
		
		// DB작업
		try {
			//Connector
			conn = DriverManager.getConnection(url, user, password);
			//PreparedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//ResultSet
			rs = pstmt.executeQuery();
			if(rs.next()) {
//				String name = rs.getString("name");
//				String pw = rs.getString("pw");
//				String phone1 = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String gender = rs.getString("gender");
//				vo = new MemberVO(id, pw, name, phone1, phone2, gender);
				
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setGender(rs.getString("gender"));
				
			}else {
				System.out.println("뭔가.. 잘못됐어");
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
			}
		}
		return vo;	
	}
	// 회원 정보 update메서드
	public int update(MemberVO vo) {
		int result = 0;
		
		String sql = "update members set pw=?, name=?, phone1=?, phone2=?, gender=? where id=?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone1());
			pstmt.setString(4, vo.getPhone2());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	// 회원 정보 삭제 메서드 
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from members where id=?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	public int Duplicate(String id) {
		int result = 1;
		// select했을때 1이상의 값을 돌려 받으면 중복
		
		String sql = "select * from members where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
}
