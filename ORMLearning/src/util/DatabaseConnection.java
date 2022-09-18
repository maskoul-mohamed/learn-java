package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseConnection {
	private static Connection connection = null;
	
	static {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql;//localhost:3306/catalogue";
		String username = "root";
		String password = "root";
		Properties connectionProps = new Properties();
		InputStream iStream = null;
		
		
			iStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("util/database.properties");
			try {
				connectionProps.load(iStream);
				driver = connectionProps.getProperty("database.driver");
				url = connectionProps.getProperty("database.url");
				username = connectionProps.getProperty("database.username");
				password = connectionProps.getProperty("database.password");
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	}
	
	
	
	public Connection getConnection() {
		return this.connection;
	}
}
