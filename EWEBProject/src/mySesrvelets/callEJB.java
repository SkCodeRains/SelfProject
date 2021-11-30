package mySesrvelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myEJBs.calculator;

/**
 * Servlet implementation class callEJB
 */
@WebServlet("/callEJB")
public class callEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	calculator obj;

	public callEJB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/htlm");
		double amount = Double.parseDouble(request.getParameter("amt"));
		double discaount = obj.calcDiscount(amount);
		out.print("the amount is  :  " + discaount);
	}

}
