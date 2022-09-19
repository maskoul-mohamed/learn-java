package app;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.impl.CategoryDAO;
import dao.impl.ProductDAO;
import model.Category;
import model.Product;

public class TestApp {
	private static DAO categoryDao;
	private static DAO productDao;
	public static void main(String[] args) {
		
		categoryDao = new CategoryDAO();
		Category category1 = new Category("New name", "New Description");
		categoryDao.add(category1);
		
		productDao = new ProductDAO();
		Product product = new Product("Product name", 55);
		productDao.add(product);
		
		
		/*Category c =  (Category) categoryDao.get(5l);
		System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());

		c.setName("Udd");
		c.setDescription("Updated sq");
		categoryDao.update(c, args);
		 c =  (Category) categoryDao.get(5l);

		System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());

		*/
		List<Category> ls = categoryDao.getAll();
		for(Category c : ls) {
			System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());
			//categoryDao.delete(c);
		}
		
		Product p1 = (Product) productDao.get(1l);
		productDao.delete(p1);
		List<Product> productsList = productDao.getAll();
		productsList.stream().forEach(p -> System.out.println(p.getId() + " " + p.getName() + " " + p.getQuantity()));
	/*	for(Product p : productsList) {
			System.out.println(p.getId() + " " + p.getName() + " " + p.getQuantity());
			//categoryDao.delete(c);
		}*/
		
		
	}

}
