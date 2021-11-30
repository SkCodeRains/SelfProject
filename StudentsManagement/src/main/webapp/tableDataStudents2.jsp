
<%@page import="java.sql.Connection"%>
<%@page import="com.rains.util.DateGenrator"%>
<%@page import="java.sql.Types"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rains.db.Oracledb"%>
<%@page import="java.sql.CallableStatement"%>
<%
Connection connection = Oracledb.getInstance();
try {
	CallableStatement cst = connection.prepareCall("{call getstudents(?,?)}");
	cst.setInt(1, Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
	cst.registerOutParameter(2, Types.REF_CURSOR);
	cst.execute();
	ResultSet rs = (ResultSet) cst.getObject(2);
	if (rs.next()) {
%>


<div style="height: 70vh;"
	class=" d-flex justify-content-center align-items-center">
	<div class="w-75 h-75 d-flex " style="background-color: aliceblue;">
		<div style="border-radius: 10px; width: 40%;"
			class=" h-100   flex-column  d-flex justify-content-center align-items-center ">
			<img class="w-75 rounded-circle" src="ProfilePic" alt="">
			<div>
				<button
					class="btn  mt-3 border-left-0 border-right-0 border-top-0  border border-bottom  text-center border-success mr-3 center btn-outline-success"
					onclick="document.getElementById('Photosa').click();"
					value="Upload Photo">Change photo</button>
			</div>
		</div>


		<div style="width: 60%;" class="  h-100 ">
			<div class="w-100">
				<h1 id="heading " class="text-center text-primary text-uppercase">Welcome</h1>
			</div>

			<form action="testing" method="post" id="forms" name="form"
				enctype="multipart/form-data">
				<input type="file" onchange="document.forms.form.submit()"
					name="photo" id="Photosa" hidden>
			</form>


			<div class="names w-100 d-flex flex-row  ">
				<input type="text" ondblclick="Enable(this)"
					onfocusout="Disable(this);" onchange="Update(this)" ; readonly
					name="fname" placeholder="First Name" value="<%=rs.getString(1)%>"
					class="d-inline-block mr-3 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required> <input value="<%=rs.getString(2)%>" type="text"
					ondblclick="Enable(this)" onfocusout="Disable(this);"
					onchange="Update(this)" ; readonly name="lname"
					placeholder="Middle Name"
					class="d-inline-block mr-3 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required> <input type="text" ondblclick="Enable(this)"
					onfocusout="Disable(this);" onchange="Update(this)" ; readonly
					name="surname" placeholder="surname" value="<%=rs.getString(3)%>"
					class="d-inline-block mr-3 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required>
			</div>



			<div class="numbers mt-3 w-100">
				<input type="number" name="Mobiles" placeholder="Mobile Number"
					class=" bg-transparent removeOutline d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					value="<%=rs.getString(4)%>" ondblclick="Enable(this)"
					onfocusout="Disable(this);" onchange="Update(this)"
					min="1000000000" max="9999999999" readonly required>
			</div>

			<div class="emails mt-3 w-100">
				<input type="email" ondblclick="Enable(this)"
					onfocusout="Disable(this);" onchange="Update(this)" ; name="emails"
					placeholder="Email" value="<%=rs.getString(5)%>"
					class=" bg-transparent removeOutline d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required readonly>
			</div>
			<div class="genders d-flex mt-2 justify-content-between w-50">
				<input type="text" readonly ondblclick="Enable(this)"
					onfocusout="Disable(this)" onchange="Update(this)" id="gender"
					name="genders" placeholder="genders" value="<%=rs.getString(6)%>"
					class="bg-transparent removeOutline d-inline-block mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary ">
			</div>



			<div class="dob mt-3 w-100">
				<input onchange="Update(this)" ondblclick="Enable(this)"
					onfocusout="Disable(this);" readonly
					value="<%=DateGenrator.generate(rs.getString(9))%>" type="text"
					id="date" name="dobs"
					class="d-inline-block bg-transparent removeOutline mobile w-75 border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					min="1990-01-01" max="2010-12-01" required>
			</div>



			<div class="Class mt-3 w-100">
				<input type="text" ondblclick="Enable(this)"
					onfocusout="Disable(this);" onchange="Update(this)" ; readonly
					name="stdclass" placeholder="Enter Class"
					value="<%=rs.getString(7)%>"
					class="d-inline-block mr-3 w-75 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required onblur="Disable(this);">
			</div>

			<div class="Status mt-3 w-100">
				<input type="text" disabled="disabled" placeholder="Enter Class"
					value="<%=rs.getString(8)%>"
					class="d-inline-block mr-3 w-75 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required onblur="Disable(this);">
			</div>

			<div class="CHECKS mt-3 w-100">
				<input type="text" disabled="disabled" placeholder="Enter Class"
					value="<%=rs.getString(10)%>"
					class="d-inline-block mr-3 w-75 removeOutline bg-transparent  border-left-0 border-right-0 border-top-0  border border-bottom-0 border-primary "
					required onblur="Disable(this);">
			</div>


			<div class="btns d-flex w-100 flex-wrap justify-content-center  ">
				<input type="submit"
					class="btn w-50  mt-3 border-left-0 border-right-0 border-top-0  border border-bottom  text-center border-success mr-3 center btn-outline-success ">
				<input type="button"
					class="btn w-25  mt-3  border-left-0 border-right-0 border-top-0  border border-bottom  border-danger text-center center btn-outline-danger"
					title="Delete Admission Request" value="Delete Admission Request"
					onclick="Delete();">
			</div>

		</div>
	</div>

</div>

<script>
	function Enable(obj) {
		if (obj.id == 'date') {
			obj.type = 'date';
		}
		obj.classList.add('border-bottom')
		obj.classList.remove("border-bottom-0")
		obj.removeAttribute('readonly');
	}
	function Disable(obj) {
		if (obj.id == 'dob') {
			obj.type = 'text';
		}
		obj.classList.add('border-bottom-0')
		obj.classList.remove('border-bottom')
		obj.readOnly = true;
	}
</script>

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