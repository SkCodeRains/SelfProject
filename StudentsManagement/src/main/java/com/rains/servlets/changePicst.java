package com.rains.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.db.Oracledb;

/**
 * Servlet implementation class testing
 */
@MultipartConfig(maxFileSize = 999999999)
@WebServlet("/testing")
public class changePicst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = Oracledb.getInstance();
		try {
			PreparedStatement pst = connection.prepareStatement("update students set photos =? where sids=?");
			pst.setBlob(1, request.getPart("photo").getInputStream());
			pst.setString(2, String.valueOf(request.getSession().getAttribute("userId")));
			pst.execute();
			pst.close();
			response.sendRedirect(request.getContextPath() + "/Main.jsp");
		} catch (Exception e) {
			// TODO: handle exception
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
