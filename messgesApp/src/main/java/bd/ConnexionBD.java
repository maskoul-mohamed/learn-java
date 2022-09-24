package bd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionBD {
	private Connection connexion;
	private Statement instruction;
	protected ResultSet résultat;

	public ConnexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/messagerie"
					 ,"root", "");
			instruction = connexion.createStatement();
		} catch (ClassNotFoundException ex) {
			System.err.println("Problème de pilote");
		} catch (SQLException ex) {
			System.err.println("Base de données non trouvée ou requête incorrecte");
		}
	}

	public void lire(String requête) {
		try {
			résultat = instruction.executeQuery(requête);
		} catch (SQLException ex) {
			System.err.println("Requête incorrecte " + requête);
		}
	}

	public void miseAJour(String requête) {
		try {
			instruction.executeUpdate(requête);
		} catch (SQLException ex) {
			System.err.println("Requête incorrecte " + requête);
		}
	}

	public boolean suivant() {
		try {
			return résultat.next();
		} catch (SQLException ex) {
			return false;
		}
	}

	public void arrêt() { 
		try { 
			connexion.close(); 
			} catch (SQLException ex) { 
			System.err.println("Erreur sur l'arrêt de la connexion à la base de données"); 
		} 
	}
}
