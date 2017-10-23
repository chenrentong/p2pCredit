package com.platenco.p2pCredit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platenco.p2pCredit.util.Logg;

@Controller
public class ApiTest {
	
	@RequestMapping(value="/apiTest",method=RequestMethod.GET)
	public @ResponseBody ApiResult<String> apiTest(){
		ApiResult<String> apiResult = new ApiResult<String>();
		apiResult.setData("测试信息");
		apiResult.setErrorcode(1001);
		apiResult.setErrormsg("这里获取错误信息");
		apiResult.setResult(true);
		apiResult.setVer("备注");
		Logg.writeDebugLog(apiResult.toString());
		return apiResult;
	}

}
