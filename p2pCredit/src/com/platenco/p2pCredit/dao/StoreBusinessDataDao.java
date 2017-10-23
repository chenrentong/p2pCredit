package com.platenco.p2pCredit.dao;

import java.util.List;
import java.util.Map;

import com.platenco.p2pCredit.model.StoreBusinessData;

public interface StoreBusinessDataDao {
	
	void save(StoreBusinessData storeBusinessData) throws Exception;
	
	StoreBusinessData getForStoreIdAndDataCycle(Integer storeId, String dataCycle) throws Exception;
	
	void update(StoreBusinessData storeBusinessData) throws Exception;
	
	void getAll() throws Exception;
	
	//------------------------------------------------------------------
	void load(StoreBusinessData storeBusinessData) throws Exception;
	
	void batchLoad(int totalDataBlock, int startYear, int storeId, String[] fields) throws Exception;
	
	

}
