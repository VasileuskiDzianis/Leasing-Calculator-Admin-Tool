package by.vls.admin.dao.settings.rate;

import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.BaseRate;

public class BaseRateDao extends CustomDao {

	public List<BaseRate> getBaseRate() throws DaoException {
		Session session = getSession();
		
		List<BaseRate> baseRateList;
		try {
			session.beginTransaction();
			baseRateList = session.createQuery("from BaseRate").getResultList();
		} catch (Exception e) {
			throw new DaoException("Base rate getting from DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return baseRateList;
	}

	public void updateBaseRate(List<BaseRate> baseRate) throws DaoException {
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (BaseRate baseRate2 : baseRate) {
				session.createQuery("update BaseRate set rate = :rate where currency = :currency ")
						.setParameter("rate", baseRate2.getRate()).setParameter("currency", baseRate2.getCurrency())
						.executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Base rate updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}