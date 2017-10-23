package com.platenco.p2pCredit.dao;

import java.util.List;

import com.platenco.p2pCredit.model.ReqLoanOther;

public interface ReqLoanOtherDao {
	
	Boolean save(ReqLoanOther reqLoanOther) throws Exception;
	
	ReqLoanOther get(Long otherRecordId) throws Exception;
	
	List<ReqLoanOther> getForRecordId(Long recordId) throws Exception;
	
	void update(ReqLoanOther reqLoanOther) throws Exception;

}
