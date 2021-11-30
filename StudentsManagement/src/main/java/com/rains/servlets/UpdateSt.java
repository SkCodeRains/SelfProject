package com.rains.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.db.Oracledb;
import com.rains.util.DateGenrator;

/**
 * Servlet implementation class UpdateSt
 */
@WebServlet("/UpdateSt")
public class UpdateSt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = Oracledb.getInstance();
		try {
			CallableStatement cst = connection.prepareCall("{call updatest(?,?,?,?)}");
			cst.setInt(1, Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
			String date = request.getParameter("datas").trim();
			if (request.getParameter("columns").trim().equalsIgnoreCase("dobs"))
				date = DateGenrator.generate(date);
			cst.setString(2, request.getParameter("columns").trim());
			cst.setString(3, date);
			cst.registerOutParameter(4, Types.VARCHAR);
			cst.execute();
			String rs = cst.getString(4);
			if (rs.equals("true"))
				response.getWriter().print(rs);
			cst.close();

		} catch (Exception e) {
			response.getWriter().print("false");
			System.out.println("UpdateST : " + e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
