package com.platenco.p2pCredit.dao;

import com.platenco.p2pCredit.model.ReqImageData;

public interface ReqImageDataDao {
	
	void save(ReqImageData reqImageData) throws Exception;
	
	ReqImageData get(Long imageId) throws Exception;
	
	Boolean update(ReqImageData reqImageData) throws Exception;
	
	ReqImageData getForInfo(ReqImageData reqImageData) throws Exception;
	
	//----------------------------------------------------------------------
	public ReqImageData parseFileName(String fileName, String localPath) throws Exception;

}
