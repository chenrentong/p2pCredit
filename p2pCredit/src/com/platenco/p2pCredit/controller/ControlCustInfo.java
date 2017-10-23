package com.platenco.p2pCredit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.dao.CustInfoDao;
import com.platenco.p2pCredit.model.CustInfo;
import com.platenco.p2pCredit.util.Logg;

/**
 * 客户资料接口
   * @author tsh
   * 2016年9月28日 下午2:18:51
 */


@Controller
public class ControlCustInfo implements ResultCode{	

	@Resource(name="custInfoDao")  
	private CustInfoDao custInfoDao;
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/saveCustInfo",method=RequestMethod.POST)
	public @ResponseBody ApiResult<Integer> saveCustInfo(@RequestBody CustInfo custInfo){
		try{
			Logg.writeDebugLog("接收到的客户表插入请求:"+custInfo.toString());
			result = custInfoDao.saveForInfo(custInfo);
			if(result == false){
				Errormsg="身份证或手机号码已存在,请更换后再试";
				code = SAVE_CUST_INFO_ERROR;
			}else{
				Errormsg="";
				code = SUCCESS;
			}	
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "保存出现异常";
			code = SAVE_CUST_INFO_ERROR;
			result = false;
		}finally{
			ApiResult<Integer> apiResult = new ApiResult<Integer>(custInfo.getCustId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@RequestMapping(value="/getCustInfo",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<CustInfo> getCustInfo(@RequestBody CustInfo custInfo){
		try{
			Logg.writeDebugLog("接收到的客户表查询请求:"+custInfo.toString());
			CustInfo myCustInfo = custInfoDao.getForInfo(custInfo);

			if(myCustInfo == null){
				Errormsg="此客户不存在";
				result = false;
				code = GET_CUST_INFO_ERROR;
			}else{
				Logg.writeDebugLog("查询到的数据:"+myCustInfo.toString());
				Errormsg="";
				code = SUCCESS;
				result = true;
			}
			ApiResult<CustInfo> apiResult = new ApiResult<CustInfo>(myCustInfo, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "查询出现异常";
			code = GET_CUST_INFO_ERROR;
			result = false;
			ApiResult<CustInfo> apiResult = new ApiResult<CustInfo>(null, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/updateCustInfo",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ApiResult<Integer> updateCustInfo(@RequestBody CustInfo custInfo){
		try{
			Logg.writeDebugLog("接收到的客户表更新请求:"+custInfo.toString());
			custInfoDao.update(custInfo);
			Errormsg = "";
			result = true;
			
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "更新出现异常";
			code = UPDATE_CUST_INFO_ERROR;
			result = false;
		}finally{
			ApiResult<Integer> apiResult = new ApiResult<Integer>(custInfo.getCustId(), SUCCESS, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
}
