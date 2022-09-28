package service;

import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class Test {

	public static void main(String[] args) {
		CategoryDAO catDAO = new CategoryDAOImpl();
		List<Category> lesCateg;
		Category uneCategorie;
		lesCateg= catDAO.selectAllCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
		
		uneCategorie = new Category();
		uneCategorie.setNomCategorie("Nouvelle Categorie");
		uneCategorie.setDescription("Nouvelle Categorie");
		catDAO.addCategory(uneCategorie);
		
		lesCateg= catDAO.selectAllCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
		
		//uneCategorie = catDAO.getCategoryById(2);
		uneCategorie.setDescription("Boitier Tower Big or Slim");
		//catDAO.updateCategory(uneCategorie);
		
		lesCateg= catDAO.selectAllCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
	}

}
