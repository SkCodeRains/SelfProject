package com.rains.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.db.Oracledb;

/**
 * Servlet implementation class ProfilePic
 */
@WebServlet("/ProfilePic")
public class ProfilePic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilePic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = Oracledb.getInstance();
		try {
			PreparedStatement pst = connection.prepareStatement("select photos from students where sids=?");
			if (request.getParameter("id") == null)
				pst.setInt(1, Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
			else
				pst.setString(1, request.getParameter("id"));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				response.setContentType("image/jpg");
				OutputStream output = response.getOutputStream();
				output.write(rs.getBytes(1));
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("ProfilePic : " + e);
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
