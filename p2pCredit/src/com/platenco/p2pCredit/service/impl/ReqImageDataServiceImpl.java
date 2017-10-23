package com.platenco.p2pCredit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.dao.ReqImageDataDao;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.model.ReqImageData;
import com.platenco.p2pCredit.util.FileControl;
import com.platenco.p2pCredit.util.Logg;

/**
 * 
   * @author tsh
   * 2016年9月29日 下午3:06:29
 */
public class ReqImageDataServiceImpl implements ReqImageDataDao {
	
	
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
	
	private ReqBaseDataDao reqBaseDataDao;
	
	

	public ReqBaseDataDao getReqBaseDataDao() {
		return reqBaseDataDao;
	}

	public void setReqBaseDataDao(ReqBaseDataDao reqBaseDataDao) {
		this.reqBaseDataDao = reqBaseDataDao;
	}

	@Override
	public void save(ReqImageData reqImageData) throws Exception {
		Session session = getSession();
		try{
			reqImageData.setCreateDate(new Timestamp(new Date().getTime()));
			reqImageData.setUpdateDate(reqImageData.getCreateDate());
			session.save(reqImageData);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("保存影像文件信息出错");
		}

	}
	
	
	@Override
	public Boolean update(ReqImageData reqImageData) throws Exception {
		Session session = getSession();
		try{
			reqImageData.setUpdateDate(new Timestamp(new Date().getTime()));
			session.update(reqImageData);
			return true;
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("更新影像文件信息出错");
		}
	}
	
	@Override
	public ReqImageData getForInfo(ReqImageData reqImageData) throws Exception {
		Session session = getSession();
		try{
			List<ReqImageData> reqImageDatas= (List<ReqImageData>)session.createQuery
					("from ReqImageData r where r.recordId="+reqImageData.getRecordId()+
							"and r.imagePath='"+reqImageData.getImagePath()+"' and r.imageName='"+
							reqImageData.getImageName()+"'").list();
			if(reqImageDatas != null && reqImageDatas.isEmpty() != true){
				return reqImageDatas.get(0);
			}else{
				return null;
			}
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据recordId,imagePath,imageName查询影像文件信息出错");
		}
		
	}
	
	@Override
	public ReqImageData get(Long imageId) throws Exception {
		Session session = getSession();
		try{
			return (ReqImageData) session.get(ReqImageData.class, imageId);
		}
		catch(Exception e){
			Logg.writeException(e);
			throw new Exception("根据imageId查询图像记录信息出错");
		}
	}

	
	//--------------业务相关--------------------
	//解析文件名，获取相关信息
	public ReqImageData parseFileName(String fileName, String localPath) throws Exception {
		String custPath = "";
		ReqImageData reqImageData = new ReqImageData();
		try{
			String[] nameList = fileName.split("_"); 
			if(nameList.length >= 3){
				reqImageData.setRecordId(Long.parseLong(nameList[0]));
				reqImageData.setImageType(Integer.parseInt(nameList[1]));
				reqImageData.setImageName(nameList[2]);
			}else{
				Logg.writeErrorLog("文件格式不正确:"+fileName);
				return null;
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(reqImageData.getRecordId().intValue());
			if(reqBaseData.getCustId() == null || reqBaseData.getCustId() == 0){
				Logg.writeErrorLog("申请记录的custId("+reqBaseData.getCustId()+")不正确");
				return null;
			}
				
			if (!localPath.endsWith(File.separator)) {  
				custPath  = localPath + File.separator + "file" + File.separator
						+ reqBaseData.getCustId() + File.separator;  
		    }else{
		    	custPath  = localPath + "file" + File.separator 
		    			+ reqBaseData.getCustId() + File.separator;
		    }
			FileControl.createDir(custPath);
			String recordPath = custPath + reqImageData.getRecordId() + File.separator;
			FileControl.createDir(recordPath);
			reqImageData.setImagePath(recordPath);
			return reqImageData;
			 
		}catch(Exception e){
			Logg.writeException(e);
			throw new Exception("解析文件名,整理存储影像文件的路径出错");
		}
	}

	

	

	

}
