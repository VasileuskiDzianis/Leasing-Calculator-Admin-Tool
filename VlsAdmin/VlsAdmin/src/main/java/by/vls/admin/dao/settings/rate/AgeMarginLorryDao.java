package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
import by.vls.admin.domain.settings.rate.AgeMarginLorry;

public class AgeMarginLorryDao extends CustomDao{
	
	public List<AgeMarginLorry> getAgeMargin() throws DaoException{
	Session session = getSession();
	
	List<AgeMarginLorry> objAgeMarginLorry;
	try {
		session.beginTransaction();
		objAgeMarginLorry = session.createQuery("from AgeMarginLorry").getResultList();
	} catch (Exception e) {
		throw new DaoException("Age margin lorry getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginLorry;
	}
	
	public void updateAgeMargin(List<AgeMarginLorry> ageMarginLorryList) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginLorry ageMarginLorry : ageMarginLorryList) {
				session.createQuery("update AgeMarginLorry set margin_lorry = :rate where age = :age ")
						.setParameter("rate", ageMarginLorry.getMarginLorry())
						.setParameter("age", ageMarginLorry.getAge()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin lorry updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

