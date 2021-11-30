
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="beans.validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login TODO</title>
<link rel="stylesheet" href="CSS/login.css">
<script src="JS/Login.js"></script>
<script src="JS/Signup.js"></script>
<link rel="stylesheet" href="CSS/Body.css">
<link rel="stylesheet" href="CSS/Head.css">
<link rel="icon"
	href="https://is4-ssl.mzstatic.com/image/thumb/Purple128/v4/09/72/fc/0972fc92-1506-564e-0ce1-aece0152d3ba/source/100x100bb.png"
	type="image/x-icon">
</head>
<body>
<body>
	<%
	if (validation.validate(request)) {
		response.sendRedirect("TasksManagement/index.jsp");
	} else {
	%>
	<div class="topnav">
		<a class="active" href="Dispatcher">Home</a>
		<a href="#contact">Contact</a>
		<a href="#about">About</a>
		<a href="logout" id="logs">Logout</a>
	</div>

	<div id="loginSignUp">
		<form id="loginform" name="formsign" action="Login" method="post"
			autocomplete="off">
			<h1>Login Form</h1>
			<div class="FormDiv">

				<div class="inputs">
					<label>User Name</label>
					<input type="text" required="required" name="username"
						placeholder="Username">
				</div>

				<div class="inputs">

					<label>password</label>
					<input type="password" required="required" name="password"
						placeholder="password">

				</div>
				<div class="inputs">

					<button type="submit">Login</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var logs = document.getElementById("logs");
		logs.id = "SignUp";
		logs.innerHTML = "SignUp";
		logs.href = "javascript:signupLoad()";
	</script>
	<%
	}
	%>
</body>
</html>