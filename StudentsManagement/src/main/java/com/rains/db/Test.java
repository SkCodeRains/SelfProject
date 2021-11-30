package com.rains.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import RainsTable.RainsTableCreator;
import oracle.jdbc.driver.OracleDriver;

public class Test {
	public static void main(String[] args) {
		Connection con;
		try {
			Driver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Rains", "sys as sysdba", "R007");
			while (true) {
				RainsTableCreator.excuteQuery(con,
						"SELECT username FROM v$session WHERE username IS NOT NULL ORDER BY username ASC");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
