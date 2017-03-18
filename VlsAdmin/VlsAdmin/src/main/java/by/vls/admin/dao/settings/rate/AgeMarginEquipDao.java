package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
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
}

