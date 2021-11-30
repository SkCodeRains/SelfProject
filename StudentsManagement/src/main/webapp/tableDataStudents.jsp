<%@page import="java.sql.Connection"%>
<%@page import="com.rains.util.Encryption"%>
<%@page import="java.util.Base64"%>
<%@page import="oracle.jdbc.OracleTypes"%>
<%@page import="oracle.jdbc.oracore.OracleType"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Types"%>
<%@page import="com.rains.db.Oracledb"%>
<%@page import="java.sql.CallableStatement"%>
<div id="main"
	class=" d-flex vh-70  main w-100 justify-content-center align-items-center ">

	<div class=" details bg-light   w-75 h-75 ">
		<%
		Connection connection = Oracledb.getInstance();
		try {
			CallableStatement cst = connection.prepareCall("{call ADMIN_REQUEST_STUDENT_DETAILS(?,?)}");
			cst.setString(1, Encryption.decrypt(request.getParameter("id")));
			cst.registerOutParameter(2, Types.REF_CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(2);
			if (rs.next()) {
		%>


		<div class="w-100 d-flex justify-content-center align-items-center">
			<img class="rounded-circle  " style="width: 200px" alt=""
				src="ProfilePic?id=<%=Encryption.decrypt(request.getParameter("id"))%>">
		</div>
		<table class="table-responsive table border-danger  w-100">
			<tr class="thead w-100">
				<th scope="col">First Name</th>
				<th scope="col">Middle Name</th>
				<th scope="col">Surname</th>
				<th scope="col">Mobile</th>
				<th scope="col">Emails</th>
			</tr>

			<tr>
				<td>
					<p id="fname" class="border-0" ondblclick="edit(this);"><%=rs.getString(1)%></p>
				</td>
				<td>
					<p id="lname" class="border-0" ondblclick="edit(this);"><%=rs.getString(2)%></p>
				</td>
				<td>
					<p id="surname" class="border-0" ondblclick="edit(this);"><%=rs.getString(3)%></p>
				</td>
				<td>
					<p id="mobile" class="border-0" ondblclick="edit(this);"><%=rs.getString(4)%></p>
				</td>
				<td>
					<p id="CHECKS" class="border-0" ondblclick="edit(this);"><%=rs.getString(5)%></p>
				</td>
			</tr>

		</table>


		<table class="table-responsive table-borderless  table  w-100">


			<tr class="mt-5">

				<th scope="col">Gender</th>
				<!-- <th scope="col">photo</th>  -->
				<th scope="col">Class</th>
				<th scope="col">Status</th>
				<th scope="col">DOB</th>


			</tr>


			<tr>

				<td>
					<p id="email" class="border-0" ondblclick="edit(this);"><%=rs.getString(6)%></p>
				</td>
				<td>
					<p id="gender" class="border-0" ondblclick="edit(this);"><%=rs.getString(7)%></p>
				</td>
				<td>
					<p id="class" class="border-0" ondblclick="edit(this);"><%=rs.getString(8)%></p>
				</td>
				<td>
					<p><%=rs.getString(9)%></p>
				</td>
				<td>
					<button id="<%=Encryption.encrypt(rs.getString(10))%>"
					class="btn float-right mr-5 align-bottom align-bottom position-relative btn-success align-items-center"
					value="Delete" onclick="acceptReq(this)">Accept Admission
						Request</button>
				</td>
			</tr>
		</table>


		<%
		} else
		System.out.print("data not found");
		} catch (Exception e) {
		out.print(e);
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
		<span id="msg" class=" success h4"> </span>

	</div>

</div>