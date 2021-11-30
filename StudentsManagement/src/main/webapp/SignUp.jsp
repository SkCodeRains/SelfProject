<%@page import="com.rains.security.Validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen' href='CSS/SignUp.css'>
<link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css">
<link rel="stylesheet" href="CSS/body.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.2/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet" />
</head>

<body>

	<div class="container">
		<div class="subContainer">

			<div class="leftpanel">
				<div class="icon">
					<img id="imgMain" src="images/1682610.png" alt="">
				</div>
			</div>
			<div class="rightpanel">
				<div class="LoginContainer w-100">
					<h1 id="heading " class="text-center text-primary text-uppercase">
						<span id="headingspan"> Registration </span>
					</h1>

					<form id="form" action="Register" method="post" class="form-control-plaintext d-flex flex-column" enctype="multipart/form-data">
						<div class="names w-100 d-flex flex-row  ">
							<input type="text" name="fname" placeholder="First Name"
								class="d-inline-block   border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
							<input type="text" name="mname" placeholder="Middle Name"
								class="d-inline-block  border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
							<input type="text" name="lname" placeholder="Last Name"
								class="d-inline-block  border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
						</div>

						<div class="numbers mt-3 w-100">
							<input type="number" name="phone" placeholder="Mobile Number"
								class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary " min="1000000000"
								max="9999999999" required>
						</div>

						<div class="emails mt-3 w-100">
							<input type="email" name="email" placeholder="Email"
								class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
						</div>

						<div class="passwords mt-3 w-100">
							<input type="password" name="password" placeholder="password"
								class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
						</div>


						<span class="mt-3 ">Select Gender</span>
						<div class="genders d-flex mt-2 justify-content-between w-50">
							<div class="d-flex">
								<input type="radio" id="Male" name="gender" class="" value="Male">

								<label for="Male">Male</label>
								<br>
							</div>

							<div class="d-flex">
								<input type="radio" id="Female" name="gender" value="Female">
								<label for="Female">Female</label>
								<br>
							</div>

							<div class="d-flex">

								<input type="radio" id="Others" name="gender" value="Others">

								<label for="Others">Others</label>
							</div>
						</div>



						<div class="Photos mt-3 w-100">
							<input type="file" name="photo" placeholder="Upload Photo"
								class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary " required>
						</div>

						<div class="dob mt-3 w-100">
							<input type="date" id="dob" name="dob" placeholder="Select DOB"
								class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary " min="1990-01-01"
								max="2010-12-31" value="1997-06-05" required>
						</div>



						<div class="passwords mt-3 w-100">
							<span>Select Your Class</span>
							<select name="class" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required="required">
								<option value="1">1st</option>
								<option value="2">2nd</option>
								<option value="3">3rd</option>
								<option value="4">4th</option>
								<option value="5">5th</option>
								<option value="6">6th</option>
								<option value="7">7th</option>
								<option value="8">8th</option>
								<option value="9">9th</option>
								<option value="10">10th</option>
								<option value="11">11th</option>
								<option value="12">12th</option>
							</select>
						</div>



						<div class="btns d-flex w-100 flex-wrap justify-content-center  ">
							<input type="submit"
								class="btn  mt-3 border-left-0 border-right-0 border-top-0  border border-bottom  text-center border-success mr-3 center btn-outline-success ">
							<input type="reset"
								class="btn  mt-3  border-left-0 border-right-0 border-top-0  border border-bottom  border-danger text-center center btn-outline-danger">
						</div>



					</form>

					<h3 id="links">
						<span> </span>
					</h3>
					<span class=""></span>

				</div>

			</div>
		</div>

	</div>
	<script>
		function SetPath(obj) {
			document
		}
	</script>
</body>

</html>