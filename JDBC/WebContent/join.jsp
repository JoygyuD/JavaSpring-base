<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입(join)</title>
	</head>
	<body>
		<!-- 회원 정보를 입력받아서 DB에 회원 정보에 대한 내용을 처리(servlet사용) -->
		<h2>회원가입</h2>
		<form action="join_ok" method="post">
			아이디: <input type="text" name="id" size="20"><br>
			비밀번호: <input type="password" name="pw" size="20"><br>
			이름: <input type="text" name="name" size="20"><br>
			전화번호: <select name="phone1">
				<option>010</option>
				<option>011</option>
				<option>018</option>
				</select>
				<input type="text" name="phone2"><br>
			성별: 
			<input type="radio" name="gender" value="m">남자
			<input type="radio" name="gender" value="f">여자<br>
			<input type="submit" value="회원가입">
			<a href="login.jsp">취소</a>
		</form>
	</body>
</html>