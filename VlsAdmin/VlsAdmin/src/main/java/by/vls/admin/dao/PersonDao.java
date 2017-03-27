package by.vls.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import by.vls.admin.domain.Person;

public class PersonDao {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public List<Person> getAllPersons() {

		return null;
	}

	public List<Person> getPersonsWithHigherIncome(int income) throws DaoException {
		
		Session session;
		try 
		{
		   session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    session = sessionFactory.openSession();
		    
		}
		
		try {
		return session.createQuery("from Person where monthlyIncome >= :income")
				.setParameter("income", income).list();
		}
		catch (Exception e) {
			throw new DaoException("Couldn't get person from DB", e);	
		}
	}

}
