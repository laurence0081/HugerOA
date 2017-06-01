package com.huger.user.util;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSONObject;

public class HXUtil{
	
	public static String BASE_URL = "https://a1.easemob.com/1161161101178648/surgeon/";
	private static HXUtil hxUtil = new HXUtil();
	
    private HXUtil(){}  
	
	public static HXUtil getHXUtil(){
		return hxUtil;
	}
	
	public String getToken(){
        
        HttpClient client = new HttpClient();
        String url = BASE_URL+"token";
        PostMethod method = new PostMethod(url);
        
        method.setParameter("grant_type", "client_credentials");
        method.setParameter("client_id", "YXA6ftjfMJ_oEeaKO4PDTsXj0g");
        method.setParameter("client_secret", "YXA66HYFwuQ4o4Wz9h1if9ebUnEPJ-o");

    	String responseStr = "";
		String access_token = ""; 
		int flag = 0;
        
        try{
        	do{
        		client.executeMethod(method);
        		flag ++;
				Thread.sleep(8000);
        	}
        	while(method.getStatusCode() != 200 || flag != 5);
            
            if(method.getStatusCode() == 200){
            	responseStr = method.getResponseBodyAsString();
            	JSONObject paraObject = JSONObject.parseObject(responseStr);	

        		access_token = paraObject.getString("access_token"); 
        		//String expires_in = paraObject.getString("expires_in");
        		//String application = paraObject.getString("application");
            }
        } catch (IOException e) {
            System.out.println("执行HTTP Post请求" + url + "时，发生异常！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("执行等待0.8s时，发生异常！");
			e.printStackTrace();
		} finally {
            method.releaseConnection();
        }
        System.out.println("--------------------" + responseStr);
        return access_token;
    }
	
    public String hxRegister(Map<String, String> params, String token) {
        
    	String url = BASE_URL + "users";
    	
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                method.setParameter(entry.getKey(), entry.getValue());
            }
        }
        
        method.setRequestHeader("Authorization", "Bearer " + token);
        
        int flag = 0;
    	String responseStr = "";
		String entities = ""; 
		String activated = "";
        
        try{
        	do{
        		client.executeMethod(method);
        		flag ++;
				Thread.sleep(8000);
        	}
        	while(method.getStatusCode() != 200 || flag != 5);
            
            if(method.getStatusCode() == 200){
            	responseStr = method.getResponseBodyAsString();
            	JSONObject paraObject = JSONObject.parseObject(responseStr);	

            	entities = paraObject.getString("entities"); 
            	activated = paraObject.getString("activated");
                System.out.println(entities);
                System.out.println(activated);
            }
        } catch (IOException e) {
            System.out.println("执行HTTP Post请求" + url + "时，发生异常！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("执行等待0.8s时，发生异常！");
			e.printStackTrace();
		} finally {
            method.releaseConnection();
        }
        return activated;
    } 
    
    public String hxAddFriend(String url, Map<String, String> params, String token) {
        
    	String owner_username = params.get("owner_username");
    	String friend_username = params.get("friend_username");
    	
    	url = BASE_URL + "users/" + owner_username + "/contacts/users/" + friend_username;
    	
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);

        method.setRequestHeader("Authorization", "Bearer " + token);
        
        int flag = 0;
    	String responseStr = "";
		String entities = ""; 
		String activated = "";
        
        try{
        	do{
        		client.executeMethod(method);
        		flag ++;
				Thread.sleep(8000);
        	}
        	while(method.getStatusCode() != 200 || flag != 5);
            
            if(method.getStatusCode() == 200){
            	responseStr = method.getResponseBodyAsString();
            	JSONObject paraObject = JSONObject.parseObject(responseStr);	

            	entities = paraObject.getString("entities"); 
            	activated = paraObject.getString("activated");
                System.out.println(entities);
                System.out.println(activated);
            }
        } catch (IOException e) {
            System.out.println("执行HTTP Post请求" + url + "时，发生异常！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("执行等待0.8s时，发生异常！");
			e.printStackTrace();
		} finally {
            method.releaseConnection();
        }
        return activated;
    }
    
    public String hxDelFriends(String url, Map<String, String> params, String token) {
    	
        HttpClient client = new HttpClient();
        DeleteMethod method = new DeleteMethod(url);

        String owner_username = params.get("owner_username");
    	String friend_username = params.get("friend_username");
    	
    	url = BASE_URL + "users/" + owner_username + "/contacts/users/" + friend_username;
    	
        method.setRequestHeader("Authorization", "Bearer " + token);
        
        int flag = 0;
    	String responseStr = "";
		String entities = ""; 
		String activated = "";
        
        try{
        	do{
        		client.executeMethod(method);
        		flag ++;
				Thread.sleep(8000);
        	}
        	while(method.getStatusCode() != 200 || flag != 5);
            
            if(method.getStatusCode() == 200){
            	responseStr = method.getResponseBodyAsString();
            	JSONObject paraObject = JSONObject.parseObject(responseStr);	

            	entities = paraObject.getString("entities"); 
            	activated = paraObject.getString("activated");
                System.out.println(entities);
                System.out.println(activated);
            }
        } catch (IOException e) {
            System.out.println("执行HTTP Post请求" + url + "时，发生异常！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("执行等待0.8s时，发生异常！");
			e.printStackTrace();
		} finally {
            method.releaseConnection();
        }
        return activated;
    } 
}
