<%@page import="Beans.RandomString"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
<link href="../css/Bg.css" rel="stylesheet">
<link href="../css/Manager.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/loading.css" rel="stylesheet">
</head>
<body>
	<div class="Bgimg">
		<img alt="Bank Main Image" src="../images/equity-release.png"><br>
	</div>
	<div>
		<form action="../transactionCashier" method="post" name="trans">
			<%
				try {
				String AccountNumber = request.getParameter("ID"), operation = request.getParameter("operation"),
				id = RandomString.getAlphaNumericString(10);

				;
				if (!AccountNumber.equals("") && !operation.equals("")) {
			%>
			<select name="id">
				<option value="<%=AccountNumber%>" selected="selected"><%=AccountNumber%>
			</select>
			<input type="number" name="amount" required="required">
			<input type="submit" name="operat" value="<%=operation%>">
			<%
				}
			} catch (Exception e) {

			}
			%>
		</form>
	</div>
</body>
</html>