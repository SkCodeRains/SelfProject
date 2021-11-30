package com.rains.util;

import java.sql.ResultSet;
import java.sql.Statement;

import com.rains.db.Oracledb;

import RainsTable.RainsTableCreator;

public class tesfsdfd {

	public static void main(String[] args) {
		try {
			Statement st = Oracledb.getInstance().createStatement();
			ResultSet rs = st
					.executeQuery("SELECT * FROM v$session WHERE username IS NOT NULL  ORDER BY username ASC;");
			RainsTableCreator.printResultsets(rs);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
