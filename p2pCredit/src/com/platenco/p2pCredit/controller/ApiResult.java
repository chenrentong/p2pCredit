package com.platenco.p2pCredit.controller;


public class ApiResult<T> {
	public T data;
    public int errorcode;
    public String errormsg;
    public boolean result;
    public String ver;
    
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	
	@Override
	public String toString() {
		return "ApiResult [data=" + data + ", errorcode=" + errorcode
				+ ", errormsg=" + errormsg + ", result=" + result + ", ver="
				+ ver + "]";
	}
	public ApiResult(T data, int errorcode, String errormsg, boolean result) {
		super();
		this.data = data;
		this.errorcode = errorcode;
		this.errormsg = errormsg;
		this.result = result;
	}
	public ApiResult() {
		super();
	}

    
}
