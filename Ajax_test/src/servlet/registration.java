package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.registrationBeans;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String no, nm, ty, ba;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registration() {
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
		no = request.getParameter("n");
		nm = request.getParameter("m");
		ty = request.getParameter("t");
		ba = request.getParameter("b");
		registrationBeans obj = new registrationBeans();
		obj.setNumber(no);
		obj.setName(nm);
		obj.setType(ty);
		obj.setBalance(ba);
		PrintWriter out = response.getWriter();
		out.print(obj.getStatus());                                  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
