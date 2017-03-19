package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
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
	
	public void updateAgeMargin(List<AgeMarginFarmmach> ageMarginFarmmachList){
		Session session = getSession();
		session.beginTransaction();
		for (AgeMarginFarmmach ageMarginFarmmach : ageMarginFarmmachList) {
			session.createQuery("update AgeMarginFarmmach set margin_farm = :rate where age = :age ")
			.setParameter("rate", ageMarginFarmmach.getMarginFarmmach())
			.setParameter("age", ageMarginFarmmach.getAge())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

