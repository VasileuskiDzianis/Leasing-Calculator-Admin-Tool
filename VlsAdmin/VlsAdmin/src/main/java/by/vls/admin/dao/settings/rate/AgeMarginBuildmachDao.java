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
	public void updateAgeMargin(List<AgeMarginBuildmach> ageMarginBuildmachList){
		Session session = getSession();
		session.beginTransaction();
		for (AgeMarginBuildmach ageMarginBuildmach : ageMarginBuildmachList) {
			session.createQuery("update AgeMarginBuildmach set margin_buildmach = :rate where age = :age ")
			.setParameter("rate", ageMarginBuildmach.getMarginBuildmach())
			.setParameter("age", ageMarginBuildmach.getAge())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
