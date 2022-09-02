<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멤버 페이지</title>
	</head>
	<body>
		<h1>로그인시에만 보여지는 페이지</h1>
		현재 로그인 하신 아이디는 <%=session.getAttribute("user_id") %>입니다.
	</body>
</html>