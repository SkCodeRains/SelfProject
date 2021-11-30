package Servlets;

import java.util.Random;

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

/**
 * Servlet implementation class newacc
 */
@WebServlet("/newacc")
public class newacc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String name, type, bal, password, status, Id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newacc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			password = request.getParameter("password");
			name = request.getParameter("usernm");
			type = request.getParameter("type");
			status = request.getParameter("status");
			bal = request.getParameter("balance");
			Random rand = new Random();
			int a = rand.nextInt(10000);
			Id = "SK" + String.valueOf(a) + name.substring(0, 1);
			Connection Cn = MySQL.getdb();
			CallableStatement Ct = Cn.prepareCall("{call NEWACCOUNT(?,?,?,?,?,?)}");
			Ct.setString(1, Id);
			Ct.setString(2, password);
			Ct.setString(3, name);
			Ct.setString(4, type);
			Ct.setString(5, status);
			Ct.setString(6, bal);
			int Rt = Ct.executeUpdate();
			if (Rt > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("newUserName", "New Registration Successfully Added Name : " + name);
				session.setAttribute("forms", "NewAccount");
				session.setAttribute("validate", "true");
				response.sendRedirect("Manager/Manager.jsp");
			}

		} catch (Exception e) {
			System.out.println(e);
			HttpSession session = request.getSession();
			session.setAttribute("forms", "NewAccount");
			session.setAttribute("newUserName", e);
			response.sendRedirect("Manager/Manager.jsp");
			JOptionPane.showMessageDialog(null, e);
		}

	}

}
