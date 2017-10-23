package com.platenco.p2pCredit.service.impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.SDRoleDao;
import com.platenco.p2pCredit.model.SDRole;
import com.platenco.p2pCredit.util.Logg;


public class SDRoleServiceImpl implements SDRoleDao {
	
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}


	@Override
	public void save(SDRole role) {
		Session session = getSession();
		try{
			session.save(role);
		}
		catch(RuntimeException e){
			Logg.writeException(e);
			e.printStackTrace();
		}finally{
		}

	}



	@Override
	public SDRole get(int roleId) {
		Session session = getSession();
		try{
			SDRole role = (SDRole)session.get(SDRole.class, roleId);
			return role;
		}
		catch(RuntimeException e){
			Logg.writeException(e);
			e.printStackTrace();
		}
		finally{
		}
		return null;
	}



	@Override
	public void update(SDRole role) {
	}

}
