package com.huger.controller;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huger.pojo.ResultData;
import com.huger.pojo.ResultJson;
import com.huger.pojo.User;
import com.huger.service.IUserService;
import com.huger.user.util.AES256;
import com.huger.user.util.CardMaker;
import com.huger.user.util.MessageUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;	
	
	private static Logger logger = Logger.getLogger(UserController.class);  
			
	@RequestMapping (value = "/login")
	@ResponseBody
	public ResultJson login (HttpServletRequest request) {
		
		ResultData data = new ResultData();
		User user = null;
		String resultStr = "fail";
	    data.setRetCode(400);
	    ResultJson rj = new ResultJson();
	    
	    String encryptResultStr = request.getParameter("jsonData");	
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String password = paraObject.getString("password"); 
		String username = paraObject.getString("username");

		user = userService.getUserByUserPWD(username, password);
		
		if(user != null) {
			resultStr = "success";
		    data.setRetCode(200);
			data.setData(user);
		}else{
			data.setData("\"password wrong\"");
		}
		
		data.setRetDesc(resultStr);
		 
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		encryptResultStr = AES256.parseByte2HexStr(encryptResult);  
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	@RequestMapping (value = "/changePWD")
	@ResponseBody
	public ResultJson changePWD (HttpServletRequest request) {
		
		ResultData data = new ResultData();
		String resultStr = "fail";
	    data.setRetCode(400);
	    ResultJson rj = new ResultJson();
	    
	    String encryptResultStr = request.getParameter("jsonData");	
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String password = paraObject.getString("password"); 
		int id = Integer.parseInt(paraObject.getString("id"));

		int result = userService.modifyPWD(id, password);
		
		if(result != -1) {
		    data.setRetCode(200);
			data.setData("\"\"");
			resultStr = "success";
		}else{
			data.setData("\"change password fail\"");
		}
		
		data.setRetDesc(resultStr);
		 
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		encryptResultStr = AES256.parseByte2HexStr(encryptResult);  
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	@RequestMapping (value = "/verificate")
	@ResponseBody
	public ResultJson getVerification (HttpServletRequest request) {
		
		ResultData data = new ResultData();
	    data.setRetCode(410);
		data.setRetDesc("already send");
		User user = null;
	    MessageUtil mu = new MessageUtil();
	    int result = -1;
	    ResultJson rj = new ResultJson();
	    CardMaker cm = new CardMaker();
	    String verification = cm.getRandCardNo(6);
		String encryptResultStr = request.getParameter("jsonData");	    
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String cellphone = paraObject.getString("cellphone");
				
		Pattern phonePattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = phonePattern.matcher(cellphone);
		if(matcher.find()) {
			user = userService.getUserByCellphone(cellphone);
			if(user == null){
				result = mu.sendVerification(cellphone, verification);
			} else {
				data.setRetDesc("already exist");
			    data.setRetCode(402);
			}
			if(result == 1){
				data.setRetDesc("send");
			    data.setRetCode(201);
			}
		} else{
			data.setRetDesc("not match");
			data.setRetCode(401);		
		}
		data.setData("{\"verification\":\""+verification+"\"}");
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		encryptResultStr = AES256.parseByte2HexStr(encryptResult);  
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	@RequestMapping (value = "/register")
	@ResponseBody
	public ResultJson register (HttpServletRequest request) {
			
		ResultData data = new ResultData();
		int result = -1;
	    ResultJson rj = new ResultJson();
   
	    String jsonData = request.getParameter("jsonData");
		byte[] decryptFrom = AES256.parseHexStr2Byte(jsonData);
		byte[] decryptResult = AES256.decrypt(decryptFrom);  
		try {
			jsonData = new String(decryptResult, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("中文转换报错"); 
		}
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String cellphone = paraObject.getString("cellphone");
		String password = paraObject.getString("password");
		String imgURL = paraObject.getString("imgURL");
		Integer sex = Integer.parseInt(paraObject.getString("sex"));
		String realname = paraObject.getString("realname");
		String jobtitle = paraObject.getString("jobtitle");
		Integer type = Integer.parseInt(paraObject.getString("type")); 
		
		Pattern phonePattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = phonePattern.matcher(paraObject.getString("cellphone"));		
		
		if(matcher.find()) {
			User user = null;
			
			user  = userService.getUserByCellphone(cellphone);
			if (user == null){				
				user = new User();
				user.setCellphone(cellphone);
				user.setPassword(password);
				user.setImgURL(imgURL);
				user.setJobtitle(jobtitle);
				user.setRealname(realname);
				user.setSex(sex);
				user.setType(type);
				
				result = userService.addUser(user);
				if(result == 1) {
					data.setRetCode(200);
					data.setRetDesc("success");
				} else{
				    data.setRetCode(400);
					data.setRetDesc("fail");				
				}
			} else {
				data.setRetCode(407);
				data.setRetDesc("This phone number has all ready been registed");
			}
		}
		
		data.setData("\"\"");
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);  	
		rj.setJson(encryptResultStr);
		
		return rj;
	}
}
