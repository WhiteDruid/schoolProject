package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository  {
	
	public Repository() {

	}
	
	public static void CreateDatabase(String filename) {
		String url = "jdbc:sqlite:C:/sqlite/db/" + filename;
		try(Connection conn = DriverManager.getConnection(url)) {
			DatabaseMetaData data = conn.getMetaData();
			System.out.println("\n" + data.getDriverName() + " created data base " + data.getDriverVersion());
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection Connection (String filename) {
		String url = "jdbc:sqlite:C:/sqlite/db/" + filename;
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("we connected");
		} catch(SQLException e) {
			e.getSQLState();
		}
		return conn;
	}
	
	public static void Close(Connection Connection) {
		try {
			Connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
