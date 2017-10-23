package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.NationWideStoresDao;
import com.platenco.p2pCredit.model.NationWideStores;
import com.platenco.p2pCredit.util.Logg;

public class NationWideStoresServiceImpl implements NationWideStoresDao {
	
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
	public void save(NationWideStores nationWideStores) throws Exception {
		Session session = getSession();
		try{
			nationWideStores.setCreateDate(new Timestamp(new Date().getTime()));
			session.save(nationWideStores);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存全国分店信息出错");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public NationWideStores getForStoreCode(String storeCode) throws Exception {
		Session session = getSession();
		try{
			List<NationWideStores> stores= (List<NationWideStores>)session.createQuery
					("from NationWideStores r where r.storeCode="+storeCode).list();
			if(stores != null && stores.isEmpty() != true){
				return stores.get(0);
			}else{
				return null;
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据storeCode查询全国分店信息出错");
		}
	}

	@Override
	public void update(NationWideStores nationWideStores) throws Exception {
		Session session = getSession();
		try{
			session.update(nationWideStores);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新全国分店信息出错");
		}
		
	}

	/**
	 * 业务相关操作
	 * 
	 */
	@Override
	public void load(NationWideStores nationWideStores) throws Exception {
		NationWideStores myStores = getForStoreCode(nationWideStores.getStoreCode());
		if(myStores != null){
			nationWideStores.setStoreId(myStores.getStoreId());
			//getSession().clear();
			//update(nationWideStores);
		}else{
			save(nationWideStores);
		}
		
	}

}
