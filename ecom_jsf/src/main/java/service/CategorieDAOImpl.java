package service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CategorieDAO;
import model.Categorie;
import util.HibernateUtil;

public class CategorieDAOImpl implements CategorieDAO, Serializable {
	private static final long serialVersionUID = -9046694894084413226L;

	private static final Logger logger = Logger.getLogger(CategorieDAOImpl.class.getName());

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
	public void addCategorie(Categorie categorie) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(categorie);
		transaction.commit();
		session.close();
		logger.info("Categorie saved successfully, Categorie Details=" + categorie);

	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(categorie);
		transaction.commit();
		session.close();
		logger.info("Categorie updated successfully, Categorie Details="+categorie);

	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> listCategories() {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Categorie> listCategorie = session.createQuery("from Categorie").list();
		transaction.commit();
		session.close();
		return listCategorie;
	}

	@Override
	public List<Categorie> selectCatByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorieById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCategorie(int id) {
		// TODO Auto-generated method stub

	}

}
