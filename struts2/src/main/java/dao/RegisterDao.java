package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class RegisterDao {
	public static int saveUser(User u){  
        
		Session session=new Configuration().  
		configure("hibernate.cfg.xml").buildSessionFactory().openSession();  
		          
		Transaction t=session.beginTransaction();  
		int i=(Integer)session.save(u);  
		t.commit();  
		session.close();  
		          
		return i;  
		  
		}  
}
