package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class transactionCashier
 */
@WebServlet("/transactionCashier")
public class transactionCashier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public transactionCashier() {
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
		String accno = request.getParameter("id");
		String amount = request.getParameter("amount");
		String id = RandomString.getAlphaNumericString(10);
		String type = request.getParameter("operat");
		try {
			Connection Cn = MySQL.getdb();
			CallableStatement Ct = Cn.prepareCall("{call withdrawDesposit(?,?,?,?)}");
			Ct.setString(1, accno);
			Ct.setString(2, id);
			Ct.setString(3, type);
			if (type.equalsIgnoreCase("withdraw")) {
				amount = "-" + amount;
			}
			Ct.setString(4, amount);
			int val = Ct.executeUpdate();
			if (val > 0) {
				session.setAttribute("CashierValidate", "true");
				session.setAttribute("forms", "Search");
				response.sendRedirect("Cashier/Cashier.jsp?oprations=Account Hasbeen " + type + " of" + amount);
			} else {
				out.print("Processing Failed");
			}
		} catch (Exception e) {
			out.print(e);
		}

	}

}
