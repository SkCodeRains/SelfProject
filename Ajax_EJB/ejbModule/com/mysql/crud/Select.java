package com.mysql.crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import beans.mySQL;

/**
 * Session Bean implementation class Select
 */
@Stateless(mappedName = "All")
@LocalBean
public class Select implements SelectLocal {
	ResultSet rs;

	/**
	 * Default constructor.
	 */
	public Select() {

	}

	public ResultSet data(String id) {
		try {
			Connection cn;
			cn = mySQL.getConnection();
			CallableStatement cst;
			if (id.equalsIgnoreCase("all")) {
				cst = cn.prepareCall("{call Accounts()}");
			} else {
				cst = cn.prepareCall("{call searchAccount(" + id + ")}");
			}
			rs = cst.executeQuery();
		} catch (Exception e) {
			System.out.print(e);
		}
		return rs;
	}
}