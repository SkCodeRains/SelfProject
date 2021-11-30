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

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (validation.validate(request)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String fromto = request.getParameter("fromto"), data = request.getParameter("data");
			try {
				Connection cn = Mysql.connection();
				CallableStatement cst = cn.prepareCall("{call UpdateTask(?,?,?)}");
				cst.setInt(1, id);
				cst.setString(2, data);
				cst.setString(3, fromto);
				cst.execute();
				cn.close();
				response.sendRedirect("TasksManagement/ToDoLoader.jsp");
			} catch (Exception e) {
				System.out.println("updatadata servlete : " + e);
			}

		}
	}

}
