package com.rains.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.rains.db.Oracledb;

public class Login {
	private String MailNumber, password, name, role;
	private int id, flag;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setMailNumber(String mailNumber) {
		MailNumber = mailNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean execute() {

		Connection connection = Oracledb.getInstance();
		try {
			Long.parseLong(MailNumber);
			flag = 1;
		} catch (NumberFormatException e) {
			flag = 2;
		}

		try {
			CallableStatement cst = connection.prepareCall("{call Login (?,?,?,?,?,?)}");
			cst.setString(1, MailNumber);
			cst.setString(2, password);
			cst.registerOutParameter(3, Types.VARCHAR);// fullname -
			cst.registerOutParameter(4, Types.INTEGER);// id
			cst.registerOutParameter(5, Types.VARCHAR);// role
			cst.setInt(6, flag);//
			cst.execute();
			name = cst.getString(3);
			id = cst.getInt(4);
			role = cst.getString(5);
			cst.close();
			return true;
		} catch (Exception e) {
			System.out.println("beans login : " + e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

}
