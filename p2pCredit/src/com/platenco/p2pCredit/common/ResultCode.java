package com.platenco.p2pCredit.common;

public interface ResultCode {
	//处理成功
	public final static Integer SUCCESS = 0; 
	//保存客户基本资料失败
	public final static Integer SAVE_CUST_INFO_ERROR = 1001;
	//获取客户基本资料失败
	public final static Integer GET_CUST_INFO_ERROR = 1002;
	//更新客户基本资料失败
	public final static Integer UPDATE_CUST_INFO_ERROR = 1003;
	//保存客户申请基本资料失败
	public final static Integer SAVE_REQ_BASE_DATA_ERROR = 2001;
	//获取客户申请基本资料失败
	public final static Integer GET_REQ_BASE_DATA_ERROR = 2002;
	//更新客户申请基本资料失败
	public final static Integer UPDATE_REQ_BASE_DATA_ERROR = 2003;
	//上传文件失败
	public final static Integer UPLOAD_FILE_ERROR = 3001;
	//下载文件失败
	public final static Integer DOWNLOAD_FILE_ERROR = 3002;	
	//保存其它信贷资料失败
	public final static Integer SAVE_REQ_LOAN_OTHER_ERROR = 4001;
	//获取其它信贷资料失败
	public final static Integer GET_REQ_LOAN_OTHER_ERROR = 4002;
	//获取其它信贷资料失败
	public final static Integer UPDATE_REQ_LOAN_OTHER_ERROR = 4003;
	//保存初审记录失败
	public final static Integer SAVE_FIRST_INSTANCE_RECORD_ERROR = 5001;
	//初审通过操作失败
	public final static Integer THROUGH_FIRST_INSTANCE_RECORD_ERROR = 5002;
	//初审拒绝操作失败
	public final static Integer REFUSE_FIRST_INSTANCE_RECORD_ERROR = 5003;
	//补件操作失败
	public final static Integer PATCH_FIRST_INSTANCE_RECORD_ERROR = 5004;
	//保存终审记录失败
	public final static Integer SAVE_LAST_INSTANCE_RECORD_ERROR = 6001;
	//终审通过操作失败
	public final static Integer THROUGH_LAST_INSTANCE_RECORD_ERROR = 6002;
	//终审拒绝操作失败
	public final static Integer REFUSE_LAST_INSTANCE_RECORD_ERROR = 6003;
	//终审回退操作失败
	public final static Integer FALLBACK_LAST_INSTANCE_RECORD_ERROR = 6004;
}
