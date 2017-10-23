package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.NationWideStores;

public interface NationWideStoresDao {
	
	void save(NationWideStores nationWideStores) throws Exception;
	
	NationWideStores getForStoreCode(String storeCode) throws Exception;
	
	void update(NationWideStores nationWideStores) throws Exception;
	
	
	//-------------------业务相关------------------------------------
	void load(NationWideStores nationWideStores) throws Exception;

}
