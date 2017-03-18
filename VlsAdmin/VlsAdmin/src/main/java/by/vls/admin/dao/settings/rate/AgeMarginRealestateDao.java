package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginRealestate;

public class AgeMarginRealestateDao extends CustomDao{
	
	public List<AgeMarginRealestate> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginRealestate> objAgeMarginRealestate = session.createQuery("from AgeMarginRealestate").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginRealestate;
	}
}

