package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTestExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//URL= jdbc:mysql: // server-name: server-port / database-name
		//instead of local host we can put IP address
		//open the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bsm69", "root", "mscs@0407");
		
		//issue the query
		PreparedStatement ps = conn.prepareStatement("select * from employee");
		
		//execute the query
		ResultSet rs = ps.executeQuery();
		
		//fetch the record
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			Float salary = rs.getFloat(4);
			System.out.println("id= " + id +", name= "+name + ", email= " + email + ", salary= " + salary);
		}
		conn.close();
		

	}

}
