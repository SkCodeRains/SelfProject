package servletes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Mysql;
import beans.validation;

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (validation.validate(request)) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Connection cn = Mysql.connection();
				CallableStatement cst = cn.prepareCall("{call deletetask(?)}");
				cst.setInt(1, id);
				cst.execute();
				cn.close();
				response.sendRedirect("TasksManagement/ToDoLoader.jsp");
			} catch (Exception e) {
				System.err.println("delete servlete : " + e);
			}
		}

	}

}
