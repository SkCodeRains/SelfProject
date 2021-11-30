package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Validate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id, ps, psk;
		PrintWriter out = response.getWriter();

		id = request.getParameter("cid");
		ps = request.getParameter("psw");
		psk = request.getParameter("pk");

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		try {
			con = Mysql.GetConnection();
			pst = con.prepareStatement("select * from candiinfo where cid=? and pswd=? and passkey=?;");
			pst.setString(1, id);
			pst.setString(2, ps);
			pst.setString(3, psk);

			rs = pst.executeQuery();

			if (rs.next()) {
				if (rs.getString("type").equalsIgnoreCase("candidate")) {
					HttpSession ses = request.getSession(true);
					ses.setAttribute("cname", id);
					response.sendRedirect("Instruction.jsp");
				} else if (rs.getString("type").equalsIgnoreCase("Done")) {

					HttpSession ses = request.getSession(true);
					ses.setAttribute("cname", id);
					response.sendRedirect("Result.jsp");
				}
			} else {
				out.print("You Have Already Given Exam!!!....");
			}
		} catch (Exception e) {
			out.println(e);
		}

	}

}
