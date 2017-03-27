package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginCar;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;

public class AgeMarginEquipDao extends CustomDao{
	
	public List<AgeMarginEquip> getAgeMargin() throws DaoException{
	Session session = getSession();
	
	List<AgeMarginEquip> objAgeMarginEquip;
	try {
		session.beginTransaction();
		objAgeMarginEquip = session.createQuery("from AgeMarginEquip").getResultList();
	} catch (Exception e) {
		throw new DaoException("Age margin equip getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginEquip;
	}
	
	public void updateAgeMargin(List<AgeMarginEquip> ageMarginEquipList) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginEquip ageMarginEquip : ageMarginEquipList) {
				session.createQuery("update AgeMarginEquip set margin_equip = :rate where age = :age ")
						.setParameter("rate", ageMarginEquip.getMarginEquip())
						.setParameter("age", ageMarginEquip.getAge()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin equip updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

