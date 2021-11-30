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

@WebFilter({ "/LoginUp", "/Login.jsp", "/SignUp.jsp", "/Register" })
public class LoginUp implements Filter {
	public LoginUp() {
	}

	public void destroy() {
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
			if (!Validation.verify(request2))
				chain.doFilter(request, response);
			else {
				if (role.equals("STUDENT"))
					response2.sendRedirect(request2.getContextPath() + "/Main.jsp");
				else if (role.equals("ADMIN"))
					response2.sendRedirect(request2.getContextPath() + "/Admin.jsp");
			}
		} catch (Exception e) {
			System.out.println("Filter LoginUp : " + e);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
