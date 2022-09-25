package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Utilitaire {
	  private static Connection conn;

	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/e_commerce", "root", "");
	        } catch (Exception e) {
	            System.out.println("Problème de connexion !!\n"+e);

	            e.printStackTrace();
	        }

	    }
	
	
	public static Connection getConnection() {
		return conn;
	}
}
