package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;




import com.platenco.p2pCredit.dao.ReqLoanOtherDao;
import com.platenco.p2pCredit.model.ReqLoanOther;
import com.platenco.p2pCredit.util.Logg;

public class ReqLoanOtherServiceImpl implements ReqLoanOtherDao {
	
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
	public Boolean save(ReqLoanOther reqLoanOther) throws Exception {
		Session session = getSession();
		try{
			reqLoanOther.setCreateDate(new Timestamp(new Date().getTime()));
			reqLoanOther.setUpdateDate(reqLoanOther.getCreateDate());
			session.save(reqLoanOther);
			return true;
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存其它信贷资料出错");
		}

	}

	@Override
	public ReqLoanOther get(Long otherRecordId) throws Exception {
		Session session = getSession();
		try{
			return (ReqLoanOther) session.get(ReqLoanOther.class, otherRecordId);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过otherRecordId查询其它信贷资料出错");
		}
	}

	@Override
	public List<ReqLoanOther> getForRecordId(Long recordId) throws Exception {
		Session session = getSession();
		try{
			List<ReqLoanOther> reqLoanOthers = (List<ReqLoanOther>)session.createQuery("from ReqLoanOther c where c.recordId="+recordId).list();   
			return reqLoanOthers;
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过recordId查询其它信贷资料出错");
		}
	}

	@Override
	public void update(ReqLoanOther reqLoanOther) throws Exception {
		Session session = getSession();
		try{
			session.update(reqLoanOther);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新其它信贷资料出错");
		}
		
	}

}
