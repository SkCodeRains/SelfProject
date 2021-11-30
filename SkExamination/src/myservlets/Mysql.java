package myservlets;

import java.sql.*;

import javax.swing.JOptionPane;

public class Mysql {

	static Connection Cn;

	public static Connection GetConnection() {
		JOptionPane.showMessageDialog(null, "success");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Change Password For Portnes
			Cn = DriverManager.getConnection("JDBC:mysql://localhost:3306/makexamdb", "root", "R007");
			return Cn;
		} catch (Exception e) {

		}
		return null;
	}
}
