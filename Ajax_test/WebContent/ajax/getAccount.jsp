<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="beans.mySQL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<table class="table text-white table-hover">
	<tr>
		<th>ID</th>
		<th>Holder Name</th>
		<th>Account Type</th>
		<th>Account Balance</th>
	</tr>
	<%
		try {
		String id = request.getParameter("uid");
		Connection cn;
		cn = mySQL.getConnection();
		CallableStatement cst;
		if (id.equalsIgnoreCase("all")) {
			cst = cn.prepareCall("{call Accounts()}");
		} else {
			cst = cn.prepareCall("{call searchAccount(" + id + ")}");
		}

		ResultSet rs = cst.executeQuery();
		while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
	</tr>
	<%
		}
	} catch (Exception e) {
	//JOptionPane.showMessageDialog(null, e);
	}
	%>
</table>