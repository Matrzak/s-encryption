package net.matrzak.encryption.basic;

import java.util.HashMap;

import net.matrzak.encryption.algorithms.HashManager;

public class Hash {
	
	public enum HashType{
		MD5,SHA1,KEY_BASED
	}
	
	private HashManager md5 = new HashManager();
	private HashType type;
	
	

}
