package getFiles;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.mySQL;

import javax.servlet.http.*;

@MultipartConfig(maxFileSize = 999999999)
@WebServlet("/filesUplodServlet")

public class filesUplod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("photo");
			Part fp = request.getPart("photo");
			InputStream is = null;
			if (fp != null) {
				long fs = fp.getSize();
				String fc = fp.getContentType();
				is = fp.getInputStream();
				Connection cn = mySQL.getConnection();
				PreparedStatement pt = cn.prepareStatement("insert into files values(?,?)");
				pt.setString(1, fc);
				pt.setBlob(2, is);
				int returnCode = pt.executeUpdate();
				if (returnCode == 0) {
					request.setAttribute("message", "error inserting file");
					getServletContext().getRequestDispatcher("/failure.jsp");
				} else {
					request.setAttribute("message", "insetng image sucessfull");
					getServletContext().getRequestDispatcher("/success.jsp");
				}
			}

		} catch (Exception e) {
			System.err.println(e);

		}
	}

}
