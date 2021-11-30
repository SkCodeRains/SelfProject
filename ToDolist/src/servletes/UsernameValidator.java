package servletes;

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

import beans.Mysql;

@WebServlet("/UsernameValidator")
public class UsernameValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			Connection conn = Mysql.connection();
			CallableStatement cst = conn.prepareCall("{call username(?)}");
			cst.setString(1, request.getParameter("id"));
			ResultSet rs = cst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				out.print("true");
			} else {
				out.print("false");
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("username servlet " + e);
		}

	}

}
