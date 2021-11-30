package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.MySQL;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("ID");
		String password = request.getParameter("pswd");
		try {
			Connection Cn = MySQL.getdb();
			PreparedStatement Pt = Cn.prepareStatement("select * from users where userID=? and pswd=?");
			Pt.setString(1, id);
			Pt.setString(2, password);
			ResultSet Rt = Pt.executeQuery();
			if (Rt.next()) {
				session.setAttribute("IDNumber", id);
				session.setAttribute("Name", Rt.getString(3));
				if (Rt.getString(5).equalsIgnoreCase("active")) {
					if (Rt.getString(4).equalsIgnoreCase("Manager")) {
						session.setAttribute("ID", "Manager");
						response.sendRedirect("Manager/Manager.jsp");
					} else if (Rt.getString(4).equalsIgnoreCase("Cashier")) {
						session.setAttribute("ID", "Cashier");
						response.sendRedirect("Cashier/Cashier.jsp");
					} else if (Rt.getString(4).equalsIgnoreCase("Customer")) {
						session.setAttribute("ID", "Customer");
						response.sendRedirect("Customer/Customer.jsp");
					}
				} else {
					out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
							+ "<title>Not Activate</title>\r\n" + "<link href=\"css/Bg.css\" rel=\"stylesheet\">\r\n"
							+ "</head>\r\n" + "<body>\r\n" + "	Your Account Is Not Active..!!!\r\n"
							+ "	<br> please Activate It.\r\n" + "</body>\r\n" + "</html>");
				}

			} else {
				out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Not Activate</title>\r\n" + "<link href=\"css/Bg.css\" rel=\"stylesheet\">\r\n"
						+ "</head>\r\n" + "<body>\r\n" + "	ID And Password Not Match\r\n" + "</body>\r\n" + "</html>");
			}
		} catch (Exception e) {
			out.print(e);
		}

	}

}
