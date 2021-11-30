package Beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class mySQL {
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.cj.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/downloads", "root", "R007");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
