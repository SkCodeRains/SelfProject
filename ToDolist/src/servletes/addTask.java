package servletes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Mysql;
import beans.Random;
import beans.encID;
import beans.validation;

@WebServlet("/addTask")
public class addTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (validation.validate(request)) {
			try {
				Connection cn = Mysql.connection();
				HttpSession session = request.getSession();
				CallableStatement cst = cn.prepareCall("{call addTask(?,?)}");
				int id = Random.getID();
				cst.setInt(1, id);
				cst.setString(2, encID.decrypt(String.valueOf(session.getAttribute("uid"))));
				int a = cst.executeUpdate();
				if (a > 0) {
					cn.close();
					response.sendRedirect("TasksManagement/ToDoLoader.jsp");
				}

			} catch (Exception e) {
				System.out.print("add servelete t :  " + e);
				doGet(request, response);
			}
		}
	}
}
