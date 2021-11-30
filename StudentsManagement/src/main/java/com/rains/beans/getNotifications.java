package com.rains.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.http.HttpServletRequest;

import com.rains.db.Oracledb;

public class getNotifications {
	static int total;

	public static int getTotal(HttpServletRequest request) {
		genrateTotal(request);
		return total;
	}

	private static void genrateTotal(HttpServletRequest request) {
		Connection connection = Oracledb.getInstance();
		try {
			// getting notifications and sids and name
			CallableStatement cst = connection.prepareCall("{call getnotification(?,?,?)}");
			cst.registerOutParameter(1, Types.INTEGER); // setting for total counts notifications
			cst.registerOutParameter(2, Types.REF_CURSOR); // setting for result object of sidss and name
			cst.setInt(3, Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")))); // setting
																											// admin
																											// sidss for
																											// validation
			cst.execute();
			total = cst.getInt(1);
			cst.close();

		} catch (Exception e) {
			System.out.println("getNotifications : " + e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
