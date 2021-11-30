<%@page import="java.sql.Connection"%>
<%@page import="com.rains.util.Encryption"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Types"%>
<%@page import="com.rains.db.Oracledb"%>
<%@page import="java.sql.CallableStatement"%>
<%
Connection connection = Oracledb.getInstance();
try {
	CallableStatement cst = connection.prepareCall("{call GET_STUDENTS_REQUEST_REJECTED(?)}");
	cst.registerOutParameter(1, Types.REF_CURSOR);
	cst.execute();
	ResultSet rs = (ResultSet) cst.getObject(1);
%>
<div class="w-75 h-75 bg-light " style="overflow: scroll;">
	<table class="table">
		<tr>
			<th>Details</th>
			<th>Name</th>
			<th>date</th>
			<th>for class</th>
			<th>age</th>
			<th>Request</th>
		</tr>
		<%
		while (rs.next()) {
			String id = Encryption.encrypt(rs.getString(1));
		%>
		<tr>
			<td><a href="javascript:LoadsDatas('tableDataStudents','<%=id%>')"
				class="text-decoration-none p-3     ">Open</a></td>

			<td><%=rs.getString(2)%></td>

			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td>
				<button id="<%=id%>"  onclick="acceptReq(this)"
					class="btn  mt-3 border-left-0 border-right-0 border-top-0  border border-bottom  text-center border-success mr-3 center btn-outline-success ">ACCEPT</button>
			</td>

		</tr>
		<%
		}
		cst.close();
		rs.close();

		} catch (Exception e) {
		out.print(" error from AdminfronPanel : " + e);
		} finally {
		try {
		connection.close();
		connection = null;
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		%>
	</table>
</div>