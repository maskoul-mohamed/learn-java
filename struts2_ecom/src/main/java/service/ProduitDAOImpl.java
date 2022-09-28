package service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProduitDAO;
import model.Produit;
import util.HibernateUtil;

public class ProduitDAOImpl implements ProduitDAO {
	private static final Logger logger = Logger.getLogger(CategorieDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory\n" + e);
		}
	} 
	
	@Override
	public boolean addProduit(Produit produit) {
		Session  session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(produit);
			session.getTransaction().commit();
			logger.info("Produit saved successfully, Produit Details="+produit);
			return true;
			
		}catch (Exception e) {
			System.out.println("Error while adding categorie\n"+e);
			return false;
		}
	}

	@Override
	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> listProduits() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Produit> produitList = session.createQuery("FROM Produit").list();
		session.getTransaction().commit();
		return produitList;
	}

	@Override
	public List<Produit> selectCatByKeyword(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProduit(int id) {
		// TODO Auto-generated method stub
		
	}

}
