package com.huger.user.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	public static final String MD5="MD5";
	
	private static Md5 md5 = new Md5();
	
    private Md5(){}  
	
	public static Md5 getMd5(){
		return md5;
	}
	
	public byte[] EncryptionStrBytes(String str, String algorithm) {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密算法: "+ algorithm +" 不存在: ");
        }
        return null==bytes?null:bytes;
    }

    public String BytesConvertToHexString(byte [] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
          String s=Integer.toHexString(0xff & aByte);
            if(s.length()==1){
                sb.append("0"+s);
            }else{
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public String EncryptionStr(String str, String algorithm) {
        byte[] bytes = EncryptionStrBytes(str,algorithm);
        return BytesConvertToHexString(bytes);
    }
}
