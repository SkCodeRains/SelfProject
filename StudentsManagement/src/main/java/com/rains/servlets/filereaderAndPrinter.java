package com.rains.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 999999999)
@WebServlet("/filereaderAndPrinter")
public class filereaderAndPrinter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public filereaderAndPrinter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Part fp = request.getPart("filesss");

			InputStream is = fp.getInputStream();

			response.setContentType("text/html");

			String contString = "";

			int i;

			while ((i = is.read()) != -1) {
				contString += ((char) i);
			}

			is.close();

			response.getWriter().print(contString);
		} catch (Exception e) {
			System.out.println("filereaderAndPrinter : " + e);
		}
	}

}
