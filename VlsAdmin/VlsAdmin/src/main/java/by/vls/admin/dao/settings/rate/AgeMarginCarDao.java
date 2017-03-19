package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;
import by.vls.admin.domain.settings.rate.AgeMarginCar;

public class AgeMarginCarDao extends CustomDao{
	
	public List<AgeMarginCar> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginCar> objAgeMarginCar = session.createQuery("from AgeMarginCar").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginCar;
	}
	
	public void updateAgeMargin(List<AgeMarginCar> ageMarginCarList){
		Session session = getSession();
		session.beginTransaction();
		for (AgeMarginCar ageMarginCar : ageMarginCarList) {
			session.createQuery("update AgeMarginCar set margin_car = :rate where age = :age ")
			.setParameter("rate", ageMarginCar.getMarginCar())
			.setParameter("age", ageMarginCar.getAge())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

