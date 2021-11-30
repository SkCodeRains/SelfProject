<%@page import="com.rains.security.Validation"%>
<%@page import="java.util.Base64"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rains.db.Oracledb"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet" href="CSS/head.css">
<link rel="stylesheet" href="CSS/body.css">
<link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css">
<script src="JS/tableDateStudents.js"></script>
</head>

<body class="bg-transparent">


	<div class="headm p-0">
		<div class="topnav left-panel" style="position: static;">

			<a href="#contact">Contact</a> <a href="#about">About</a> <a
				href="Logout" id="">Logout</a>
		</div>
		<div class="topnav right-panel p-0"></div>
	</div>



	<div id="editpanel"
		class="vh-70 w-100 d-none  bg-transparent  justify-content-center align-items-center">
		<div
			class="w-75  details h-25 bg-white   d-flex flex-wrap justify-content-center align-items-center">
			<label class="font-weight-bold font-italic" for="eidtsection"
				id="label"></label> <input autocomplete="off"
				class="mr-3 w-75   removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom border-primary "
				type="text" name="" id="eidtsection" value="">
			<button class="btn btn-success w-50" onclick="UpdateIt()">Update</button>
			<button class="btn btn-danger w-25" onclick="canceled()">Cancel</button>
		</div>
	</div>
	<%
	String status = Validation.getStatus(request);
	if (status.equals("PENDING")) {
	%>
	<jsp:include page="tableDataStudents2.jsp"></jsp:include>
	<%
	} else {
	if (status.equals("ACCEPTED")) {
	%>
	<jsp:include page="tableDataStudents2.jsp"></jsp:include>
	<%
	} else {
	%>
	<h1>Sorry your application is Rejected ..!!!!!</h1>
	<script>
	setInterval(() => {
		window.location.href = "Logout"
	}, 3000);
	</script>
	<%
	}
	}
	%>


	<div id="msg" class="w-100 h-25 bg-primary">
		<div>
			<h1 id="msgP"></h1>
		</div>
	</div>
	<script src="bootstrap-4.3.1-dist/js/bootstrap.js"></script>
</body>

</html>