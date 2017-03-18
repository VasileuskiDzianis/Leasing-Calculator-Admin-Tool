package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginTruck;

public class AgeMarginTruckDao extends CustomDao{
	
	public List<AgeMarginTruck> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginTruck> objAgeMarginTruck = session.createQuery("from AgeMarginTruck").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginTruck;
	}
}

