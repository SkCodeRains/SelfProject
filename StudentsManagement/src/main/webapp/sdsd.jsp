<%@page import="com.rains.security.Validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	Validation.register(request, response, "shaikh-mohammed", 60103, "STUDENT");

	Cookie c[] = request.getCookies();

	for (Cookie co : c) {
		System.out.println("get call");
		if (!co.getName().equals("JSESSIONID"))
			System.out.println(co.getName() + " : " + co.getValue() + " session : " + session.getAttribute(co.getName()));

	}
	%>


	<form action="test" method="post">
		<input type="date" id="dob" name="dob" placeholder="Select DOB"
			class="d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom border-primary "
			min="31-12-1990" max="31-12-2010" value="05-06-1997" required>
		<button onclick="myFunction()">Try it</button>
		<input type="submit">
	</form>





	<script>
		function myFunction() {
			var x = document.getElementById("dob");
			alert(x.value);
		}
	</script>
</body>
</html>