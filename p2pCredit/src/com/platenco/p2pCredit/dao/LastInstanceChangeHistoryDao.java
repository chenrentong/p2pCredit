package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.LastInstanceChangeHistory;

public interface LastInstanceChangeHistoryDao {
	
	void save(LastInstanceChangeHistory lastInstanceChangeHistory) throws Exception;

}
