<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인(login.jsp)</title>
	</head>
	<body>
		<h2>로그인 연습(login.jsp)</h2>
		<form action="login_ok" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td colspan="2"><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td colspan="3">
					<input type="submit" value="로그인">
					<a href="join.jsp">회원가입</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>