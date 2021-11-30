package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Setpass
 */
@WebServlet("/Setpass")
public class Setpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Setpass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String ps;
		ps = request.getParameter("psk");

		Connection con;
		PreparedStatement pst;

		try {

			con = Mysql.GetConnection();

			pst = con.prepareStatement("update candiinfo set passkey=?;");
			pst.setString(1, ps);

			pst.executeUpdate();

			out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n"
					+ "<body><br><a href='Login.jsp'>Login form</a></body>\r\n" + "</html>");
			out.println("passkey changed as " + ps);
		} catch (Exception e) {
			out.println(e);

		}
	}

}
