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

import Beans.MySQL;

/**
 * Servlet implementation class DeleteAccontsList
 */
@WebServlet("/DeleteAccontsList")
public class DeleteAccontsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAccontsList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String ID = request.getParameter("ID");
		String act = request.getParameter("Name");
		try {
			Connection Cn = MySQL.getdb();
			CallableStatement Pt = Cn.prepareCall("{call deletes(?)}");
			Pt.setString(1, ID);
			int Rt = Pt.executeUpdate();
			if (Rt > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("forms", "CloseAccount");
				session.setAttribute("Closevalidate", "true");
				response.sendRedirect("Manager/Manager.jsp?deletedAccName=Account Has been deleted Account Name Was : " + act);
			}
		} catch (Exception e) {
			System.out.print(e);
		}

	}

}
