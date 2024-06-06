package JDBCExample.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepository {
	static Connection conn = null;
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bsm69", "root", "mscs@0407");
		return conn;
		
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}

	

}
