package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository  {
	
	public Repository() {

	}
	
	public static void CreateDatabase() {
		String url = Url.getUrl();
		try(Connection conn = DriverManager.getConnection(url)) {
			DatabaseMetaData data = conn.getMetaData();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection Connection () {
		String url = Url.getUrl();
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
