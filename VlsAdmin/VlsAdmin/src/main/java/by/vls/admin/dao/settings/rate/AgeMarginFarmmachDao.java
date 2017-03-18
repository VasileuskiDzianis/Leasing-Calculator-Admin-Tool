package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginFarmmach;

public class AgeMarginFarmmachDao extends CustomDao{
	
	public List<AgeMarginFarmmach> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginFarmmach> objAgeMarginFarmmach = session.createQuery("from AgeMarginFarmmach").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginFarmmach;
	}
}

