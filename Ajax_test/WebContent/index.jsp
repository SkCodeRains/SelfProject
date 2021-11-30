<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<div class="mainClass">
		<jsp:include page="header.html"></jsp:include>
		<!-- Page Content -->
		<div class="container mainBlack">
			<h1 class="font-weight-light">WELCOME TO SK WORLD</h1>


			<div class="listBut">
				<div class="btn-group" id="drptest">
					<button role="button" type="button" class="btn" data-toggle="dropdown">Ajax select Operation</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="javascript:selector('ajax-html/ourFirstAjax.html')">Our First Ajax Example</a>
						<a class="dropdown-item" href="javascript:selector('ajax-html/DropDownType.html')">Drop down type all view</a>
						<a class="dropdown-item" href="javascript:selector('ajax-html/DropDownlistdetails.html')">dropdown select
							single view</a>
						<a class="dropdown-item" href="javascript:selector('ajax-html/servletCalling.html')">servelet calling</a>
						<a class="dropdown-item" href="javascript:selector('ajax-html/registration.html')">New Registration</a>
					</div>
				</div>


				<div class="btn-group">
					<button role="button" type="button" class="btn" data-toggle="dropdown">Ajax EJBs Practice</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="javascript:EjbSelector('Ejbs-Html/ourFirstAjax-EJB.html')">Get Accounts</a>




					</div>
				</div>



			</div>
		</div>
	</div>



	<div id="second"></div>


</body>
</html>