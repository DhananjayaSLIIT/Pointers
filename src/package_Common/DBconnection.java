package package_Common;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;


public class DBconnection {

	static String dbURL = "jdbc:mysql://localhost:3306/pointers";
	static String username = "root";
	static String password = "";
	
	
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{

		
		try {
			
			conn = (Connection) DriverManager.getConnection(dbURL,username,password);
			
		}catch(SQLException sqle) {
			
			sqle.printStackTrace();
		}

		
		return conn;	
	}
	
	
	
	
}
