<%@page import="java.sql.*"%>
<%@page import="Beans.MySQL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Accounts</title>
<link href="../css/Bg.css" rel="stylesheet">
<link href="../css/ManagerUpd.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/loading.css" rel="stylesheet">
</head>
<body>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div class="UpdateMain">
		<form name="UpdateManagerform" method="post" action="../ManagerUpd">
			<%
				Connection Cn = MySQL.getdb();
			CallableStatement Ct = Cn.prepareCall("{call searchUpd(?)}");
			Ct.setString(1, request.getParameter("ID"));
			ResultSet Rt = Ct.executeQuery();
			if (Rt.next()) {
			}
			%>
			<div class="leftdiv" align="left">
				<div class="inputfieldupd">
					<label for="accno">Account Number : </label>
					<br> <select name="accno">
						<option id="accno" value="<%=Rt.getString("accno")%>" selected="selected"><%=Rt.getString("accno")%></option>
					</select>
				</div>
				<div class="inputfieldupd">
					<label for="accnm">Account Holder Name</label>
					<br>
					<input type="text" name="accnm" id="accnm" value="<%=Rt.getString("accnm")%>">
				</div>
				<div class="inputfieldupd">
					<label>Account Type</label>
					<br> <select name="acctype">
						<%
							String t1 = "Fixed", t2 = "Current", t3 = "Saving";
						if (Rt.getString("acctype").equalsIgnoreCase("Fixed")) {

						} else if (Rt.getString("acctype").equalsIgnoreCase("Current")) {
							t1 = t2;
							t2 = "Fixed";
						} else if (Rt.getString("acctype").equalsIgnoreCase("Saving")) {
							t1 = t3;
							t3 = "Fixed";
						}
						%>
						<option value="<%=t1%>" selected="selected">
							<%=t1%></option>
						<option value="<%=t2%>">
							<%=t2%></option>
						<option value="<%=t3%>">
							<%=t3%></option>
					</select>
				</div>
			</div>
			<div class="rightdiv">
				<div class="inputfieldupd">
					<label>Account Balance</label>
					<br>
					<input type="number" name="balance" id="balance" value="<%=Rt.getString("balance")%>" disabled="disabled">
				</div>
				<div class="inputfieldupd">
					<label>Account Status</label>
					<br> <select name="status">
						<%
							String a = Rt.getString("userstatus"), b = a, as = a;
						if (a.equalsIgnoreCase("active")) {
							b = "Activated";
							as = "Active";
							a = "DeActivate";
						} else {
							a = "Active";
							b = "DeActivated";
							as = "DeActivate";
						}
						%>
						<option value="<%=a%>"><%=a%></option>
						<option value="<%=as%>" selected><%=b%>
						</option>
					</select>
				</div>
				<div class="inputfieldupd">
					<label for="pswd">Account Password</label>
					<br>
					<input type="text" name="pswd" id="pswd" value="<%=Rt.getString("pswd")%>">
				</div>
			</div>
			<div align="center" style="padding-top: 20%">
				<input onclick="showPage()" type="Submit" style="margin-top: 5%; margin-left: -10%; border-radius: 10px;">
			</div>
			<div id="load"></div>
		</form>
		<%
			
		%>
	</div>
	<script type="text/javascript">
		function showPage() {
			var element = document.getElementById("load");
			element.classList.add("loader");
		}
	</script>
</body>
</html>