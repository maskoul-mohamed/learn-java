package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public List<Category> selectAllCategories();
	public List<Category> selectCateByKeyword(String keyword);
	public Category getCategoryById(int id);
	public void deleteCategory(int id);
}
