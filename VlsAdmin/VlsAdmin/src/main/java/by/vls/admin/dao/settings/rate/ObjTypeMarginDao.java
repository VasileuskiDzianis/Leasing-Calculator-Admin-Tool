package by.vls.admin.dao.settings.rate;
import java.util.List;

import org.hibernate.Session;

import by.vls.admin.dao.CustomDao;
import by.vls.admin.domain.settings.rate.AgeMarginBuildmach;
import by.vls.admin.domain.settings.rate.ObjTypeMargin;

public class ObjTypeMarginDao extends CustomDao{
	
	public List<ObjTypeMargin> getObjTypeMargin(){
	Session session = getSession();
	session.beginTransaction();
	List<ObjTypeMargin> objTypeMargin = session.createQuery("from ObjTypeMargin").getResultList();
	session.getTransaction().commit();
	if (session != null && session.isOpen()) {
		session.close();
	}
	return objTypeMargin;
	}
	
	public void updateObjTypeMargin(List<ObjTypeMargin> objTypeMargin){
		Session session = getSession();
		session.beginTransaction();
		for (ObjTypeMargin objTypeMargin2 : objTypeMargin) {
			session.createQuery("update ObjTypeMargin set objtypemargin = :objTypeMargin where objtype = :objType ")
			.setParameter("objTypeMargin", objTypeMargin2.getObjTypeMargin())
			.setParameter("objType", objTypeMargin2.getObjType())
			.executeUpdate();
		}
		
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
