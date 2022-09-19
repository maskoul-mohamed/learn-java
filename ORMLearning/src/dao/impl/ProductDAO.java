package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.Product;
import util.DatabaseConnection;

public class ProductDAO implements DAO<Product> {
	static Connection cnx = DatabaseConnection.getConnection(); 

	@Override
	public Product get(long id) {
		Product product = null;
		try {
			String query = "SELECT * FROM products WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getLong("id"));
				product.setQuantity(rs.getInt("quantity"));
			}
			
		} catch(SQLException e) {
			System.out.println("Error while get a product\n" + e);
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> productsList = new ArrayList();
		try {
			String query = "SELECT * FROM products";
			PreparedStatement ps = cnx.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				productsList.add(product);
			}
		} catch(SQLException e) {
			System.out.println("Error while getting all the products\n" + e);

		}
		return productsList;
	}

	@Override
	public int add(Product product) {
		try {
			String query = "INSERT INTO products(name, quantity) VALUES(?,?)";
			PreparedStatement ps = cnx.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getQuantity());
			return ps.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("Error while add a new product\n" + e);
			return 0;
		}
		
	}

	@Override
	public void delete(Product product) {
		try {
			String query = "DELETE FROM products WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(query);
			ps.setLong(1, product.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Error while delete a product\n" + e);
		}
		
	}

	@Override
	public void update(Product product, String[] params) {
		// TODO Auto-generated method stub
		
	}

	
}
