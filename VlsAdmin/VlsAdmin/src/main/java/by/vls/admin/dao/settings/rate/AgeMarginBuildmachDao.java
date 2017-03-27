package by.vls.admin.dao.settings.rate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;

public class AgeMarginBuildmachDao extends CustomDao {
	
	public List<AgeMarginBuildmach> getAgeMargin() throws DaoException {
		Session session = getSession();
		
		List<AgeMarginBuildmach> objAgeMarginBuildmach;
		try {
			session.beginTransaction();
			objAgeMarginBuildmach = session.createQuery("from AgeMarginBuildmach").getResultList();
		} catch (Exception e) {
			throw new DaoException("Age margin building machin getting from DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return objAgeMarginBuildmach;
	}
	public void updateAgeMargin(List<AgeMarginBuildmach> ageMarginBuildmachList) throws DaoException{
		Session session;
		session = getSession();
		
		try {
			session.beginTransaction();
			for (AgeMarginBuildmach ageMarginBuildmach : ageMarginBuildmachList) {
				session.createQuery("update AgeMarginBuildmach set margin_buildmach = :rate where age = :age ")
						.setParameter("rate", ageMarginBuildmach.getMarginBuildmach())
						.setParameter("age", ageMarginBuildmach.getAge()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Age margin buildmach updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
