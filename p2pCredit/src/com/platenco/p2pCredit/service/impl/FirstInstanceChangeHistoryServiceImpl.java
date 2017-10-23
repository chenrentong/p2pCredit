package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.FirstInstanceChangeHistoryDao;
import com.platenco.p2pCredit.model.FirstInstanceChangeHistory;
import com.platenco.p2pCredit.util.Logg;

public class FirstInstanceChangeHistoryServiceImpl implements
		FirstInstanceChangeHistoryDao {
	
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
	public void save(FirstInstanceChangeHistory firstInstanceChangeHistory)
			throws Exception {
		Session session = getSession();
		try{
			firstInstanceChangeHistory.setCreateDate(new Timestamp(new Date().getTime()));
			session.save(firstInstanceChangeHistory);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存初审变更历史记录出错");
		}

	}

}
