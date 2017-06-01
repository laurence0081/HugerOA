package com.huger.user.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UnitTest {
	public static void testVerification(){
		String cellphone  = "13104601219";	
		String JsonData ="{\"cellphone\":\"" + cellphone + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testRegister(){
		String cellphone  = "18618321612";	
		String password  = "123456";		
		String JsonData ="{\"cellphone\":\"" + cellphone + "\",\"password\":\"" + password + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	
	public static void testLog(){
		PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(UnitTest.class);
        logger.debug("debug");
        logger.error("error"); 
	}
	
	public static void testLogin(){
		String cellphone  = "13382047496";	
		String password  = "102102";		
		String JsonData ="{\"cellphone\":\"" + cellphone + "\",\"password\":\"" + password + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testMeetingByPage(){
		String pageNum  = "1";		
		String JsonData ="{\"pageNum\":\"" + pageNum + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testMeetingDetailById(){
		String meetingId = "1";		
		String JsonData ="{\"meetingId\":\"" + meetingId + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testCreateCard(){
		String userId = "99999";		
		String password = "temppwd";
		String num = "10";
		String type = "3";
		String JsonData ="{\"userId\":\"" + userId + "\",\"password\":\"" + password + "\",\"num\":\"" + num+ "\",\"type\":\"" + type+ "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testVip2(){
		String clinicId   = "3";			
		String JsonData ="{\"clinicId\":\"" + clinicId +"\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testVip3(){
		String clinicId = "1";		
		String pageNum = "1";
		String JsonData ="{\"clinicId\":\"" + clinicId + "\", \"pageNum\":\"" + pageNum +"\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testCN(){
		String targetId = "P14";
		String JsonData ="{\"targetId\":\"" + targetId +"\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	public static void testInterface(){
		String result = "2A6F0C211AA709A3196D76DB2EFCA498DDAD220E3161BF11C20C411DD69E1BC7";
		System.out.println("finalResult:  " + new String(AES256.decrypt(AES256.parseHexStr2Byte(result))));
	}
	//{"content":"好","title":"2015年中国医师协会妇产科医师大会","users":"","targetId":"M5","replyId":"286","commentedId":"1","userId":"1"}
	public static void testInterface2(){	
		String content  = "好";
		String title  = "2015年中国医师协会妇产科医师大会";
		String users = "";
		String targetId  = "M5";
		String replyId  = "286";
		String commentedId = "1";
		String userId = "1";
		
		String JsonData ="{\"content\":\"" + content + "\",\"targetId\":\"" + targetId + "\",\"title\":\"" + title+ "\",\"userId\":\"" + userId 
				+ "\",\"replyId\":\"" + replyId + "\",\"commentedId\":\"" + commentedId  + "\",\"users\":\"" + users + "\"}";
		System.out.println("jsonData:  " + JsonData);
		String encrypt_result = AES256.parseByte2HexStr(AES256.encrypt(JsonData));
		System.out.println("AES256_encrypt:  " + encrypt_result);
	}
	
	public static void main(String[] args){
		
		
		UnitTest.testVerification();
		UnitTest.testInterface();
	}
}
