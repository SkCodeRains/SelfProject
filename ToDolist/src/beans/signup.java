package beans;

import static beans.Mysql.*;
import java.sql.*;

public class signup {
	private String parameter, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7;
	Connection conn;
	PreparedStatement pst;
	CallableStatement cst;
	int userid;

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}

	public void setParameter4(String parameter4) {
		this.parameter4 = parameter4;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setParameter5(String parameter5) {
		this.parameter5 = parameter5;
	}

	public void setParameter6(String parameter6) {
		this.parameter6 = parameter6;
	}

	public void setParameter7(String parameter7) {
		this.parameter7 = parameter7;
	}

	public boolean getResult() {
		boolean z = false;
		try {
			conn = connection();
			int i = 0;
			cst = conn.prepareCall("{call addUsers(?,?,?,?,?,?,?,?)}");
			cst.setInt(++i, userid);
			cst.setString(++i, parameter);
			cst.setString(++i, parameter2);
			cst.setString(++i, parameter3);
			cst.setString(++i, parameter4);
			cst.setString(++i, parameter5);
			cst.setString(++i, parameter6);
			cst.setString(++i, parameter7);
			cst.executeUpdate();
			conn.close();
			z = true;
		} catch (Exception e) {
			System.err.println("signup page" + e);
		}
		return z;

	}
	

}
