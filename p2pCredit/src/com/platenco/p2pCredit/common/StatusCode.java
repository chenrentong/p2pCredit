package com.platenco.p2pCredit.common;

public interface StatusCode {

	//未提交
	public final static Integer UNSUBMITTED = -1; 
	
	//已提交,待初审
	public final static Integer WAIT_FIRST_INSTANCE = 0;
	
	//初审中
	public final static Integer IN_FIRST_INSTANCE = 1;
	
	//补件
	public final static Integer ADD_REQ_DATA = 2;
	
	//初审通过(待终审)
	public final static Integer THROUGH_FIRST_INSTANCE = 3;
	
	//终审中
	public final static Integer IN_LAST_INSTANCE = 4;
	
	//终审通过
	public final static Integer THROUGH_LAST_INSTANCE = 5;
	
	//初审拒绝
	public final static Integer FIRST_INSTANCE_REFUSED = 991;
	
	//终审拒绝
	public final static Integer LAST_INSTANCE_REFUSED = 992;
}
