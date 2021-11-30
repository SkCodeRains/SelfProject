<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<link href="css/Bg.css" rel='stylesheet' type='text/css'>
<link href="css/Login.css" rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="login">
		<div class="Heading">
			<h1>Login Page</h1>
		</div>
		<form action="Logsvalidate" method="post" name="Loginform">
			<input type="text" name="u" placeholder="Username" required="required" />
			<input type="password" name="p" placeholder="Password" required="required" />
			<button type="submit" value="Login" class="btn btn-primary btn-block btn-large">Login</button>
			<br>
			<h2>
				Signup
				<a href="#content1" style="color: green;">Here!</a>
			</h2>
		</form>

		<!-- popup Start-->
		<div id="content1" class="popup-effect">
			<div class="popup">
				<!--login form-->
				<div class="letter-w3ls">
					<form action="" method="post">
						<input type="text" name="name" placeholder="Username" required>

						<input type="text" name="name" placeholder="Phone" required>

						<input type="email" name="email" placeholder="Email" required>

						<input type="password" name="password" placeholder="Password" required>

						<input type="password" name="password" placeholder="Confirm Password" required>

						<button type="submit" class="btn btn-primary btn-block btn-large">Sign Up</button>
						<br>
					</form>
					<div class="clear"></div>
				</div>
				<a class="close" href="#">X</a>
			</div>
		</div>
		<!--//End-->
	</div>
</body>
</html>