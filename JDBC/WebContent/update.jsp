<%@page import="com.ok.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// id는 session을 통해서 얻는다
	//String id = (String)session.getAttribute("user_id");

	// 회원정보는 request를 통해서 얻는다
	//String pw = (String)request.getAttribute("user_pw");
	//String name = (String)request.getAttribute("user_name");
	//String phone1 = (String)request.getAttribute("user_phone1");
	//String phone2 = (String)request.getAttribute("user_phone2");
	//String gender = (String)request.getAttribute("user_gender");
	
	MemberVO vo = (MemberVO)request.getAttribute("vo");
	
	String id = vo.getId();
	String pw = vo.getPw();
	String name = vo.getName();
	String phone1 = vo.getPhone1();
	String phone2 = vo.getPhone2();
	String gender = vo.getGender();
	
%>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정(update.jsp)</title>
	</head>
	<body>
	<!-- 
		radio, checkbox등을 미리 선택하게 하는 기능은 checked 값을 사용
		radio버튼이나 checkbox를 선택할 수 없게 막는 기능 disabled(해당값을 사용x)를 사용
		select는 미리 선택하는 속성값으로 옵션에 selected를 사용
		input에 읽기만 허용하는 속성으로 readonly(읽기만 가능하고 수정은 불가능)
	 -->
		<h2>정보 수정 페이지 </h2>
		<form action="update_ok" method="post">
			<table>
				<tr>
					<td>ID</td> 
					<td colspan="3"><input type="text" name="id" size="20" value="<%=id%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>PW:</td>
					<td> <input type="password" name="pw" size="20" value="<%=pw%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td> <input type="text" name="name" size="20" value="<%=name%>"></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td>
						<select name="phone1">
						<option <%= phone1.equals("010") ? "selected" : "" %>>010</option>
						<option <%= phone1.equals("011") ? "selected" : "" %>>011</option>
						<option <%= phone1.equals("018") ? "selected" : "" %>>018</option>
						</select>-<input type="text" name="phone2" value="<%=phone2%>"><br>
					</td>
				</tr>
				<tr>
					<td>성별:</td> 
					<td>
						<%if(gender==null || gender.equals("m")){ %>
						<input type="radio" name="gender" value="m" checked>남자
						<input type="radio" name="gender" value="f">여자
						<%} else{%>
						<input type="radio" name="gender" value="m" >남자
						<input type="radio" name="gender" value="f"checked>여자
						<%} %>
					</td>
				<tr>						
					<td colspan="4">
					<input type="submit" value="수정">
					<a href="auth/mypage.jsp">취소</a>
					</td>
				</tr>
				
			</table> 
			
		</form>
	</body>
</html>