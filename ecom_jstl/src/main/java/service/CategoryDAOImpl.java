package service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.CategoryDAO;
import model.Category;
import util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO{
	
	private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();
	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	} 
	@Override
	public void addCategory(Category category) {

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		logger.info("Categorie saved successfully, Categorie Details="+category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> selectAllCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Category> CategoriesList = session.createQuery("from Category").list();
		session.getTransaction().commit();
		
		return CategoriesList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> selectCateByKeyword(String keyword) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Category> CategoriesList = session.createQuery("from Category c WHERE c.nomCategorie LIKE '%"+keyword+"%'").list();
		session.getTransaction().commit();
		
		return CategoriesList;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

}
