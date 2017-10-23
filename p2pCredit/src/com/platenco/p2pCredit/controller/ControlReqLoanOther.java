package com.platenco.p2pCredit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.dao.ReqLoanOtherDao;
import com.platenco.p2pCredit.model.ReqLoanOther;
import com.platenco.p2pCredit.util.Logg;

/**
 * 其它贷款数据操作相关
   * @author tsh
   * 2016年9月29日 下午5:31:16
 */

@Controller
public class ControlReqLoanOther implements ResultCode {

	@Resource(name="reqLoanOtherDao")  
	private ReqLoanOtherDao reqLoanOtherDao;
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/saveReqLoanOther",method=RequestMethod.POST)
	public @ResponseBody ApiResult<Long> saveReqLoanOther(@RequestBody ReqLoanOther[] reqLoanOthers){
		
		try{
			Logg.writeDebugLog("接收到的其它贷款表插入请求:"+reqLoanOthers.toString());
			for(ReqLoanOther reqLoanOther : reqLoanOthers){
				reqLoanOtherDao.save(reqLoanOther);
			}
			Errormsg = "";
			result = true;
			code = SUCCESS;
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "保存出现异常";
			result = false;
			code = SAVE_REQ_LOAN_OTHER_ERROR;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(reqLoanOthers[0].getRecordId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
	
	@RequestMapping(value="/getReqLoanOther",method=RequestMethod.POST)
	public @ResponseBody ApiResult<ReqLoanOther[]> getReqLoanOther(@RequestBody ReqLoanOther[] reqLoanOthers){
		try{
			Logg.writeDebugLog("接收到的其它贷款表查询请求:"+reqLoanOthers.toString());
			List<ReqLoanOther>  listReqLoanOther = reqLoanOtherDao.getForRecordId(reqLoanOthers[0].getRecordId());
			ReqLoanOther[] myReqLoanOthers = listReqLoanOther.toArray(new ReqLoanOther[listReqLoanOther.size()]);
			Errormsg = "";
			result = true;
			code = SUCCESS;
			ApiResult<ReqLoanOther[]> apiResult = new ApiResult<ReqLoanOther[]>(myReqLoanOthers, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "查询出现异常";
			result = false;
			code = GET_REQ_LOAN_OTHER_ERROR;
			ApiResult<ReqLoanOther[]> apiResult = new ApiResult<ReqLoanOther[]>(null, code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
		
	}
		
	@SuppressWarnings("finally")
	@RequestMapping(value="/updateReqLoanOther",method=RequestMethod.POST)
	public @ResponseBody ApiResult<Long> getReqLoanOther(@RequestBody ReqLoanOther reqLoanOther){
		try{
			Logg.writeDebugLog("接收到的其它贷款表更新请求:"+reqLoanOther.toString());
			reqLoanOtherDao.update(reqLoanOther);
			Errormsg = "";
			result = true;
			code = SUCCESS;
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "更新出现异常";
			result = false;
			code = UPDATE_REQ_LOAN_OTHER_ERROR;
		}finally{
			ApiResult<Long> apiResult = new ApiResult<Long>(reqLoanOther.getOtherRecordId(), code, Errormsg, result);
			Logg.writeDebugLog("返回的应答:"+apiResult.toString());
			return apiResult;
		}
	}
}
