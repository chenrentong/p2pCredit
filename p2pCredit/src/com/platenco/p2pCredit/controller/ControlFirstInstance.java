package com.platenco.p2pCredit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.common.StatusCode;
import com.platenco.p2pCredit.dao.FirstInstanceRecordDao;
import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.model.FirstInstanceRecord;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.util.Logg;

/**
 * 初审
   * @author tsh
   * 2016年10月11日 上午9:55:42
 */
@Controller
public class ControlFirstInstance implements ResultCode,StatusCode{

	@Resource(name="firstInstanceRecordDao") 
	FirstInstanceRecordDao firstInstanceRecordDao;
	
	@Resource(name="reqBaseDataDao") 
	ReqBaseDataDao reqBaseDataDao;
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/saveFirstInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> saveFirstInstance(@RequestBody FirstInstanceRecord firstInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的保存初审记录请求:"+firstInstanceRecord.toString());
			firstInstanceRecord.setStatus(IN_FIRST_INSTANCE);
			if(firstInstanceRecord.getFirId() == 0){
				result = firstInstanceRecordDao.save(firstInstanceRecord);	
			}else{			
				result = firstInstanceRecordDao.saveOrUpdate(firstInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(firstInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(firstInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "保存出现异常";
			code = SAVE_FIRST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(firstInstanceRecord.getFirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/throughFirstInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> throughFirstInstance(@RequestBody FirstInstanceRecord firstInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的通过初审记录请求:"+firstInstanceRecord.toString());
			firstInstanceRecord.setStatus(THROUGH_FIRST_INSTANCE);
			if(firstInstanceRecord.getFirId() != 0){
				result = firstInstanceRecordDao.saveOrUpdate(firstInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(firstInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(firstInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "初审通过出现异常";
			code = THROUGH_FIRST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(firstInstanceRecord.getFirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
			
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/refuseFirstInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> refuseFirstInstance(@RequestBody FirstInstanceRecord firstInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的拒绝初审记录请求:"+firstInstanceRecord.toString());
			firstInstanceRecord.setStatus(FIRST_INSTANCE_REFUSED);
			if(firstInstanceRecord.getFirId() != 0){
				result = firstInstanceRecordDao.saveOrUpdate(firstInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(firstInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(firstInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "初审拒绝出现异常";
			code = REFUSE_FIRST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(firstInstanceRecord.getFirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/patchFirstInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> patchFirstInstance(@RequestBody FirstInstanceRecord firstInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的补件初审记录请求:"+firstInstanceRecord.toString());
			firstInstanceRecord.setStatus(ADD_REQ_DATA);
			if(firstInstanceRecord.getFirId() != 0){
				result = firstInstanceRecordDao.saveOrUpdate(firstInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(firstInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(firstInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "初审补件出现异常";
			code = PATCH_FIRST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(firstInstanceRecord.getFirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
}
