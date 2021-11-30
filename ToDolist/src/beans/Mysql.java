package beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {
	public static Connection connection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskManager", "root", "R007");
		} catch (Exception e) {
			System.out.println(e);
		}
		return cn;
	}

}
