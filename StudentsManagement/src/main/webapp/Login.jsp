<%@page import="com.rains.security.Validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' id="LOGIN" type='text/css' media='screen'
	href='CSS/login.css'>
</head>

<body>

	<div class="container">
		<div class="subContainer">
			<div class="leftpanel">
				<div class="icon">
					<img src="images/1682610.png" alt="">
				</div>
			</div>
			<div class="rightpanel">
				<div class="LoginContainer">
					<h1 id="heading">
						<span id="headingspan"> User Login </span>
					</h1>

					<form id="form" action="Login" method="post">
						<div class="username inp">
							<div class="imgdiv">
								<img src="images/Male_black.png" alt="">
							</div>
							<input type="text" name="userID" id="" placeholder="Email or Mobile Number"
								required="required">
						</div>

						<div class="Email inp">

							<div class="imgdiv">
								<img src="images/bd6c75c4357319a19162153e2710c700.png" alt="">
							</div>
							<input placeholder="Password" type="password" name="password"
								id="" required="required">
						</div>
						<div class="button inp">
							<input type="submit"> <a><input type="reset"
								value="Cancel"></a>
						</div>
					</form>

					<h3 id="links">
						<span> <a href="">Forgot</a> <a href="SignUp.jsp">New
								User</a>
						</span>
					</h3>
					<span class=""></span>

				</div>

			</div>
		</div>

	</div>
	<script src="JS/Login.js"></script>	
</body>

</html>