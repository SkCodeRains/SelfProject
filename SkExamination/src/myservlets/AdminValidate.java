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
 * Servlet implementation class AdminValidate
 */
@WebServlet("/AdminValidate")
public class AdminValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id,ps;
		PrintWriter out=response.getWriter();
		
		id=request.getParameter("cid");
		ps=request.getParameter("psw");
		
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{

		    con=Mysql.GetConnection();
		    
		    pst=con.prepareStatement("select * from admin where name=? and password=?;");
		    pst.setString(1, id);
		    pst.setString(2, ps);
		  
		    
		    
		    rs=pst.executeQuery();
		    
		    if(rs.next())
		       
		    		response.sendRedirect("Admin.jsp");
		    else
		    
		    	response.sendRedirect("Failure.jsp");
		    
		    }
		catch(Exception e)
		{
			out.println(e);
		}
			
	
	}

}
