<form id="loginform" name="formsign" action="signUp" method="post"
	autocomplete="off">
	<h1>SignUp Form</h1>
	<div class="FormDiv">
		<input id="temp" hidden="true" required="required">
		<div class="inputs">
			<label>First Name</label>
			<input type="text" required="required" name="fisrtname"
				placeholder="first name">
		</div>
		<div class="inputs">
			<label>last name</label>
			<input type="text" required="required" name="lastname"
				placeholder="last name">
		</div>
		<div class="inputs">
			<label>middle name</label>
			<input type="text" required="required" name="middlename"
				placeholder="middle name">
		</div>
		<div class="inputs">
			<label>user name</label>
			<h4 id="error"></h4>
			<input type="text" id="username" required="required" name="username"
				placeholder="Set UserName">
		</div>



		<div class="inputs">
			<label>password</label>
			<input type="text" required="required" id="pass" name="password"
				placeholder="password">
		</div>
		<div class="inputs">
			<label>confirm password</label>
			<h4 id="passv"></h4>
			<input type="text" required="required" id="conf"
				name="confirmpassword" placeholder="confirmpassword">
		</div>
		<div class="inputs">
			<label>email</label>
			<input type="email" required="required" name="email"
				placeholder="Email">
		</div>
		<div class="inputs">
			<label>date of birth</label>
			<input type="date" required="required" name="DOB" placeholder="DOB">

		</div>


		<div class="inputs">
			<button type="submit" id="sub">Login</button>
		</div>
	</div>
</form>