package com.job4sure.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class EncriptionUtil {
	
	
	 public static String encrypted(String input) {
	  StringBuffer sb = new StringBuffer();
	  try {
	   MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	   byte[] result = mDigest.digest(input.getBytes());

	   for (int i = 0; i < result.length; i++) {
	    sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
	      .substring(1));
	   }
	  } catch (NoSuchAlgorithmException e) {
	   System.out.println("Converting to SHA has failed");
	  }
	  return sb.toString();
	 }
	}