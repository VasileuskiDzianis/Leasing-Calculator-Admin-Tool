package by.vls.admin.dao;

import java.util.ArrayList;
import java.util.List;

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

	public List<Person> getPersonsWithHigherIncome(int income) {
		Session session;
		try 
		{
		   session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    session = sessionFactory.openSession();
		}
		
		return session.createQuery("from Person where monthlyIncome >=?")
				.setParameter(0, income).list();
	}

}
