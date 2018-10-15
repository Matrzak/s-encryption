package net.matrzak.encryption.algorithms;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;

import net.matrzak.encryption.utils.Log;
import net.matrzak.encryption.utils.Log.LogType;

public class HashManager {
	
	public String MD5(String text) {
	    try {
		   MessageDigest md = MessageDigest.getInstance("MD5");
		   byte[] array = md.digest(text.getBytes());
		   StringBuffer sb = new StringBuffer();
		   for (int i = 0; i < array.length; ++i) {
		      sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		   }
		   return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		   new Log(LogType.WARNING,e.getCause().toString());
		}
	    return null;
	}
	HashMap<Character,Character> chars = new HashMap<>();
	public String keyhash(String text) {
		for(char c : text.toCharArray()) {
			char generated = rndChar();
			while(chars.containsKey(generated)) {
				generated = rndChar();
			}
			/*
			 * TODO:
			 * smarter pickup of random char
			 */
		}
		
		return null;
	}
	public String SHA1(String text){
	    String sha1 = "";
	    try{
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(text.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    } catch (Exception e) {
	    	new Log(LogType.WARNING,e.getCause().toString());
	    }
	    return sha1;
	}

	private String byteToHex(final byte[] hash) {
	    Formatter formatter = new Formatter();
	    for (byte b : hash){
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
	
	private char rndChar () {
	    int rnd = (int) (Math.random() * 52);
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);
	}
	
	

}
