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
<script type="text/javascript" src="../js/Manager.js">
	
</script>
</head>
<body onload="openform('<%=session.getAttribute("forms")%>')" class="bg-transparent text-white">
	<%
		try {
		String ID = String.valueOf(session.getAttribute("ID"));
		if (ID.equalsIgnoreCase("Cashier")) {
			response.sendRedirect("../Cashier/Cashier.jsp");
		} else if (ID.equalsIgnoreCase("Customer")) {
			response.sendRedirect("../Customer/Customer.jsp");
		} else if (ID.equalsIgnoreCase("Manager")) {
	%>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div class="mainb">
		<button type="button" onclick="openform('NewAccount')" value="NewAccount">Open New Account</button>
		<button type="button" onclick="openform('CloseAccount')" value="CloseAccount">Search Account</button>
		<button type="button" onclick="openform('transfer')" value="transfer">Transfer Amount</button>
		<button type="button" onclick="openform('report')" value="report">Transaction report</button>
		<button type="button" onclick="window.location.href='Manager.jsp'" value="ADLogins">Refresh</button>
		<button type="button" onclick="window.location.href='../Logout.jsp'" class="Logout" style="float: right;">Logout</button>
	</div>
	<div class="middleop" id="middleop">
		<div id="NewAccount" class="middleblock">
			<h1>Create New Account</h1>
			<form method="post" action="../newacc">
				<input type="text" name="usernm" placeholder="Enter Customer Name" required="required">
				<input type="password" name="password" placeholder="Enter Customer password" required="required">
				<input type="number" name="balance" placeholder="Enter Initial Balance" required="required">
				<br> <br> <select name="type" required="required">
					<option value="Fixed">Fixed</option>
					<option value="Saving">Saving</option>
					<option value="Current">Current</option>
				</select> <select name="status" required="required">
					<option value="Active">Activate</option>
					<option value="DeActiv">DeActivate</option>
				</select> <br>
				<input type="submit" class="btn" onclick="showPage()">
				<script type="text/javascript">
					function showPage() {
						var element = document.getElementById("load");
						element.classList.add("loader");
						setTimeout(function() {
							element.classList.remove("loader");
						}, 5000);

					}
				</script>
				<button type="button" class="btn cancel" onclick="openform('s')">Close</button>
				<%
					String val = String.valueOf(session.getAttribute("validate"));
				if (val.equalsIgnoreCase("true")) {
				%>
				<input type="text" style="width: 100%; border-style: none; font-size: 25px" value="<%=session.getAttribute("newUserName")%>">
				<%
					session.setAttribute("newUserName", null);
				session.setAttribute("validate", null);
				session.setAttribute("forms", null);

				}
				%>
			</form>
		</div>
		<div id="CloseAccount" class="middleblock">
			<h1>Search account</h1>
			<input type="text" id="myInput" class="myInput" onkeyup="searchshow('myInput','myTable','closeacctable')" placeholder="Search for names.."
				title="Type in a name">
			<%
				try {
				if ("true".equalsIgnoreCase(String.valueOf(session.getAttribute("Closevalidate")))) {
					session.setAttribute("Closevalidate", "false");
					session.setAttribute("forms", null);
			%>
			<h3>
				<%=request.getParameter("deletedAccName")%>
			</h3>
			<%
				}
			} catch (Exception e) {

			}
			%>
			<div id="closeacctable" style="display: none; max-height: 55%; overflow: auto;">
				<table id="myTable" class="myTable">
					<tr class="header">
						<th style="width: 5%;">ID</th>
						<th style="width: 10%;">Name</th>
						<th>Type</th>
						<th>Balance</th>
						<th>Date</th>
						<th>Status</th>
						<th>Update</th>
						<th>Delete</th>
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
						<td><a onclick="showPage()" href="Update.jsp?ID=<%=Rt.getString(1)%>">UPDATE</a>
						<td><a onclick="showPage()" href="../DeleteAccontsList?ID=<%=Rt.getString("accno")%>&Name=<%=Rt.getString(2)%>;">DELETE</a>
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
					PreparedStatement Pt = Cn.prepareStatement("Select * from acctransactions");
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
		<div id="load" class="loaders"></div>
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