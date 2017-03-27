package by.vls.admin.dao.settings.rate;

import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginEquip;
import by.vls.admin.domain.settings.rate.AgeMarginRealestate;

public class AgeMarginRealestateDao extends CustomDao {

	public List<AgeMarginRealestate> getAgeMargin() throws DaoException {
		Session session = getSession();
		
		List<AgeMarginRealestate> objAgeMarginRealestate;
		try {
			session.beginTransaction();
			objAgeMarginRealestate = session.createQuery("from AgeMarginRealestate").getResultList();
		} catch (Exception e) {
			throw new DaoException("Age margin realestate getting from DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return objAgeMarginRealestate;
	}

	public void updateAgeMargin(List<AgeMarginRealestate> ageMarginRealestateList) throws DaoException {
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginRealestate ageMarginRealestate : ageMarginRealestateList) {
				session.createQuery("update AgeMarginRealestate set margin_realest = :rate where age = :age ")
						.setParameter("rate", ageMarginRealestate.getMarginRealest())
						.setParameter("age", ageMarginRealestate.getAge()).executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoException("Age margin realestate updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
