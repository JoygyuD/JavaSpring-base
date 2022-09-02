<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 로그아웃 처리는 세션을 삭제
	if(session.getAttribute("user_id") == null){
		response.sendRedirect("login.jsp");	
	}else{
		session.invalidate();
		response.sendRedirect("login.jsp");	
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>logout</title>
	</head>
	<body>
		
	</body>
</html>