package com.rains.db;

import java.sql.Connection;
import java.util.GregorianCalendar;

public class Oracledb {
	@SuppressWarnings("unused")
	private static Connection con;

	public static Connection getInstance() {
//		try {
//			if (con == null || con.isClosed()) {
//				Driver drvier = new oracle.jdbc.OracleDriver();
//				DriverManager.registerDriver(drvier);
//				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Rains", "advlab", "zuber");
//			}
//		} catch (Exception e) {
//			System.out.println("Oracledb : " + e);
//		}

		long start = new GregorianCalendar().getTimeInMillis();
		con = Pool.getPool();
		long end = new GregorianCalendar().getTimeInMillis();
		System.out.println("\n\n\nConnection Object take time :: " + (end - start) + " ::   \n\n\n");
		return con;
	}

	public static void setNull() {
		con = null;
	}

}
