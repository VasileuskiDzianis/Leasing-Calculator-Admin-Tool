package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
import by.vls.admin.domain.settings.rate.AgeMarginTruck;

public class AgeMarginTruckDao extends CustomDao{
	
	public List<AgeMarginTruck> getAgeMargin() throws DaoException{
	Session session = getSession();
	
	List<AgeMarginTruck> objAgeMarginTruck;
	try {
		session.beginTransaction();
		objAgeMarginTruck = session.createQuery("from AgeMarginTruck").getResultList();
	} catch (Exception e) {
		throw new DaoException("Age margin truck getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginTruck;
	}
	
	public void updateAgeMargin(List<AgeMarginTruck> ageMarginTruckList) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginTruck ageMarginTruck : ageMarginTruckList) {
				session.createQuery("update AgeMarginTruck set margin_truck = :rate where age = :age ")
						.setParameter("rate", ageMarginTruck.getMarginTruck())
						.setParameter("age", ageMarginTruck.getAge()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin truck updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

