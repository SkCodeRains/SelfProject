package beans;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class mySQL {
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/soham", "root", "R007");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Warrning", JOptionPane.WARNING_MESSAGE);
		}
		return con;
	}
}
