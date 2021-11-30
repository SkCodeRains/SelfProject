<%@page import="myservlets.demos"%>
<%@page import="myservlets.Mysql"%>
<%@page import="test.demo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/loading.css" rel="stylesheet">
</head>
<body>

	<script type="text/javascript">
		function showPage() {
			var element = document.getElementById("load");
			element.classList.add("loader");
		}
	</script>
	<button onclick="showPage()">Load</button>

			<div id="loader" class="loader"></div>
		


</body>
</html>
