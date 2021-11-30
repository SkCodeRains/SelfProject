package myservlets;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forget
 */
@WebServlet("/Forget")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		String id,sq,an,nps,mo;
		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		id=request.getParameter("cid");
		sq=request.getParameter("seq");
		an=request.getParameter("ans");

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/makexamdb?user=root&password=mysql");
			pst=con.prepareStatement("select * from candiinfo where cid=? and seq=? and answer=?;");
			pst.setString(1,id);
			pst.setString(2,sq);
			pst.setString(3,an);
			
			rs=pst.executeQuery();
			if(rs.next())
			{
				mo=rs.getString("mobile");
				nps=id.substring(1, 3)+"@"+mo.substring(1, 3);
				out.println("<h3 style='color:green'>Your new password is "+nps+"</h3>");
				
				pst=con.prepareStatement("update candiinfo set password=? where cid=?;");
				pst.setString(1,nps);
				pst.setString(2,id);
				pst.executeUpdate();
				
			}
			else
			{
				out.println("<h3 style='color:red'>User identity failed</h3>");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}

		out.println("<br><a href=\'Login.jsp\'>Back to Login</a>");
		
		

		
		
		
		
		
		
		
		
		
	}

}
