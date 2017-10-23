package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.FirstInstanceRecordDao;
import com.platenco.p2pCredit.model.FirstInstanceRecord;
import com.platenco.p2pCredit.util.Logg;

public class FirstInstanceRecordServiceImpl implements FirstInstanceRecordDao {
	
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
	public Boolean save(FirstInstanceRecord firstInstanceRecord) throws Exception {
		Session session = getSession();
		try{
			firstInstanceRecord.setCreateDate(new Timestamp(new Date().getTime()));
			firstInstanceRecord.setUpdateDate(firstInstanceRecord.getCreateDate());
			session.save(firstInstanceRecord);
			return true;
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存初审记录出错");
		}

	}

	@Override
	public Boolean saveOrUpdate(FirstInstanceRecord firstInstanceRecord)
			throws Exception {
		Session session = getSession();
		try{
			firstInstanceRecord.setUpdateDate(new Timestamp(new Date().getTime()));
			session.saveOrUpdate(firstInstanceRecord);
			return true;
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新初审记录出错");
		}
	}

}
