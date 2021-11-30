<%@page import="java.util.Base64"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.*"%>
<%@page import="beans.mySQL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (request.getParameter("id"));

	Blob file = null;
	byte[] fileData = null;

	try {
		Connection conn = mySQL.getConnection();

		String sqlString = "SELECT * FROM files";
		Statement myStatement = conn.createStatement();

		ResultSet rs = myStatement.executeQuery(sqlString);

		while (rs.next()) {
			byte[] imgData = rs.getBytes("image");
			String encode = Base64.getEncoder().encodeToString(imgData);
	%>
	<div>
		<a alt="sksks" href="data:video/mp4;base64,<%=encode%>">file link </a>
	</div>


	<%
		}

	} catch (Exception ex) {
	JOptionPane.showMessageDialog(null, ex);
	}
	%>

	<br>
	<br>
	<a href="main_page.jsp">Go to Main Page...</a>

	<div style="position: relative">
		<div style="position: fixed; bottom: 0; width: 100%; text-align: center">
			<p>
				<a href="https://www.youtube.com/user/TechWorld3g?sub_confirmation=1">CLICK HERE TO SUBSCRIBE</a>
			</p>
		</div>
	</div>
</body>
</html>