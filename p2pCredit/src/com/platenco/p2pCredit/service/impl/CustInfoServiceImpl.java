package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.CustInfoDao;
import com.platenco.p2pCredit.model.CustInfo;
import com.platenco.p2pCredit.util.Logg;


public class CustInfoServiceImpl implements CustInfoDao {
	
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
	public void save(CustInfo custInfo) throws Exception {
		Session session = getSession();
		try{
			custInfo.setCreateDate(new Timestamp(new Date().getTime()));
			custInfo.setUpdateDate(custInfo.getCreateDate());
			session.save(custInfo);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存客户基础资料出错");
		}

	}

	@Override
	public void update(CustInfo custInfo) throws Exception {
		Session session = getSession();
		try{
			custInfo.setUpdateDate(new Timestamp(new Date().getTime()));
			session.update(custInfo);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新客户基础资料出错");
		}
	}

	@Override
	public CustInfo get(int custId) throws Exception {
		Session session = getSession();
		try{
			return (CustInfo) session.get(CustInfo.class, custId);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过custId查询客户基础资料出错");
		}
	}

	@Override
	public void delete(int custId) throws Exception {
		Session session = getSession();
		try{
			CustInfo custInfo = (CustInfo) session.get(CustInfo.class, custId);
			session.delete(custInfo);
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("删除客户基础资料出错");
		}
		
	}

	

	@Override
	public CustInfo getForUserId(String userId) throws Exception {
		Session session = getSession();
		try{
			List<CustInfo> custInfos = 
					(List<CustInfo>) session.createQuery("from CustInfo c where c.userId='"+userId+"' order by c.updateDate desc").list();
			if(custInfos != null && custInfos.isEmpty() != true){				
				return (CustInfo)custInfos.get(0);
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过userId查询客户基础资料出错");
		}
		return null;
	}

	

	@Override
	public CustInfo getForPhoneNoOrIdCard(String phoneNo, String IdCard) throws Exception {
		Session session = getSession();
		try{
			List<CustInfo> custInfos = 
					(List<CustInfo>) session.createQuery("from CustInfo c where c.phoneNo='"+phoneNo+"' or c.idCardNo='"+IdCard+"'").list();
			if(custInfos != null && custInfos.isEmpty() != true){
				
				return custInfos.get(0);
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过phoneNo或IdCard查询客户基础资料出错");
		}
		return null;
	}
	
	//-------------------业务相关-------------------------------------------
	@Override
	public Boolean saveForInfo(CustInfo custInfo) throws Exception {
		try{
			CustInfo cInfo = getForPhoneNoOrIdCard(custInfo.getPhoneNo(), custInfo.getIdCardNo());
			if(cInfo == null){			
				save(custInfo);
				return true;
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("查重后保存客户基础资料出错");
		}
		return false;
	}
	
	@Override
	public CustInfo getForInfo(CustInfo custInfo) throws Exception {
		try{
			if(custInfo.getCustId() != null && custInfo.getCustId() != 0){
				return get(custInfo.getCustId());
			}else if(custInfo.getUserId() != null && "".equals(custInfo.getUserId()) == false){
				return getForUserId(custInfo.getUserId());
			}else if("".equals(custInfo.getPhoneNo()) == false || "".equals(custInfo.getIdCardNo()) == false){
				return getForPhoneNoOrIdCard(custInfo.getPhoneNo(), custInfo.getIdCardNo());
			}
			
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("通过多种条件查询客户基础资料出错");
		}
		return null;
	}

}
