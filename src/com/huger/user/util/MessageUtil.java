package com.huger.user.util;

import java.util.HashMap;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class MessageUtil {
	private static CCPRestSmsSDK restAPI; 
	
	public MessageUtil(){
		restAPI = new CCPRestSmsSDK(); 
		restAPI.init("app.cloopen.com", "8883");
		restAPI.setAccount("aaf98f894d22eb10014d27c213ab048c", "f2cd5fcdf624457fb27acc4609550570");
		restAPI.setAppId("8a48b5514d32a2a8014d4db00da11520");	
	}
	
	public int sendMessage(String cellphone, String password){
		int result = -1;
		HashMap<String, Object> resultMap = null;
		
		resultMap = restAPI.sendTemplateSMS(cellphone,"22510" ,new String[]{password});
		if("000000".equals(resultMap.get("statusCode"))){
			result = 1;
		}
		
		return result;
	}
	
	public int sendVerification(String cellphone, String verification){
		int result = -1;
		HashMap<String, Object> resultMap = null;
		
		resultMap = restAPI.sendTemplateSMS(cellphone,"110302" ,new String[]{verification,"10"});
		if("000000".equals(resultMap.get("statusCode"))){
			result = 1;
		}
		
		return result;
	}
}
