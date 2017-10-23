package com.platenco.p2pCredit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * slf4j日志写入
   * @author tsh
   * 2016年9月28日 下午2:20:51
 */

public class Logg {
	private static Logger logger = null;
	private static Logg logg = null;
	
	private Logg(){
		logger = LoggerFactory.getLogger("mylog");
		
	}
	
	public static synchronized  Logg getInstance(){
		if(logg == null){
			logg = new Logg();
		}
		return logg;
	}

	public static void writeErrorLog(String msg){
		if(logg == null)logg = getInstance();
		logger.error(msg);
	}
	
	public static void writeWarnLog(String msg){
		if(logg == null)logg = getInstance();
		logger.warn(msg);
	}
	
	public static void writeInfoLog(String msg){
		if(logg == null)logg = getInstance();
		logger.info(msg);
	}
	
	public static void writeDebugLog(String msg){
		if(logg == null)logg = getInstance();
		logger.debug(msg);
	}
	
	public static void writeTraceLog(String msg){
		if(logg == null)logg = getInstance();
		logger.trace(msg);
	}
	
	public static void writeException(Exception e){
		if(logg == null)logg = getInstance();
		logger.error(e.getMessage(), e);
	}
	
}
