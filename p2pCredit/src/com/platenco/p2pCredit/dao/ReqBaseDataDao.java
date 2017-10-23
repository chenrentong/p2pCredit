package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.ReqBaseData;

public interface ReqBaseDataDao {
	
	Boolean save(ReqBaseData reqBaseData) throws Exception;
	
	void update(ReqBaseData reqBaseData) throws Exception;
	
	ReqBaseData get(int recordId) throws Exception;
	
	void delete(int recordId) throws Exception;
	
	ReqBaseData getForCustId(int custId) throws Exception;
	
	ReqBaseData getForCustIdAndStatus(int custId, int status) throws Exception;

}
