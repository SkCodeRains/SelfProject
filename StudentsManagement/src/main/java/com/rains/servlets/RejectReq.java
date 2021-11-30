package com.rains.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.rains.db.Oracledb;
import com.rains.util.Encryption;

/**
 * Servlet implementation class RejectReq
 */
@WebServlet("/RejectReq")
public class RejectReq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RejectReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = Oracledb.getInstance();
		try {
			CallableStatement cst = con.prepareCall("{call admin_rejecting_request(?)}");
			cst.setString(1, Encryption.decrypt(request.getParameter("id").trim()));
			cst.execute();
			cst.close();
			response.getWriter().print("true");
		} catch (Exception e) {
			System.out.println("RejectReq : " + e);
		} finally {
			try {
				con.close();
				con = null;
			} catch (Exception e2) {
				System.out.println("RejectReq  con close : " + e2);
			}
		}
	}

}
