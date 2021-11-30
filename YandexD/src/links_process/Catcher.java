package links_process;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Beans.mySQL;

/**
 * Servlet implementation class Catcher
 */
@WebServlet("/Catcher")
public class Catcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Catcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean i = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String links = request.getParameter("links");
			System.out.println(links);
			Connection Cn = mySQL.getConnection();
			PreparedStatement pt = Cn.prepareStatement("insert into links values(?)");
			pt.setString(1, links);
			pt.executeUpdate();
			i = true;
		} catch (Exception e) {
			out.print(e);
		}
		if (i) {
			out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<script>setTimeout(function(){\r\n" + "window.close();\r\n" + "},500);\r\n" + "</script>\r\n"
					+ "</body>\r\n" + "</html>");
		} else {
			out.print("\n\nerror");
		}
	}

}
