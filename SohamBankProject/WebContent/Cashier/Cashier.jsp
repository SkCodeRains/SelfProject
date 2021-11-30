<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Beans.MySQL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Mr.<%=session.getAttribute("Name")%></title>
<link href="../css/Bg.css" rel="stylesheet">
<link href="../css/Manager.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/loading.css" rel="stylesheet">
<script type="text/javascript" src="../js/Cashier.js">
	
</script>
</head>
<body onload="openform('<%=session.getAttribute("forms")%>')" class="bg-transparent text-white">
	<%
		try {
		String ID = String.valueOf(session.getAttribute("ID"));
		if (ID.equalsIgnoreCase("Manager")) {
			response.sendRedirect("../Manager/Manager.jsp");
		} else if (ID.equalsIgnoreCase("Customer")) {
			response.sendRedirect("../Customer/Customer.jsp");
		} else if (ID.equalsIgnoreCase("Cashier")) {
	%>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div class="mainb">
		<button type="button" onclick="openform('Search')" value="Search">Search Account</button>
		<button type="button" onclick="openform('transfer')" value="transfer">transfer Amount</button>
		<button type="button" onclick="openform('report')" value="report">Todays Reports</button>
		<button type="button" onclick="window.location.href='../Logout.jsp'" class="Logout" style="float: right;">Logout</button>
	</div>
	<div class="Logoutdiv"></div>
	<div class="middleop" id="middleop">
		<div id="Search" class="middleblock">
			<h1>Search Account</h1>
			<input type="text" id="myInput" class="myInput" onkeyup="searchshow('myInput','myTable','closeacctable')" placeholder="Search for names.."
				title="Type in a name">
			<%
				try {
				if ("true".equalsIgnoreCase(String.valueOf(session.getAttribute("CashierValidate")))) {
					session.setAttribute("CashierValidate", "false");
					session.setAttribute("forms", null);
			%>
			<h3 style="color: purple;">
				<%=request.getParameter("oprations")%>
			</h3>
			<%
				}
			} catch (Exception e) {

			}
			%>
			<div id="closeacctable" style="display: none; max-height: 55%; overflow: auto; margin-left: -7%;">
				<table id="myTable" class="myTable">
					<tr class="header">
						<th style="width: 5%;">ID</th>
						<th style="width: 10%;">Name</th>
						<th>Type</th>
						<th>Balance</th>
						<th>Date</th>
						<th>Status</th>
						<th>Deposit</th>
						<th>withdraw</th>
					</tr>
					<%
						Connection Cn = MySQL.getdb();
					CallableStatement Ct = Cn.prepareCall("{call search}");
					ResultSet Rt = Ct.executeQuery();
					while (Rt.next()) {
					%>
					<tr>
						<td><%=Rt.getString(1)%>
						<td><%=Rt.getString(2)%>
						<td><%=Rt.getString(3)%>
						<td><%=Rt.getString(4)%>
						<td><%=Rt.getString(5)%>
						<td><%=Rt.getString(6)%>
						<td><a href="transaction.jsp?ID=<%=Rt.getString(1)%>&operation=Deposit">Deposit</a>
						<td><a onclick="showPage()" href="transaction.jsp?ID=<%=Rt.getString(1)%>&operation=Withdraw">Withdraw</a>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<div id="transfer" class="middleblock">
			<h1>Transfer Amount</h1>
			<form name="managerTransfer" method="post" action="../managerTransfer.jsp">
				<input type="text" name="from" placeholder="From">
				<input type="text" name="to" placeholder="to">
				<input type="number" name="amount">
				<br>
				<input type="submit">
			</form>
		</div>
		<div id="report" class="middleblock">
			<h1>Reports</h1>
			<div id="closeacctable" style="max-height: 500px; overflow: auto; margin-left: -7%;">
				<table id="myTable" class="myTable">
					<tr class="header">
						<th>Transaction Number</th>
						<th>transaction date</th>
						<th>Account Number</th>
						<th>Type</th>
						<th>Transfer Amount</th>
						<th>By</th>
					</tr>
					<%
						Cn = MySQL.getdb();
					CallableStatement Pt = Cn.prepareCall("{call todaysRecords()}");
					Rt = Pt.executeQuery();
					while (Rt.next()) {
					%>
					<tr>
						<td><%=Rt.getString(1)%>
						<td><%=Rt.getString(2)%>
						<td><%=Rt.getString(3)%>
						<td><%=Rt.getString(4)%>
						<td><%=Rt.getString(5)%>
						<td><%=Rt.getString(6)%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<div id="load"></div>
	</div>
	<%
		} else {
		response.sendRedirect("../index.jsp");
	}

	} catch (Exception e) {
		out.print(e);
	}
	%>
</body>
</html>