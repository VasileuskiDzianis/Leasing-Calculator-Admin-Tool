package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginLorry;

public class AgeMarginLorryDao extends CustomDao{
	
	public List<AgeMarginLorry> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginLorry> objAgeMarginLorry = session.createQuery("from AgeMarginLorry").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginLorry;
	}
}

