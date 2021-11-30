package Beans;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class MySQL {
	static Connection Cn;

	public static Connection getdb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankOperations?user=root&password=R007");
		} catch (Exception e) {
			System.out.print(e);
		}
		return Cn;
	}
}
