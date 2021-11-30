package com.rains.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.util.DateGenrator;

@MultipartConfig(maxFileSize = 999999999)
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		com.rains.beans.Register reg = new com.rains.beans.Register();
		reg.setFname(request.getParameter("fname"));
		reg.setLname(request.getParameter("mname"));
		reg.setSurname(request.getParameter("lname"));
		reg.setEmail(request.getParameter("email"));
		reg.setPassword(request.getParameter("password"));
		reg.setGender(request.getParameter("gender"));
		reg.setPhoneNumber(request.getParameter("phone"));
		reg.setStdClass(request.getParameter("class"));
		reg.setIs(request.getPart("photo").getInputStream());
		reg.setDOB(DateGenrator.generate(request.getParameter("dob")));
		if (reg.execute(request, response)) {
			response.sendRedirect(request.getContextPath() + "/Main.jsp");
		}

	}

}
