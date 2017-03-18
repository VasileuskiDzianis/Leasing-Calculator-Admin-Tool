package by.vls.admin.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class CustomDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
		Session session;
		try 
		{
		   session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    session = sessionFactory.openSession();
		}
		return session;
	}

}
