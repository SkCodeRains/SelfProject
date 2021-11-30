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
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import beans.mySQL;

/**
 * Servlet implementation class upload
 */
@MultipartConfig(maxFileSize = 1073741824)
@WebServlet("/uploadsss")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public upload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.print(request.getPart("file"));
			Part filePart = request.getPart("file");
			InputStream is = null;
			if (filePart != null) {
				long fileSize = filePart.getSize();
				String fileContent = filePart.getContentType();
				is = filePart.getInputStream();
			}
			
			Connection cn=mySQL.getConnection();
			PreparedStatement pt=cn.prepareStatement("insert into files (image) values(?);");
			pt.setBlob(1, is);
			int returCode=pt.executeUpdate();
			if(returCode!=0) {
				response.sendRedirect("showing.jsp");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
