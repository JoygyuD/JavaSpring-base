<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//세션을 이용하여 인증되지 않은 사용자들은 login페이지로 redirect
	//if(session.getAttribute("user_id") == null){
	//	response.sendRedirect("login.jsp");
	//}

	// session user_id에 있는 정보를 추출해서 my에 정보 출력
	String id = (String)session.getAttribute("user_id");
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mypage</title>
	</head>
	<body>
		<h2><%=id %>님 환영합니다.</h2>
		
		<a href="../logout.jsp">로그 아웃</a>
		<a href="../modify_ok">정보 수정</a>
		<a href="../delete_ok">회원 탈퇴</a>
	</body>
</html>