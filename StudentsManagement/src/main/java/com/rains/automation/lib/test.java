package com.rains.automation.lib;

import java.sql.CallableStatement;
import static com.rains.db.Oracledb.getInstance;;

public class test {

	public static void main(String[] args) {
		try {
			CallableStatement cst = getInstance().prepareCall("{call TESTDATE(?)}");
			cst.setString(1, "1997-01-01");
			cst.execute();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
