package beans;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class sessions {

	public static void setsession(HttpServletRequest request, HttpServletResponse response, String getid) {
		try {
			HttpSession session = request.getSession();
			String enid = encID.encrypt(getid);
			session.setAttribute("uid", enid);
			Cookie cock = new Cookie("uid", enid);
			response.addCookie(cock);
		} catch (Exception e) {
			System.err.println("error setSessions\n" + e);
		}
	}

}
