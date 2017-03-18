package by.vls.admin.dao.settings.rate;

import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;

public class AgeMarginBuildmachDao extends CustomDao {

	public List<AgeMarginBuildmach> getAgeMargin() {
		Session session = getSession();
		session.beginTransaction();
		List<AgeMarginBuildmach> objAgeMarginBuildmach = session.createQuery("from AgeMarginBuildmach").getResultList();
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return objAgeMarginBuildmach;
	}
}
