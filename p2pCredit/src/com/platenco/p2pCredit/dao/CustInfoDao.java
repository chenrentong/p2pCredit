package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.CustInfo;



public interface CustInfoDao {
	
	void save(CustInfo custInfo) throws Exception;
	
	void update(CustInfo custInfo) throws Exception;
	
	CustInfo get(int custId) throws Exception;
	
	void delete(int custId) throws Exception;
	
	Boolean saveForInfo(CustInfo custInfo) throws Exception;
	
	CustInfo getForUserId(String userId) throws Exception;
	
	CustInfo getForPhoneNoOrIdCard(String phoneNo, String IdCard) throws Exception;
	
	CustInfo getForInfo(CustInfo custInfo) throws Exception;

}
