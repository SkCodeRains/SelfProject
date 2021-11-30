<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>invalid credential</h1>
	<script>

        setTimeout(() => {
        	
        	window.location.href="<%=request.getContextPath()%>/Login.jsp"
        }, 3000);
    </script>
</body>
</html>