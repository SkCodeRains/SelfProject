<%@page import="javax.swing.JOptionPane"%>
<%@page import="beans.mySQL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	Connection Cn;
PreparedStatement Pt;
ResultSet Rt;

try {
	String to = request.getParameter("to");
	if (to.equalsIgnoreCase("listType")) {
		String type = request.getParameter("type");
%>
<form name="ddlfrm2">
	<div class="form__group field" style="margin-top: 30px;">
		Select Accounts Name
		<select class="form__field" name="listName" onchange="dropDownList('drpdwnlistsName','listName')">
			<option value="#">Select</option>
			<%
				Cn = mySQL.getConnection();
			Pt = Cn.prepareStatement("select * from accounts where acctype=?");
			Pt.setString(1, type);
			Rt = Pt.executeQuery();
			while (Rt.next()) {
				String Id = Rt.getString(1);
				String getname = Rt.getString(2);
			%><option value="<%=Id%>"><%=getname%></option>
			<%
				}
			Cn.close();
			%>
		</select>
	</div>
</form>

<%
	} else {
String id = request.getParameter("id");
Cn = mySQL.getConnection();
Pt = Cn.prepareStatement("select * from accounts where accno=?");
Pt.setString(1, id);
Rt = Pt.executeQuery();

if (Rt.next()) {
%>
<table class="table text-white table-hover">
	<tr>
		<td>ID</td>
		<td><%=Rt.getString(1)%></td>
	</tr>
	<tr>
		<td>Holder Name</td>
		<td><%=Rt.getString(2)%></td>
	</tr>
	<tr>
		<td>Account Type</td>
		<td><%=Rt.getString(3)%></td>
	</tr>
	<tr>
		<td>Balance</td>
		<td><%=Rt.getString(4)%></td>
	</tr>

</table>
<%
	}
}

} catch (Exception e) {

}
%>