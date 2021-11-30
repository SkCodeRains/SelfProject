<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="beans.mySQL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<table class="table text-white">
	<tr class="thead-dark">
		<th>ID</th>
		<th>Holder Name</th>
		<th>Account Type</th>
		<th>Account Balance</th>
	</tr>
	<%
		String type = request.getParameter("type");
	try {
		Connection Cn = mySQL.getConnection();
		PreparedStatement Pt = Cn.prepareStatement("select * from accounts Where acctype=?");
		Pt.setString(1, type);
		ResultSet Rt = Pt.executeQuery();
		while (Rt.next()) {
	%>

	<tr>
		<td><%=Rt.getString(1)%></td>
		<td><%=Rt.getString(2)%></td>
		<td><%=Rt.getString(3)%></td>
		<td><%=Rt.getString(4)%></td>
	</tr>


	<%
		}
	} catch (Exception e) {

	}
	%>

</table>

</body>
</html>