package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.common.StatusCode;
import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.util.Logg;

public class ReqBaseDataServiceImpl implements ReqBaseDataDao, StatusCode {
	
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
	public Boolean save(ReqBaseData reqBaseData) throws Exception {
		Session session = getSession();
		try{
			ReqBaseData myReqBaseData = getForCustIdAndStatus(reqBaseData.getCustId(), THROUGH_LAST_INSTANCE);
			if(myReqBaseData != null){
				//if(myReqBaseData.getStatus() == UNSUBMITTED){ 
					//update(myReqBaseData);
				//}else{
					Logg.writeErrorLog("一个客户只能存在一条少于状态'"+THROUGH_LAST_INSTANCE+"'的记录");
					return false;
				//}
			}else{
				reqBaseData.setCreateDate(new Timestamp(new Date().getTime()));
				reqBaseData.setUpdateDate(reqBaseData.getCreateDate());
				session.save(reqBaseData);
			}
			return true;
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存申请基本资料出错");
		}

	}

	@Override
	public void update(ReqBaseData reqBaseData) throws Exception {
		Session session = getSession();
		try{
			reqBaseData.setUpdateDate(new Timestamp(new Date().getTime()));
			session.update(reqBaseData);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新申请基本资料出错");
		}finally{
		}
		
	}

	@Override
	public ReqBaseData get(int recordId) throws Exception {
		Session session = getSession();
		try{
			return (ReqBaseData) session.get(ReqBaseData.class, recordId);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据recordId查询申请基本资料出错");
		}
	}

	@Override
	public void delete(int recordId) throws Exception {
		Session session = getSession();
		try{
			ReqBaseData reqBaseData = (ReqBaseData) session.get(ReqBaseData.class, recordId);
			session.delete(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据recordId删除申请基本资料出错");
		}
		
	}

	@Override
	public ReqBaseData getForCustId(int custId) throws Exception {
		Session session = getSession();
		try{
			List<ReqBaseData> reqBaseDataList = (List<ReqBaseData>)session.createQuery("from ReqBaseData r where r.custId="+custId+" order by updateDate desc").list();
			if(reqBaseDataList.isEmpty() == false){
				return reqBaseDataList.get(0);
			}
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据custId查询申请基本资料出错");
		}
		return null;
	}

	@Override
	public ReqBaseData getForCustIdAndStatus(int custId, int status) throws Exception {
		Session session = getSession();
		try{
			List<ReqBaseData> reqBaseDataList = (List<ReqBaseData>)session.createQuery("from ReqBaseData r where r.custId="+custId+" and status<"+status+" order by status asc").list();
			if(reqBaseDataList.isEmpty() == false){
				return reqBaseDataList.get(0);
			}
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据custId和status查询申请基本资料出错");
		}
		return null;
	}

}
