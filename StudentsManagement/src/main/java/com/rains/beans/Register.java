package com.rains.beans;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rains.db.Oracledb;
import com.rains.security.Validation;

public class Register {

	private String fname, lname, surname, email, password, phoneNumber, gender, stdClass, DOB;
	private InputStream is;

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setStdClass(String stdClass) {
		this.stdClass = stdClass;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		Connection connection = Oracledb.getInstance();
		try {
			CallableStatement cst = connection.prepareCall("{call register(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, fname);
			cst.setString(2, lname);
			cst.setString(3, surname);
			cst.setString(4, phoneNumber);
			cst.setString(5, email);
			cst.setString(6, password);
			cst.setString(7, gender);
			cst.setBlob(8, is);
			cst.setString(9, stdClass);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);// ID
			cst.setString(11, "NULL ");// role
			cst.registerOutParameter(12, Types.INTEGER);// success
			cst.registerOutParameter(13, Types.LONGVARCHAR);// name
			cst.setString(14, DOB);
			cst.execute();
			int results = cst.getInt(12);
			if (results == 1) {
				Validation.register(request, response, cst.getString(13), cst.getInt(10), "STUDENT");
				return true;
			}

			cst.close();
		} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
			try {
				response.getWriter().print("Dublicates founds ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Error from Execute");
			e.printStackTrace();

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
