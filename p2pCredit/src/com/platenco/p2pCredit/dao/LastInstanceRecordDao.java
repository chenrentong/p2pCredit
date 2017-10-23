package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.LastInstanceRecord;

public interface LastInstanceRecordDao {
	
	void save(LastInstanceRecord lastInstanceRecord) throws Exception;
	
	void saveOrUpdate(LastInstanceRecord lastInstanceRecord) throws Exception;

}
