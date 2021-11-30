package servletes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Mysql;
import beans.validation;

@WebServlet("/MoveData")
public class MoveData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (validation.validate(request)) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				String fromto = request.getParameter("fromto"), forto = (request.getParameter("forto"));
				Connection cn = Mysql.connection();
				CallableStatement cst = cn.prepareCall("{call movedata(?,?,?)}");
				cst.setInt(1, id);
				cst.setString(2, fromto);
				cst.setString(3, forto);
				cst.executeUpdate();
				cn.close();
			} catch (Exception e) {
				System.out.print("MoveData  " + e);
			}
		}
	}

}
