<%@page import="Beans.mySQL"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="Catcher?links=ddsdsdsd">HEloo</a>
	<div>



		<%
			try {
			Connection Cn = mySQL.getConnection();
			PreparedStatement Pt = Cn.prepareStatement("Select * from Links");
			ResultSet rt = Pt.executeQuery();
			while (rt.next()) {
		%>
		<a href="<%=rt.getString(1)%>">DownlOads</a>
		<%
			}
		} catch (Exception e) {

		}
		%>
	</div>
	<div style="padding: 10%">
		<button href="">Clear</button>

	</div>



</body>
</html>