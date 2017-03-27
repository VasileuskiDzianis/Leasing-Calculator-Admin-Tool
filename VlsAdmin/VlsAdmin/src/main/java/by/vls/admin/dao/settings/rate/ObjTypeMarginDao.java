package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.dao.DaoException;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;
import by.vls.admin.domain.settings.rate.ObjTypeMargin;

public class ObjTypeMarginDao extends CustomDao{
	
	public List<ObjTypeMargin> getObjTypeMargin() throws DaoException{
	Session session = getSession();
	
	List<ObjTypeMargin> objTypeMargin;
	try {
		session.beginTransaction();
		objTypeMargin = session.createQuery("from ObjTypeMargin").getResultList();
	} catch (Exception e) {
		throw new DaoException("Object type margin getting from DB error", e);
	}
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objTypeMargin;
	}
	
	public void updateObjTypeMargin(List<ObjTypeMargin> objTypeMargin) throws DaoException{
		Session session = getSession();
		
		try {
			session.beginTransaction();
			for (ObjTypeMargin objTypeMargin2 : objTypeMargin) {
				session.createQuery("update ObjTypeMargin set objtypemargin = :objTypeMargin where objtype = :objType ")
						.setParameter("objTypeMargin", objTypeMargin2.getObjTypeMargin())
						.setParameter("objType", objTypeMargin2.getObjType()).executeUpdate();
			} 
		} catch (Exception e) {
			throw new DaoException("Object type margin updating in DB error", e);
		}
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
