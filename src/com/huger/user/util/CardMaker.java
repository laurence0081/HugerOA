package com.huger.user.util;

import java.util.Random;

public class CardMaker {
	public String getRandStr(int length) {
		String charValue = "";
	    for (int i = 0; i < length; i++){
			char temp = '0';
			int tempInt = randomInt(0,43);
			if(9 < tempInt && tempInt < 17) tempInt -= 7;
			temp += tempInt;
		    charValue += String.valueOf(temp);
	    }
		return charValue;
	}
	public String getRandCardNo(int length) {
		String charValue = "";
	    for (int i = 0; i < length; i++){
			char temp = '0';
			int tempInt = randomInt(0,9);
			temp += tempInt;
		    charValue += String.valueOf(temp);
	    }
		return charValue;
	}
	
	 public int randomInt(int from, int to){
		  Random r = new Random();
		  return from + r.nextInt(to - from);
	}
	 
	public static void main(String[] args){
		CardMaker cm = new CardMaker();
		System.out.println(cm.getRandCardNo(9) + "          " + cm.getRandStr(16));		
	}
}
