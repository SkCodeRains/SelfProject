package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		String nm, id, ps, gn, mo, em, psk, sq, as;
		PrintWriter out = response.getWriter();

		nm = request.getParameter("cnm");
		id = request.getParameter("cid");
		ps = request.getParameter("psw");
		gn = request.getParameter("gen");
		mo = request.getParameter("mob");
		em = request.getParameter("eml");
		psk = request.getParameter("passkey");
		sq = request.getParameter("seq");
		as = request.getParameter("ans");

		Connection con;
		PreparedStatement pst;

		try {

			con = Mysql.GetConnection();

			pst = con.prepareStatement("insert into candiinfo values(?,?,?,?,?,?,?,?,default,default);");
			pst.setString(1, nm);
			pst.setString(2, id);
			pst.setString(3, ps);
			pst.setString(4, gn);
			pst.setString(5, mo);
			pst.setString(6, em);
			pst.setString(7, sq);
			pst.setString(8, as);

			pst.executeUpdate();

			pst = con.prepareStatement("Create Table " + id
					+ " (question varchar(300) not null primary key,Answer varchar(300))");
			pst.execute();

			out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n"
					+ "<body><h1>Data Inserted Successfully....</h1>");
			out.println(" <br><a href=Login.jsp>Back to Login..</a>");

			con.close();

		} catch (Exception e) {
			out.println(e);
		}

	}

}
