package com.rains.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.db.Oracledb;
import com.rains.security.Validation;

/**
 * Servlet implementation class DeleteSt
 */
@WebServlet("/DeleteSt")
public class DeleteSt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = Oracledb.getInstance();
		try {
			CallableStatement cst = connection.prepareCall("{call deletest(?,?)}");
			cst.setString(1, String.valueOf(request.getSession().getAttribute("userId")));
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();

			try {
				if (Validation.verify(request)) {
					for (Cookie cookie : request.getCookies()) {
						cookie.setValue("");
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
					request.getSession().invalidate();

				}

			} catch (Exception e) {
				System.out.println("DeteleSt : " + e);
			}

			response.getWriter().print(cst.getString(2));
			cst.close();
		} catch (Exception e) {
			System.out.println("DeleteSt : " + e);
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
