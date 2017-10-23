package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.LastInstanceRecordDao;
import com.platenco.p2pCredit.model.LastInstanceRecord;
import com.platenco.p2pCredit.util.Logg;

public class LastInstanceRecordServiceImpl implements LastInstanceRecordDao {
	
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
	public void save(LastInstanceRecord lastInstanceRecord) throws Exception {
		Session session = getSession();
		try{
			lastInstanceRecord.setCreateDate(new Timestamp(new Date().getTime()));
			lastInstanceRecord.setUpdateDate(lastInstanceRecord.getCreateDate());
			session.save(lastInstanceRecord);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存终审记录出错");
		}

	}

	@Override
	public void saveOrUpdate(LastInstanceRecord lastInstanceRecord)
			throws Exception {
		Session session = getSession();
		try{
			lastInstanceRecord.setUpdateDate(new Timestamp(new Date().getTime()));
			session.saveOrUpdate(lastInstanceRecord);
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新终审记录出错");
		}
	}

}
