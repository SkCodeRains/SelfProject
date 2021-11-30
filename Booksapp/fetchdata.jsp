<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.coderains.jdbc.oracle"%>
<%@page import="java.sql.Connection"%>
<%
try {
	Connection conn = oracle.conn;
	PreparedStatement pst = oracle.conn.prepareStatement("select * from books");
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
%>
<div class="book">
	<div class="img">
		<img
			src="<%= rs.getString(7) %>"
			alt="">
	</div>
	<div class="details">
		<div class="name">
			<%=rs.getString(1)%>
		</div>
		<div class="author">
			<%=rs.getString(2)%>
		</div>
		<div class="edition">
			Edition
			<%=rs.getString(3)%>
		</div>
		<div class="price">
			RS.<%=rs.getString(4)%>
		</div>
		<div class="qauntity">
			<%if(5 <= rs.getInt(5)){
				out.print("<span style=\"color:green\">In Stock</span>");
			}else{

				out.print("<span style=\"color:Red\">Only "+rs.getInt(5)+" left</span>");
			}
			%>
		</div>
		<div class="wrapper">
			<button>
				Preview <span></span> <span></span> <span></span> <span></span>
			</button>
		</div>
		<div class="wrapper">
			<button>
				Add <span></span> <span></span> <span></span> <span></span>
			</button>
		</div>
	</div>
</div>

<%
}
} catch (Exception e) {
e.printStackTrace();
}
%>