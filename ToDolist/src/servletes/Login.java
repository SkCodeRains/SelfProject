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
import beans.sessions;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = Mysql.connection();
			CallableStatement cst = conn.prepareCall("{call varify(?,?)}");
			int i = 0;
			cst.setString(++i, request.getParameter("username"));
			cst.setString(++i, request.getParameter("password"));
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				sessions.setsession(request, response, rs.getString(1));
				conn.close();
				response.sendRedirect("TasksManagement/index.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.print("<body>Login Failes invalid username or password"
						+ "<br><a href='../ToDolist'>retry</a></body" + "");
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
