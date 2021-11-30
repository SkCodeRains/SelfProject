<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Beans.RandomString"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="Beans.MySQL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Mr.<%=session.getAttribute("Name")%></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Bg.css" rel="stylesheet">
<link href="css/Manager.css" rel="stylesheet">
<link href="css/loading.css" rel="stylesheet">
</head>
<body>
	<%
		try {
		String ID = String.valueOf(session.getAttribute("ID"));
		double limit = 0, available = 0;
		if (ID.equalsIgnoreCase("Cashier")) {
			limit = 20000;
		} else if (ID.equalsIgnoreCase("Customer")) {
			limit = 5000;
		} else if (ID.equalsIgnoreCase("Manager")) {
			limit = Double.parseDouble(request.getParameter("amount"));
		}
	%>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div align="center" style="background: transparent; display: block; padding-top: 15%; position: fixed; font-size: 23px; font-style: i;">
		<%
			String to = "", from = "";
		String t1 = "", t2 = "", id = "", id2 = "";
		id = RandomString.getAlphaNumericString(10);
		id2 = id + "2";
		double amount = 0.0;
		amount = Double.parseDouble(request.getParameter("amount"));
		to = request.getParameter("to");
		from = request.getParameter("from");
		Connection Cn = MySQL.getdb();
		PreparedStatement Pt = Cn.prepareStatement("select * from accounts where accno=?");
		Pt.setString(1, from);
		ResultSet Rt = Pt.executeQuery();
		if (Rt.next()) {
			t1 = Rt.getString(1);
			available = Rt.getDouble(4);
		}
		Pt = Cn.prepareStatement("select * from accounts where accno=?");
		Pt.setString(1, to);
		Rt = Pt.executeQuery();
		if (Rt.next()) {
			t2 = Rt.getString(1);
		}
		if (t1.equalsIgnoreCase(from) && t2.equalsIgnoreCase(to)) {
			if (available >= amount) {
				if (limit >= amount) {
			CallableStatement Ct = Cn.prepareCall("{call transaction(?,?,?,?,?)}");
			Ct.setString(1, from);
			Ct.setString(2, to);
			Ct.setString(3, id);
			Ct.setString(4, id2);
			Ct.setDouble(5, amount);
			int val = Ct.executeUpdate();
			if (val > 0) {
				out.print("Amount Hasbeen Transferd");
			}
				} else {
			out.print("Transfer Money Under your limit");
				}

			} else {
				out.print("<label>Insufficiant Balance</label>");
			}
		} else {
			out.print("Account Number Not Match");
		}

		} catch (Exception e) {
			out.print(e);
		}
		%><br>
		<button onclick="window.location.href='index.jsp'" style="border-style: none;">Home</button>
	</div>
</body>
</html>
