package beans;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class validation {
	public static boolean validate(HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			Cookie[] cock = req.getCookies();
			for (Cookie cookie : cock) {
				if (cookie.getName().equals("uid")) {
					if (cookie.getValue().equals(session.getAttribute("uid"))) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

	public static void discard() {

	}

}