package com.platenco.p2pCredit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.config.TxNamespaceHandler;

import com.platenco.p2pCredit.dao.StoreBusinessDataDao;
import com.platenco.p2pCredit.model.StoreBusinessData;
import com.platenco.p2pCredit.util.Logg;

public class StoreBusinessDataServiceImpl implements StoreBusinessDataDao {
	
	private SessionFactory sessionFactory;
	
	private List<StoreBusinessData> storeBusinessDataList;
	private Map<String, StoreBusinessData>  storeBusinessDataMap;

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
	public void save(StoreBusinessData storeBusinessData) throws Exception {
		Session session = getSession();
		try{
			storeBusinessData.setCreateDate(new Timestamp(new Date().getTime()));
			session.save(storeBusinessData);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存分店营业数据出错");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreBusinessData getForStoreIdAndDataCycle(Integer storeId,
			String dataCycle) throws Exception {
		Session session = getSession();
		try{
			List<StoreBusinessData> storeBusinessDatas= (List<StoreBusinessData>)session.createQuery
					("from StoreBusinessData r where r.storeId="+storeId+" and r.dataCycle="+dataCycle).list();
			if(storeBusinessDatas != null && storeBusinessDatas.isEmpty() != true){
				return storeBusinessDatas.get(0);
			}else{
				return null;
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据storeId和dataCycle查询分店营业数据出错");
		}
	}

	@Override
	public void update(StoreBusinessData storeBusinessData) throws Exception {
		Session session = getSession();
		try{
			session.update(storeBusinessData);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新分店营业数据出错");
		}
		
	}

	@Override
	public void load(StoreBusinessData storeBusinessData) throws Exception {
		StoreBusinessData myData = getForStoreIdAndDataCycle(storeBusinessData.getStoreId(), storeBusinessData.getDataCycle());
		if(myData != null){
			storeBusinessData.setDataId(myData.getDataId());
			//getSession().clear();
			//update(storeBusinessData);
		}else{
			save(storeBusinessData);
		}
	}
	
	
	private String getDataCycle(int blockId, int totalDataBlock, int startYear){
		if(blockId<0 || blockId>=totalDataBlock){
			Logg.writeErrorLog("blockId("+blockId+")不正确");
			return null;
		}else{
			int year = startYear + blockId/13;
			int month = (blockId!=(totalDataBlock-1))?(blockId+1)%13:0;
			return (year + String.format("%02d", month));
		}
	}

	@Override
	public void batchLoad(int totalDataBlock, int startYear, int storeId, String[] fields)
			throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//Logg.writeDebugLog("事务开始");
		try{			
			for(int i=0; i<totalDataBlock; i++){
				int pos = i*5+4;
				StoreBusinessData storeBusinessData = new StoreBusinessData();
				storeBusinessData.setDataCycle( getDataCycle(i, totalDataBlock, startYear) );
			
				if("-".equals(fields[pos])){
					storeBusinessData.setTtv((long)-1);
				}else{
					storeBusinessData.setTtv(Math.round(Double.parseDouble(fields[pos])));
				}
				if("-".equals(fields[pos+1])){
					storeBusinessData.setOperatingIncome((long)-1);
				}else{
					storeBusinessData.setOperatingIncome(Math.round(Double.parseDouble(fields[pos+1])));
				}
				if("-".equals(fields[pos+2])){
					storeBusinessData.setOpenRoomRate("-1");
				}else{
					int rate = (int)(Double.parseDouble(fields[pos+2])*100);
					storeBusinessData.setOpenRoomRate(rate+"%");
				}
				if("-".equals(fields[pos+3])){
					storeBusinessData.setOpenRooms(-1);
				}else{
					storeBusinessData.setOpenRooms(Integer.parseInt(fields[pos+3]));
				}
				if("-".equals(fields[pos+4])){
					storeBusinessData.setRooms(-1);
				}else{
					storeBusinessData.setRooms(Integer.parseInt(fields[pos+4]));
				}

				storeBusinessData.setStoreId(storeId);
				storeBusinessData.setCreateDate(new Timestamp(new Date().getTime()));
				//StoreBusinessData myData = getForStoreIdAndDataCycle(storeBusinessData.getStoreId(), storeBusinessData.getDataCycle());
				if( !checkInList(storeBusinessData)){
					session.save(storeBusinessData);
				}else{
					if(storeBusinessData.getDataId() != 0){
						Logg.writeDebugLog("需要更新数据");
						session.update(storeBusinessData);
					}
				}
			}
			//Logg.writeDebugLog("事务提交前");
			tx.commit();
			//Logg.writeDebugLog("事务提交后");
		}catch(Exception e){
			tx.rollback();
			Logg.writeException(e);
			throw new Exception("批量插入StoreBusinessData表出错");
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getAll() throws Exception {
		Session session = getSession();
		storeBusinessDataMap = new HashMap<String, StoreBusinessData>();
	
		try{
			storeBusinessDataList= (List<StoreBusinessData>)session.createQuery("from StoreBusinessData").list();
			for(int i=0; i<storeBusinessDataList.size(); i++){
				String keyString = String.format("%05d", storeBusinessDataList.get(i).getStoreId())+storeBusinessDataList.get(i).getDataCycle();
				
				storeBusinessDataMap.put(keyString, storeBusinessDataList.get(i));
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("查询所有分店营业数据进内存出错");
		}
	}
	
	private Boolean checkInList(StoreBusinessData storeBusinessData) throws Exception {
		String keyString = String.format("%05d", storeBusinessData.getStoreId())+storeBusinessData.getDataCycle();
		StoreBusinessData myStoreBusinessData = storeBusinessDataMap.get(keyString);
		if(myStoreBusinessData == null){
			//Logg.writeDebugLog("没找到记录,key="+keyString);
			return false;
		}else{
			//Logg.writeDebugLog("找到记录,key="+keyString);
			if( myStoreBusinessData.compare(storeBusinessData) ){
				storeBusinessData.setDataId((long)0);
			}else{
				storeBusinessData.setDataId(myStoreBusinessData.getDataId());
			}
			return true;
		}
	}

}
