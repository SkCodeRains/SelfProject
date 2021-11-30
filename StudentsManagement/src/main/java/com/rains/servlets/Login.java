package com.rains.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.security.Validation;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		com.rains.beans.Login obj = new com.rains.beans.Login();
		obj.setMailNumber(request.getParameter("userID"));
		obj.setPassword(request.getParameter("password"));
		if (obj.execute()) {
			Validation.register(request, response, obj.getName(), obj.getId(), obj.getRole());
			if (obj.getRole().equals("STUDENT"))
				response.sendRedirect(request.getContextPath() + "/Main.jsp");
			else if (obj.getRole().equals("ADMIN"))
				response.sendRedirect(request.getContextPath() + "/Admin.jsp");
		} else
			response.sendRedirect(request.getContextPath() + "/Invalid.jsp");

	}

}
