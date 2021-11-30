package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Beans.MySQL;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePass() {
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
		Connection Cn = MySQL.getdb();
		try {
			String pass = request.getParameter("confpass");
			PreparedStatement pt = Cn.prepareStatement("update users set pswd=? where userID=?");
			pt.setString(1, pass);
			pt.setObject(2, request.getSession().getAttribute("IDNumber"));
			int a = pt.executeUpdate();
			if (a > 0) {
				request.getSession().setAttribute("forms", "Statement");
				request.getSession().setAttribute("passupd", "Password Hasbeen Updated !.");
				response.sendRedirect("Customer/Customer.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
