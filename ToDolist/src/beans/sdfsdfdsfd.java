package beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class sdfsdfdsfd {

	public static void main(String[] args) {
		try {

			CallableStatement cst;
			Connection cn = Mysql.connection();
			cst = cn.prepareCall("{call getdata(?)}");
			cst.setInt(1, 2204);
			cst.execute();
			ResultSet rs = cst.getResultSet();
			while (rs.next()) {
				System.err.println("id  : " + rs.getString(1));
				System.err.println("task  : " + rs.getString(1));
			}
			rs.close();
			cst.getMoreResults();
			rs = cst.getResultSet();
			while (rs.next()) {
				System.err.println("id  : " + rs.getString(1));
				System.err.println("task  : " + rs.getString(1));
			}
			rs.close();
			cst.getMoreResults();
			rs = cst.getResultSet();
			while (rs.next()) {
				System.err.println("id  : " + rs.getString(1));
				System.err.println("task  : " + rs.getString(1));
			}

		} catch (Exception e) {

		}

	}
}
