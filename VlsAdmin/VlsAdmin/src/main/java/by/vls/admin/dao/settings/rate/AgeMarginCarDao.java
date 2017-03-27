package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;
import by.vls.admin.domain.settings.rate.AgeMarginCar;

public class AgeMarginCarDao extends CustomDao{
	
	public List<AgeMarginCar> getAgeMargin() throws DaoException{
	Session session = getSession();
	
	List<AgeMarginCar> objAgeMarginCar;
	try {
		session.beginTransaction();
		objAgeMarginCar = session.createQuery("from AgeMarginCar").getResultList();
	} catch (Exception e) {
		throw new DaoException("Age margin car getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginCar;
	}
	
	public void updateAgeMargin(List<AgeMarginCar> ageMarginCarList) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginCar ageMarginCar : ageMarginCarList) {
				session.createQuery("update AgeMarginCar set margin_car = :rate where age = :age ")
						.setParameter("rate", ageMarginCar.getMarginCar()).setParameter("age", ageMarginCar.getAge())
						.executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin car updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

