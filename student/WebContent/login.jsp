<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<h1>Login</h1>
	<form action="user" method="post" id="loginForm">
		<input name="option" value="login" type="hidden">
	    userName:<input name="uname" type="text"><br>
		password:<input name="pwd" type="password"><br>
		remember:<input name="remember" type="checkbox"><br>
		<input value="login" type="submit" onclick="checkLogin()">
		<input value="取消" type="reset"><br>
		<span ${msg }></span>
	</form>
	<a href="register.jsp">register</a>
</body>
</html>