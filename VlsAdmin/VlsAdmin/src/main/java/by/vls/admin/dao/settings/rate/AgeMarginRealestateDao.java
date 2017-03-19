package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
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
	
	public void updateAgeMargin(List<AgeMarginRealestate> ageMarginRealestateList){
		Session session = getSession();
		session.beginTransaction();
		for (AgeMarginRealestate ageMarginRealestate : ageMarginRealestateList) {
			session.createQuery("update AgeMarginRealestate set margin_realest = :rate where age = :age ")
			.setParameter("rate", ageMarginRealestate.getMarginRealest())
			.setParameter("age", ageMarginRealestate.getAge())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

