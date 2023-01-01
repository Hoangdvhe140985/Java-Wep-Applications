package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
	private static DBConnection instance;
	private Connection connection;

	private DBConnection() {
		Properties properties = new Properties();
		try {
			properties.load(DBConnection.class.getResourceAsStream("/dbConfig.properties"));

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DBConnection getIntansce() throws SQLException {
		if(instance == null || instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		
		return instance;
	}
	
    public static void closeConnection(ResultSet rs, PreparedStatement pre, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (pre != null && !pre.isClosed()) {
        	pre.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
	
	public static void main(String args[]) {
		DBConnection test = new DBConnection();
		System.out.println(test.getConnection());
	}
}
