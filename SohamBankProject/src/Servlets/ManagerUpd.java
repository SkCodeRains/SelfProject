package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Beans.MySQL;

/**
 * Servlet implementation class ManagerUpd
 */
@WebServlet("/ManagerUpd")
public class ManagerUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection Cn;
	CallableStatement Ct;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerUpd() {
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
		// TODO Auto-generated method stub
		try {
			Cn = MySQL.getdb();
			Ct = Cn.prepareCall("{call UPDATEacc(?,?,?,?,?)}");
			Ct.setString(1, request.getParameter("accno"));
			Ct.setString(2, request.getParameter("pswd"));
			Ct.setString(3, request.getParameter("accnm"));
			Ct.setString(4, request.getParameter("acctype"));
			Ct.setString(5, request.getParameter("status"));
			int Validate = Ct.executeUpdate();

			if (Validate > 0) { 
				session.setAttribute("forms", "CloseAccount");
				session.setAttribute("Closevalidate", "true");
				response.sendRedirect("Manager/Manager.jsp?deletedAccName=Account Has been Updated Account Name : "
						+ request.getParameter("accnm"));
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(e);
		}
	}

}
