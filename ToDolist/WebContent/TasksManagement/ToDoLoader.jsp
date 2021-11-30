<%@page import="javax.swing.JOptionPane"%>
<%@page import="beans.validation"%>
<%@page import="beans.encID"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="beans.Mysql"%>
<%@page import="java.sql.Connection"%>
<%
if (validation.validate(request)) {
%>
<fieldset>
	<legend style="font-size: 25px; font-weight: bold;">Make Task
		And Go With It</legend>


	<div id="TodoTask" class="Container" draggable="false">
		<div id="ContainerHead">
			<a href="javaScript:addTask()" class="addTask">
				<span id="addTaskSpan">&#43;</span>
			</a>
			<b class="ContainerHead"> To do List </b>
			<hr>
		</div>
		<%
		try {
			ResultSet rs;
			CallableStatement cst;
			Connection cn = Mysql.connection();
			cst = cn.prepareCall("{call getdata(?)}");
			cst.setString(1, encID.decrypt(String.valueOf(session.getAttribute("uid"))));
			cst.execute();
			rs = cst.getResultSet();
			try {
				while (rs.next()) {
		%>
		<div class="dragg">
			<a href="javaScript:removeTask('<%=rs.getString(1)%>')"
				class="addTask">
				<span class="removeTask">X</span>
			</a>
			<p class="Work" draggable="true" id="<%=rs.getString(1)%>"><%=rs.getString(2)%></p>
			<hr>
		</div>
		<%
		}

		} catch (Exception e) {
		System.out.println("Ex  :  " + e);
		}
		%>
	</div>




	<div id="ContinueTask" class="Container">
		<b class="ContainerHead">On Working</b>
		<hr>
		<%
		rs.close();
		cst.getMoreResults();
		rs = cst.getResultSet();
		try {
			while (rs.next()) {
		%>
		<div class="dragg">
			<a href="javaScript:removeTask('<%=rs.getString(1)%>')"
				class="addTask">
				<span class="removeTask">X</span>
			</a>
			<p class="Work" draggable="true" id="<%=rs.getString(1)%>"><%=rs.getString(2)%></p>
			<hr>
		</div>
		<%
		}

		} catch (Exception e) {
		System.out.println("Ex  :  " + e);
		}
		%>
	</div>

	<div id="CompleteTask" class="Container">
		<b class="ContainerHead">Completed</b>
		<hr>
		<%
		rs.close();
		cst.getMoreResults();
		rs = cst.getResultSet();
		try {
			while (rs.next()) {
		%><div class="dragg">
			<a href="javaScript:removeTask('<%=rs.getString(1)%>')"
				class="addTask">
				<span class="removeTask">X</span>
			</a>
			<p class="Work" draggable="true" id="<%=rs.getString(1)%>"><%=rs.getString(2)%></p>
			<hr>
		</div>
		<%
		}
		cst.close();
		rs.close();
		cn.close();
		} catch (Exception e) {
		System.out.println("Ex  :  " + e);
		}
		} catch (Exception e) {
		System.out.println("Ex  :  " + e);
		}
		}
		%>
	</div>
</fieldset>