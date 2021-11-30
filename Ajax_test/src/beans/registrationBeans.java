package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registrationBeans {
	String number, name, type, balance, status;

	public registrationBeans() {
		status = "false";
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBalance(String balance) {
		this.balance = balance;
		prosecc();
	}

	public String getStatus() {
		return status;
	}

	void prosecc() {
		try {
			Connection Cn = mySQL.getConnection();
			PreparedStatement pt = Cn.prepareStatement("insert into accounts values(?,?,?,?);");
			pt.setString(1, number);
			pt.setString(2, name);
			pt.setString(3, type);
			pt.setString(4, balance);
			int validate = pt.executeUpdate();
			if (validate == 1) {
				status = "true";
			}

		} catch (Exception e) {
			status = String.valueOf(e);
		}
	}

}
