package com.rains.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rains.db.Oracledb;

public class Validation {

	public static String getRole(HttpServletRequest request) {
		return String.valueOf(request.getSession().getAttribute("userRole"));
	}

	public static boolean verify(HttpServletRequest request) {
		boolean flag = false;
		try {
			Cookie c[] = request.getCookies();
			HttpSession session = request.getSession();

			for (Cookie co : c) {
				if (!((String.valueOf(co.getName())).equals("JSESSIONID"))) {
					String ses = String.valueOf(session.getAttribute(co.getName()));
					String coo = String.valueOf(co.getValue());
					if (!ses.equals(coo)) {
						flag = false;
						break;
					} else {
						String status = getStatus(request);
						if (!status.equals("REJECTED"))
							flag = true;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("validation verify : " + e);
		}

		return flag;
	}

	public static void register(HttpServletRequest request, HttpServletResponse response, String fullname, int i,
			String role) {
		try {
			Cookie c = new Cookie("userName", fullname);
			Cookie c1 = new Cookie("userId", String.valueOf(i));
			Cookie c2 = new Cookie("userRole", role);
			response.addCookie(c);
			response.addCookie(c1);
			response.addCookie(c2);
			HttpSession session = request.getSession();
			session.setAttribute("userName", fullname);
			session.setAttribute("userId", i);
			session.setAttribute("userRole", role);

		} catch (Exception e) {
			System.out.println("validate register : " + e);

		}
	}

	public static String getStatus(HttpServletRequest request) {
		String status = "Rejected";
		Connection connection = Oracledb.getInstance();
		try {
			PreparedStatement pst = connection.prepareStatement("select statuss from students where sids=?");
			pst.setInt(1, Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
			ResultSet rs = pst.executeQuery();
			rs.next();
			status = rs.getString(1);
			pst.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("validation GetStatus : " + e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}
}
