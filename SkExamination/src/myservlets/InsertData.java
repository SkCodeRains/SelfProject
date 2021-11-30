package myservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q, a1, a2, a3, a4, ta;
		q = request.getParameter("question");
		a1 = request.getParameter("a1");
		a2 = request.getParameter("a2");
		a3 = request.getParameter("a3");
		a4 = request.getParameter("a4");
		ta = request.getParameter("trueAnswer");

		Connection Cn = Mysql.GetConnection();
		try {
			for (int i=0;i<100;i++) {
				PreparedStatement Pt = Cn.prepareStatement("insert Into Queans values(?,?,?,?,?,?)");
				Pt.setString(1, q+i);
				Pt.setString(2, a1);
				Pt.setString(3, a2);
				Pt.setString(4, a3);
				Pt.setString(5, a4);
				Pt.setString(6, ta);			
				Pt.executeUpdate();
			}

		} catch (Exception e) {
			// 
		}

	}

}
