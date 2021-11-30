<%@page import="com.mysql.cj.Session"%>
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
<link href="../css/Customer.css" rel="stylesheet">
<script type="text/javascript" src="../js/Customer.js">
	
</script>
</head>
<body onload="openform('<%=session.getAttribute("forms")%>')" class="bg-transparent text-white">
	<%
		try {
		String ID = String.valueOf(session.getAttribute("ID"));
		if (ID.equalsIgnoreCase("Cashier")) {
			response.sendRedirect("../Cashier/Cashier.jsp");
		} else if (ID.equalsIgnoreCase("Manager")) {
			response.sendRedirect("../Manager/Manager.jsp");
		} else if (ID.equalsIgnoreCase("Customer")) {
	%>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div class="mainb">
		<button type="button" onclick="openform('Statement')" value="NewAccount">Account Statement</button>
		<button type="button" onclick="openform('Transfer')" value="NewAccount">Account Transactions</button>
		<button type="button" onclick="openform('bill')" value="NewAccount">Pay electric bill</button>
		<button type="button" onclick="openform('Recharge')" value="NewAccount">Recharge</button>
		<button type="button" onclick="window.location.href='../Logout.jsp'" class="Logout" style="float: right;">Logout</button>
	</div>
	<div class="middleop" id="middleop">
		<div id="Statement" class="middleblock">
			<h1>Account Statement</h1>
			<%
				Connection Cn = MySQL.getdb();
			CallableStatement Ct = Cn.prepareCall("{call searchUpd(?)}");
			Ct.setString(1, String.valueOf(session.getAttribute("IDNumber")));
			ResultSet Rt = Ct.executeQuery();
			if (Rt.next()) {
			%>
			<table class="table table-borderless" id="tbales">
				<tr>
					<td>CRN No.
					<td><%=Rt.getString(1)%>
				</tr>
				<tr>
					<td>Name
					<td><%=Rt.getString(2)%>
				</tr>
				<tr>
					<td>Account
					<td><%=Rt.getString(3)%>
				</tr>
				<tr>
					<td>Balance
					<td><%=Rt.getString(4)%>
				</tr>
				<tr>
					<td>Date
					<td><%=Rt.getString(5)%>
				</tr>
				<tr>
					<td>Status
					<td><%=Rt.getString(6)%>
				</tr>
				<tr>
					<td>Change Password
					<td><a href="#changepassword">Click Here</a>
				</tr>
			</table>
			<%
				try {
				if (!session.getAttribute("passupd").equals(null))
					out.print(session.getAttribute("passupd"));
				session.setAttribute("passupd", "");
			} catch (Exception e) {
			}
			%>
			<div id="changepassword" class="changepassword">
				<h4 style="float: right;">
					<a href="javascript:window.history.back();" onclick="ClearFields()">Close</a>
				</h4>
				<div style="padding: 10%;">
					<form name="changepass" method="post" action="../ChangePass">
						<input type="password" style="width: 100%;" placeholder="Enter Old Password" id="oldpass" onkeyup="passvalidate('<%=Rt.getString(7)%>')">
						<input type="password" style="width: 100%;" placeholder="Enter New Password" id="newpass">
						<input type="text" style="width: 100%;" name="confpass" placeholder="Confirm New Password" id="confpass"
							onkeyup="passvalidate('<%=Rt.getString(7)%>')">
						<input type="submit" id="passSubmit" style="width: 100%; border-radius: 20px; display: none;">
					</form>
				</div>
			</div>
			<a style="font-size: 20px; color: white;" href="javascript:repoerts()">Statement Reports</a>
			<a style="font-size: 20px; color: white; float: right;" href="javascript:hideclose()">Close</a>
			<div id="reports" style="display: none;">
				<div id="closeacctable" style="max-height: 500px; overflow: auto; margin-left: -7%;">
					<table id="myTable" class="myTable">
						<tr class="header">
							<th>Transaction Number</th>
							<th>transaction date</th>
							<th>Account Number</th>
							<th>Type</th>
							<th>Amount</th>
							<th>To</th>
						</tr>
						<%
							Cn = MySQL.getdb();
						PreparedStatement St = Cn.prepareStatement("select * from acctransactions where accno=?");
						St.setString(1, String.valueOf(session.getAttribute("IDNumber")));
						Rt = St.executeQuery();

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
			<%
				}
			%>
		</div>
		<div id="Transfer" class="middleblock">
			<h1>Transfer Amount</h1>
			<form name="managerTransfer" method="post" action="../managerTransfer.jsp?from=<%=session.getAttribute("IDNumber")%>">
				<input type="text" name="to" placeholder="to">
				<input type="number" name="amount">
				<br>
				<input type="submit" onclick="showPage()">
			</form>
		</div>
		<div id="bill" class="middleblock">
			<form method="post" action="../PayBill?toFor=payBill">
				<select name="Company" id="electric">
					<option value="Vitran">Vitran</option>
					<option value="MahaSk">MahaSk</option>
				</select>
				<input type="text" name="BillNo" placeholder="meter No.">
				<input type="number" name="BillAmont" required="required" placeholder="Amount To be Paid">
				<button type="submit" onclick="showPage()">PAY</button>
			</form>
			<%
				if ("true".equalsIgnoreCase(String.valueOf(session.getAttribute("validate")))) {
				session.setAttribute("validate", "false");
				session.setAttribute("forms", "false");
			%>
			<input type="text" style="width: 100%; border-style: none; color: purple; font-size: 20px" value="Electric Bill Paid">
			<%
				}
			%>
		</div>
		<div id="Recharge" class="middleblock">
			<form method="post" action="../PayBill?toFor=Recharge">
				<select name="Company">
					<option value="Vodafone">Vodafone</option>
					<option value="Airtel">Airtel</option>
					<option value="DishTV">DishTV</option>
				</select>
				<input type="number" required="required" name="mob" placeholder="Mobile Number" min="10">
				<input type="number" required="required" name="BillAmont" placeholder="Amount">
				<button type="submit" onclick="showPage()">Recharge</button>
			</form>
			<%
				if ("true".equalsIgnoreCase(String.valueOf(session.getAttribute("revalidate")))) {
				session.setAttribute("revalidate", "false");
				session.setAttribute("forms", "false");
			%>
			<input type="text" style="width: 100%; border-style: none; color: purple; font-size: 20px" value="Recharge Done">
			<%
				}
			%>
		</div>
		<div id="load"></div>
	</div>
	<script type="text/javascript">
		function showPage() {
			var element = document.getElementById("load");
			element.classList.add("loader");
		}
	</script>
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