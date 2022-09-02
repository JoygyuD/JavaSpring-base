<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Encodig Filter 테스트</title>
	</head>
	<body>
		<form action="/JDBC/enco" method="post">
			아이디: <input type="text" name="id"><br>
			비밀번호: <input type="password" name="pw"><br>
			이름: <input type="text"	name="name"><br><br>
			주소: <br><textarea name="address" rows="3" cols="30">
			</textarea><br>
			<input type="submit" name="저장">
		</form>
	</body>
</html>