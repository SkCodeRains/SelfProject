<%@page import="java.io.File"%>
<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="fileup" method="post">
	<input type="file" name="photo" id="file">
	<input type="submit">  </form>
</body>
</html>