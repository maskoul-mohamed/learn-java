package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.Category;
import util.DatabaseConnection;

public class CategoryDAO implements DAO<Category> {
	static Connection connection = DatabaseConnection.getConnection();

	@Override
	public Category get(long id) {
		Category category = null;

		try {
			String query = "SELECT * FROM categories WHERE id =?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				category = new Category();

				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
			}
			category.setId(id);
			
		} catch(SQLException e) {
			System.out.println("Error while getting a category\n" + e);
			
		}
		return category;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		try {
			String query = "SELECT * FROM categories";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
			}
			
		} catch(SQLException e) {
			System.out.println("Error while getting all categories\n" + e);

		}
		return categories;
	}



	@Override
	public void delete(Category category) {
		try {
			long id = category.getId();
			String query = "DELETE FROM categories WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Error while delete a category\n" + e);

		}
		
	}

	@Override
	public void update(Category category, String[] params) {
		try {
			String query = "UPDATE categories SET  name=?, description=? WHERE id=? ";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			ps.setLong(3, category.getId());
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Error while update a category\n" + e);

		}
		
	}

	@Override
	public int add(Category category) {
		
		try {
			String query = "INSERT INTO categories(name, description) VALUES(?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Error while add a new category\n" + e);
			return 0;
		}
	
	}


}
