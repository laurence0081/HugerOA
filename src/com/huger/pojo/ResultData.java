package com.huger.pojo;

public class ResultData {
	public int retCode;
	public String retDesc;
	public Object Data;
	
	public ResultData(){
		retCode = -1;
		retDesc = "";
		Data = "";
	}
	
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getRetDesc() {
		return retDesc;
	}
	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	public String getAll(){
		String result="";
		
		result="{\"retCode\":\""+retCode+"\",\"retDesc\":\""+retDesc+"\",\"Data\":"+Data.toString()+ "}";
		
		return result;
	}
}
