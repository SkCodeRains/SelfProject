package com.rains.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.security.Validation;

/**
 * Servlet Filter implementation class MainAdmin
 */
@WebFilter({ "/Main", "/Main.jsp" })
public class Main implements Filter {

	/**
	 * Default constructor.
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest request2 = (HttpServletRequest) request;
			HttpServletResponse response2 = (HttpServletResponse) response;
			String role = String.valueOf(request2.getSession().getAttribute("userRole"));
			if (Validation.verify(request2) && role.equals("STUDENT"))
				chain.doFilter(request, response);
			else {
				response2.sendRedirect(request2.getContextPath() + "/Login.jsp");
			}
		} catch (Exception e) {
			System.out.println("Filter MainAdmin : " + e);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
