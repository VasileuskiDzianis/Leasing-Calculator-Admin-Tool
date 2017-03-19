package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginCar;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;

public class AgeMarginEquipDao extends CustomDao{
	
	public List<AgeMarginEquip> getAgeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<AgeMarginEquip> objAgeMarginEquip = session.createQuery("from AgeMarginEquip").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginEquip;
	}
	
	public void updateAgeMargin(List<AgeMarginEquip> ageMarginEquipList){
		Session session = getSession();
		session.beginTransaction();
		for (AgeMarginEquip ageMarginEquip : ageMarginEquipList) {
			session.createQuery("update AgeMarginEquip set margin_equip = :rate where age = :age ")
			.setParameter("rate", ageMarginEquip.getMarginEquip())
			.setParameter("age", ageMarginEquip.getAge())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

