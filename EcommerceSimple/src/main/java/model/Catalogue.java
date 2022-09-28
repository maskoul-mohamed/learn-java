package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
	
	public ArrayList<Categorie> selectAllCategories(){
		String query = "SELECT * FROM categories";
		return selectCategories(query);
	}
	
	public ArrayList<Categorie> selectByKeyword(String keyword){
		String query = "SELECT * FROM categories  where NomCategorie like  '%" + keyword + "%'";
		return selectCategories(query);
	}
	private ArrayList<Categorie> selectCategories(String requete) {
		try {
			PreparedStatement ps = connection.prepareStatement(requete);
			ResultSet rs = ps.executeQuery();
			ArrayList<Categorie> ls = new ArrayList<Categorie>();
			while(rs.next()) {
				Categorie cate = new Categorie();
				cate.setIdCat(rs.getLong(1));
				cate.setTitre(rs.getString("NomCategorie"));
				cate.setDescription(rs.getString("Description"));
				ls.add(cate);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Categorie selectOneCategorie(int idCat) {
		String query = "SELECT * FROM categories WHERE idCategorie = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, idCat);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Categorie categorie = new Categorie();
			
			categorie.setIdCat(rs.getLong("1"));
			categorie.setTitre("NomCategorie");
			categorie.setDescription("Description");
			return categorie;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
    public static void main(String[] args) {
        Catalogue catal = new Catalogue();
 
  
        catal.addCategorie("test", "Desc");
        
    }
}
