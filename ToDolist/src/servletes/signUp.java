package servletes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.Random;
import beans.sessions;
import beans.signup;

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		signup obj = new signup();
		int id = Random.getID();
		obj.setUserid(id);
		obj.setParameter(request.getParameter("fisrtname"));
		obj.setParameter2(request.getParameter("lastname"));
		obj.setParameter3(request.getParameter("middlename"));
		obj.setParameter4(request.getParameter("username"));
		obj.setParameter5(request.getParameter("password"));
		obj.setParameter6(request.getParameter("email"));
		obj.setParameter7(request.getParameter("DOB"));
		if (obj.getResult()) {
			sessions.setsession(request, response, String.valueOf(id));
			response.sendRedirect("TasksManagement/index.jsp");
		} else {
			doGet(request, response);
		}

	}

}
