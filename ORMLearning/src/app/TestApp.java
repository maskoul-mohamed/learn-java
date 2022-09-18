package app;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.impl.CategoryDAO;
import model.Category;

public class TestApp {
	private static DAO categoryDao;
	public static void main(String[] args) {
		
		categoryDao = new CategoryDAO();
		Category category1 = new Category("New name", "New Description");
		//categoryDao.add(category1);
		Category c =  (Category) categoryDao.get(5l);
		System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());

		c.setName("Udd");
		c.setDescription("Updated sq");
		categoryDao.update(c, args);
		 c =  (Category) categoryDao.get(5l);

		System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());

		
	/*	List<Category> ls = categoryDao.getAll();
		for(Category c : ls) {
			System.out.println(c.getId() + " " + c.getName() + " " + c.getDescription());
			//categoryDao.delete(c);
		}
		
		*/
	}

}
