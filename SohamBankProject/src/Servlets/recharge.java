package Servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Beans.MySQL;
import Beans.RandomString;

/**
 * Servlet implementation class recharge
 */
@WebServlet("/recharge")
public class recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public recharge() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String Idnumber = String.valueOf(session.getAttribute("IDNumber")), to = request.getParameter("Company"),
				ID = RandomString.getAlphaNumericString(10), amount = request.getParameter("amount");
		Connection Cn = MySQL.getdb();
		try {

			CallableStatement Ct = Cn.prepareCall("{call billpay(?,?,?,?,?,?)}");
			Ct.setString(1, Idnumber);
			Ct.setString(2, to);
			Ct.setString(3, ID);
			Ct.setString(4, ID + "2");
			Ct.setString(5, amount);
			Ct.setString(6, "Recharge  " + request.getParameter("mob"));
			int a = Ct.executeUpdate();
			if (a > 0) {
				JOptionPane.showMessageDialog(null, "Success");
				session.setAttribute("forms", "bill");
				session.setAttribute("validate", "true");
				response.sendRedirect("Customer/Customer.jsp");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
