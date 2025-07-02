package connection;

import java.sql.Connection;

public class testConnection {
	
	public static void main(String[] args) {
		
		Connection conn = DatabaseConnection.getConnection();
		System.out.println(conn);
	}
	
	

}
