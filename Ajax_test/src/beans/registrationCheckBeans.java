package beans;

import java.sql.*;

public class registrationCheckBeans {
	String status;
	String accno;

	public registrationCheckBeans() {
		status = "false";
		accno = "null";
	}

	public String getStatus() {
		return status;
	}

	public void setAccno(String accno) {
		this.accno = accno;
		Check();
	}

	void Check() {
		try {
			Connection Cn = mySQL.getConnection();
			PreparedStatement Pt = Cn.prepareStatement("select * from accounts where accno=?");
			Pt.setString(1, accno);
			ResultSet rt = Pt.executeQuery();
			if (rt.next()) {
				status = "false";
			} else {
				status = "true";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
