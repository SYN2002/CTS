package MainCode.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	private static final String db_url="jdbc:mysql://localhost:3306/COGNIZANT";
	private static final String username="cognizant";
	private static final String password="password";
	
	public static Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(db_url,username,password);
		return conn;
	}
}
