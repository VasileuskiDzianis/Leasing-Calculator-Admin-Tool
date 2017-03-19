package by.vls.admin.dao.settings.rate;

import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.BaseRate;

public class BaseRateDao extends CustomDao {

	public List<BaseRate> getBaseRate() {
		Session session = getSession();
		session.beginTransaction();
		List<BaseRate> baseRateList = session.createQuery("from BaseRate").getResultList();
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return baseRateList;
	}

	public void updateBaseRate(List<BaseRate> baseRate) {
		Session session = getSession();
		session.beginTransaction();
		for (BaseRate baseRate2 : baseRate) {
			session.createQuery("update BaseRate set rate = :rate where currency = :currency ")
					.setParameter("rate", baseRate2.getRate()).setParameter("currency", baseRate2.getCurrency())
					.executeUpdate();
		}

		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}