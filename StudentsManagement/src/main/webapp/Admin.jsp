<%@page import="com.rains.beans.getNotifications"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>ADMIN PANEL</title>
<link rel="stylesheet" href="CSS/head.css">
<link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css">
<link rel="stylesheet" href="CSS/body.css">

</head>

<body class="bg-transparent">
	<div class="headm p-0">
		<div class="topnav left-panel fl" style="position: static;">

			<a href="#contact">Contact</a> <a href="#about">About</a> <a
				href="Logout" id="">Logout</a>
		</div>
		<div class="topnav right-panel p-0">
			<a type="button" class="btn "> Profile <span
				class="badge badge-light"> <%=getNotifications.getTotal(request)%></span>
				<span class="sr-only"></span>
			</a> <a href="javascript:LoadsData('AdminFronPanel');">Home</a> <a
				href="javascript:LoadsData('Accepted');">Accepted</a> <a
				href="javascript:LoadsData('Rejected')">Rejected</a>

		</div>
	</div>

	<div id="container"
		class="vh-80  w-100 d-flex justify-content-center align-items-center">
		<jsp:include page="AdminFronPanel.jsp"></jsp:include>
	</div>


	<script src="JS/admin.js"></script>
</body>