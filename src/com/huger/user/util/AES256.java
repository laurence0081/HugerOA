package com.huger.user.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class AES256 {
	 
	private static String password = "KHealth/shenjunze/dev/2016-10-01";
	
	private static Logger logger = Logger.getLogger(AES256.class);  
	
	public static byte[] encrypt(String content) {  
		try {            
	        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");  
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
	        final byte[] iv = new byte[16];
	        Arrays.fill(iv, (byte) 0x00);
	        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
	        
	        byte[] byteContent = content.getBytes("utf-8");  
			cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
	        byte[] result = cipher.doFinal(byteContent); 
	        
	        return result; 
		} catch (NoSuchAlgorithmException e) {  
	        e.printStackTrace();  
		} catch (NoSuchPaddingException e) {  
	        e.printStackTrace();  
		} catch (InvalidKeyException e) {  
	        e.printStackTrace();  
		} catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
		} catch (IllegalBlockSizeException e) {  
	        e.printStackTrace();  
		} catch (BadPaddingException e) {  
	        e.printStackTrace();  
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}  
		return null;  
	}
	
	public static byte[] decrypt(byte[] content) {  
        try {          	            
	        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");  
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
	        final byte[] iv = new byte[16];
	        Arrays.fill(iv, (byte) 0x00);
	        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);	        
	        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            byte[] result = cipher.doFinal(content);  
            
            return result; // 鍔犲瘑  
        } catch (NoSuchAlgorithmException e) { 
        	logger.error(e.getMessage());
        } catch (NoSuchPaddingException e) {  
        	logger.error(e.getMessage());  
        } catch (InvalidKeyException e) {  
        	logger.error(e.getMessage()); 
        } catch (IllegalBlockSizeException e) {  
        	logger.error(e.getMessage());  
        } catch (BadPaddingException e) {  
        	logger.error(e.getMessage());  
        } catch (InvalidAlgorithmParameterException e) {
        	logger.error(e.getMessage());
		} /*catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}  */
        return null;  
	} 
 
	public static String parseByte2HexStr(byte buf[]) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < buf.length; i++) {  
            String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {  
                hex = '0' + hex;  
            }  
            sb.append(hex.toUpperCase());  
        }  
        return sb.toString();  
	}  
	  
	public static byte[] parseHexStr2Byte(String hexStr) {  
        if (hexStr.length() < 1)  
            return null;  
        byte[] result = new byte[hexStr.length()/2];  
        for (int i = 0;i< hexStr.length()/2; i++) {  
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
            result[i] = (byte) (high * 16 + low);  
        }  
        return result;  
	}  
	
	public static void main(String[] args){
		String content = "{\"username\":\"15120071671\",\"password\":\"mimashi\"}";  
		
		System.out.println("加密前" + content);  
		byte[] encryptResult = encrypt(content);  
		String encryptResultStr = parseByte2HexStr(encryptResult);  
		System.out.println("加密后" + encryptResultStr);  
		  
		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = decrypt(decryptFrom);  
		System.out.println("解密后" + new String(decryptResult));  
	}
}
