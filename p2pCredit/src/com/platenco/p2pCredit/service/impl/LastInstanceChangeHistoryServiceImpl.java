package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.LastInstanceChangeHistoryDao;
import com.platenco.p2pCredit.model.LastInstanceChangeHistory;
import com.platenco.p2pCredit.util.Logg;

public class LastInstanceChangeHistoryServiceImpl implements
		LastInstanceChangeHistoryDao {
	
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
	public void save(LastInstanceChangeHistory lastInstanceChangeHistory)
			throws Exception {
		Session session = getSession();
		try{
			lastInstanceChangeHistory.setCreateDate(new Timestamp(new Date().getTime()));
			session.save(lastInstanceChangeHistory);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存终审变更历史记录出错");
		}

	}

}
