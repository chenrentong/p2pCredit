package com.platenco.p2pCredit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.util.Logg;


/**
 * 申请基础资料相关操作
   * @author tsh
   * 2016年9月29日 下午5:31:42
 */

@Controller
public class ControlReqBaseData implements ResultCode {
	
	@Resource(name="reqBaseDataDao")  
	private ReqBaseDataDao reqBaseDataDao;
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/saveReqBaseData",method=RequestMethod.POST)
	public @ResponseBody ApiResult<Integer> saveReqBaseData(@RequestBody ReqBaseData reqBaseData){
		try{
			Logg.writeDebugLog("接收到的客户申请基础资料表插入请求:"+reqBaseData.toString());
			result = reqBaseDataDao.save(reqBaseData);
			if(result == false){
				Errormsg="保存客户申请基础资料失败,可能已经存在一条已提交的申请记录";
				code = SAVE_REQ_BASE_DATA_ERROR;
			}else{
				code = SUCCESS;
				Errormsg="";
			}
			
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "保存出现异常";
			code = SAVE_REQ_BASE_DATA_ERROR;
			result = false;
		}finally{
			ApiResult<Integer> apiResult = new ApiResult<Integer>(reqBaseData.getRecordId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@RequestMapping(value="/getReqBaseData",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<ReqBaseData> getReqBaseData(@RequestBody ReqBaseData reqBaseData){
		try{
			Logg.writeDebugLog("接收到的客户申请基础资料表查询请求:"+reqBaseData.toString());
			ReqBaseData myReqBaseData = reqBaseDataDao.getForCustId(reqBaseData.getCustId());
			if(myReqBaseData == null){
				Errormsg = "此申请记录不存在";
				result = false;
				code = GET_REQ_BASE_DATA_ERROR;
			}else{
				Errormsg = "";
				result = true;
				code = SUCCESS;
			}
			ApiResult<ReqBaseData> apiResult = new ApiResult<ReqBaseData>(myReqBaseData, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "查询出现异常";
			code = GET_REQ_BASE_DATA_ERROR;
			result = false;
			ApiResult<ReqBaseData> apiResult = new ApiResult<ReqBaseData>(null, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/updateReqBaseData",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Integer> updateReqBaseData(@RequestBody ReqBaseData reqBaseData){
		try{
			Logg.writeDebugLog("接收到的客户申请基础资料表更新请求:"+reqBaseData.toString());
			reqBaseDataDao.update(reqBaseData);
			Errormsg = "";
			result = true;
			code = SUCCESS;		
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "更新出现异常";
			code = UPDATE_REQ_BASE_DATA_ERROR;
			result = false;
		}finally{
			ApiResult<Integer> apiResult = new ApiResult<Integer>(reqBaseData.getRecordId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
}
