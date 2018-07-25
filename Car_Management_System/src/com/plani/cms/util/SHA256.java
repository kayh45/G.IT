package com.plani.cms.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 비밀번호 암호화를 위한 SHA256 클래스
 * 
 * @author 강현
 *
 */
public class SHA256 {

	public static String getSHA256(String input){

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	    }
}
