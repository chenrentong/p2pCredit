package com.platenco.p2pCredit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.common.StatusCode;
import com.platenco.p2pCredit.dao.LastInstanceRecordDao;
import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.model.LastInstanceRecord;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.util.Logg;

/**
 * 终审操作
   * @author tsh
   * 2016年10月11日 下午6:04:30
 */
@Controller
public class ControlLastInstance implements ResultCode, StatusCode {
	
	@Resource(name="lastInstanceRecordDao") 
	LastInstanceRecordDao lastInstanceRecordDao;
	
	@Resource(name="reqBaseDataDao") 
	ReqBaseDataDao reqBaseDataDao;
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/saveLastInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> saveLastInstance(@RequestBody LastInstanceRecord 	lastInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的保存终审记录请求:"+lastInstanceRecord.toString());
			lastInstanceRecord.setStatus(IN_LAST_INSTANCE);
			if(lastInstanceRecord.getLirId() == 0){
				lastInstanceRecordDao.save(lastInstanceRecord);
			}else{			
				lastInstanceRecordDao.saveOrUpdate(lastInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(lastInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(lastInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "保存出现异常";
			code = SAVE_LAST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(lastInstanceRecord.getLirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/throughLastInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> throughLastInstance(@RequestBody LastInstanceRecord 	lastInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的通过终审记录请求:"+lastInstanceRecord.toString());
			lastInstanceRecord.setStatus(THROUGH_LAST_INSTANCE);
			if(lastInstanceRecord.getLirId() != 0){	
				lastInstanceRecordDao.saveOrUpdate(lastInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(lastInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(lastInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "终审通过出现异常";
			code = THROUGH_LAST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(lastInstanceRecord.getLirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/refuseLastInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> refuseLastInstance(@RequestBody LastInstanceRecord 	lastInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的拒绝终审记录请求:"+lastInstanceRecord.toString());
			lastInstanceRecord.setStatus(LAST_INSTANCE_REFUSED);
			if(lastInstanceRecord.getLirId() != 0){	
				lastInstanceRecordDao.saveOrUpdate(lastInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(lastInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(lastInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "终审拒绝出现异常";
			code = REFUSE_LAST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(lastInstanceRecord.getLirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/fallbackLastInstance",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Long> fallbackLastInstance(@RequestBody LastInstanceRecord 	lastInstanceRecord){
		try{
			Logg.writeDebugLog("接收到的回退终审记录请求:"+lastInstanceRecord.toString());
			lastInstanceRecord.setStatus(WAIT_FIRST_INSTANCE);
			if(lastInstanceRecord.getLirId() != 0){	
				lastInstanceRecordDao.saveOrUpdate(lastInstanceRecord);
			}
			ReqBaseData reqBaseData = reqBaseDataDao.get(lastInstanceRecord.getRecordId().intValue());
			reqBaseData.setStatus(lastInstanceRecord.getStatus());;
			reqBaseDataDao.update(reqBaseData);
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "终审回退出现异常";
			code = FALLBACK_LAST_INSTANCE_RECORD_ERROR;
			result = false;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(lastInstanceRecord.getLirId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
}
