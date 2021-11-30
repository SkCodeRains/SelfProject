<%@page import="Servlets.test"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Mr.<%=session.getAttribute("Name")%></title>
<link href="css/Bg.css" rel="stylesheet">
<link href="css/testing.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-transparent text-white">
	<div>
		<p style="font-color: red; opacity: 0.9">goooooood;</p>
		<form method="post" action="newacc">
			<input type="submit">
		</form>
	</div>
</body>
</html>