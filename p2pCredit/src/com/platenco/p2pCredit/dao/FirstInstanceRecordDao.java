package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.FirstInstanceRecord;

public interface FirstInstanceRecordDao {
	
	Boolean save(FirstInstanceRecord firstInstanceRecord) throws Exception;
	
	Boolean saveOrUpdate(FirstInstanceRecord firstInstanceRecord) throws Exception; 

}
