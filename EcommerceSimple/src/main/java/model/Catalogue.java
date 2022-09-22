package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class Catalogue {
	static Connection connection = Utilitaire.getConnection();

	public Catalogue() {
		
	}
	
	public void addCategorie(String titre, String description) {
		
		String query = "INSERT INTO categories(NomCategorie, Description) VALUES(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titre);
			ps.setString(2, description);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCategorie(long id) {
		String query = "DELETE FROM categories WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private ArrayList<Categorie> selectCategories(String requete) {
		Connection conn = Uti
		return null;
		
	}
	
    public static void main(String[] args) {
        Catalogue catal = new Catalogue();
 
  
        catal.addCategorie("test", "Desc");
        
    }
}
