<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<h1>注册</h1>
	<form action="user" method="post">
		<input type="hidden" name="option" value="register">
		用户名:<input name="userName" type="text"><br>
		密码:<input name="userPwd" type="password"><br>
		电话:<input name="phone" type="text"><br>
		<input type="submit" value="register">
	</form>

</body>
</html>