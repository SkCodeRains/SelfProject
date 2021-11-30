package getFiles;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import beans.mySQL;

/**
 * Servlet implementation class getFiles
 */
@WebServlet("/getFiles")
public class getFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (request.getParameter("id"));

		java.sql.Blob file = null;
		byte[] fileData = null;

		try {
			Connection conn = mySQL.getConnection();

			String sqlString = "SELECT * FROM files where id=1";
			Statement myStatement = conn.createStatement();

			ResultSet rs = myStatement.executeQuery(sqlString);

			while (rs.next()) {
				file = rs.getBlob("image");
				InputStream input = rs.getBinaryStream("image");
				fileData = file.getBytes(1, (int) file.length());
				OutputStream output = response.getOutputStream();
				response.setContentType("text/html");

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
