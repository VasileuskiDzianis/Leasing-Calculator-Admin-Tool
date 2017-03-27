package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
import by.vls.admin.domain.settings.rate.AgeMarginFarmmach;

public class AgeMarginFarmmachDao extends CustomDao{
	
	public List<AgeMarginFarmmach> getAgeMargin() throws DaoException{
	Session session = getSession();
	
	List<AgeMarginFarmmach> objAgeMarginFarmmach;
	try {
		session.beginTransaction();
		objAgeMarginFarmmach = session.createQuery("from AgeMarginFarmmach").getResultList();
	} catch (Exception e) {
		throw new DaoException("Age margin farmmach getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objAgeMarginFarmmach;
	}
	
	public void updateAgeMargin(List<AgeMarginFarmmach> ageMarginFarmmachList) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginFarmmach ageMarginFarmmach : ageMarginFarmmachList) {
				session.createQuery("update AgeMarginFarmmach set margin_farm = :rate where age = :age ")
						.setParameter("rate", ageMarginFarmmach.getMarginFarmmach())
						.setParameter("age", ageMarginFarmmach.getAge()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin farmmach updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}

