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

import Beans.mySQL;

@WebServlet("/downloader")
public class downloader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public downloader() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean i = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String links = request.getParameter("links");
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
			out.print("error");
		}

	}

}
