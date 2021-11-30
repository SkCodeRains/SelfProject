<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sk Banking</title>
<link href="css/main.css" rel="stylesheet">
<link href="css/Bg.css" rel="stylesheet">
<link href="../css/loading.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<script type="text/javascript">
		function showPage() {
			var element = document.getElementById("load");
			element.classList.add("loader");
			setTimeout(function() {
				element.classList.remove("loader");
			}, 5000);
		}
	</script>
	<%
		String ID = String.valueOf(session.getAttribute("ID"));
	if (ID.equalsIgnoreCase("manager")) {
		response.sendRedirect("Manager/Manager.jsp");
	} else if (ID.equalsIgnoreCase("Cashier")) {
		response.sendRedirect("Cashier/Cashier.jsp");
	} else if (ID.equalsIgnoreCase("Customer")) {
		response.sendRedirect("Customer/Customer.jsp");
	} else {
	%>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="images/equity-release.png"><br>
	</div>
	<div class="upperbar" align="center"></div>
	<form name="Loginfrm" method="post" action="Check">
		<div class="inputs" align="center">
			<h1 style="color: white;">Login Here</h1>
			<input type="text" required="required" name="ID"
				placeholder="Account Number">
			<input type="password" required="required" name="pswd" class="pss"
				id="myInput" placeholder="Password">
			<input type="submit" onclick="showPage()">
		</div>
		<div id="load" class="loaders"></div>
	</form>
	<%
		}
	%>
	<jsp:include page="footer.html" />
</body>
</html>