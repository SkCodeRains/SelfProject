<%@page import="javax.swing.JOptionPane"%>
<%@page import="servletes.Dispatcher"%>
<%@page import="beans.validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDo Task</title>
</head>
<link rel="icon"
	href="https://is4-ssl.mzstatic.com/image/thumb/Purple128/v4/09/72/fc/0972fc92-1506-564e-0ce1-aece0152d3ba/source/100x100bb.png"
	type="image/x-icon">
<Script src="../JS/Main.js"></Script>
<script src="../../../../ToDolist/JS/Ajax.js"></script>
<link rel="stylesheet" href="../CSS/Main.CSS">
<link rel="stylesheet" href="../CSS/TextArea.css">
<link rel="stylesheet" href="../CSS/Head.css">
<body onload="runAble()">
	<div class="body">
		<%
		if (validation.validate(request)) {
		%><div class="topnav" draggable="false">
			<a draggable="false" class="active" href="../Dispatcher">Home</a>
			<a draggable="false" href="#contact">Contact</a>
			<a draggable="false" href="#about">About</a>
			<a draggable="false" href="../logout" id="logs">Logout</a>
		</div>
		<div id="todo">
			<jsp:include page="ToDoLoader.jsp"></jsp:include>
		</div>
		<%
		} else {
		response.sendRedirect("../Dispatcher");
		}
		%>
	</div>
</body>
</html>