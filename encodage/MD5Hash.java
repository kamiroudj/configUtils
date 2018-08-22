ackage com.oxymel.vault.struts2.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public  class MD5Checker {
	
	public static String encode(String salt, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		
		String input = salt+password;
		
		byte[] digest = messageDigest.digest(input.getBytes("UTF-8"));
				
		return new String(Base64.getEncoder().encode(digest), StandardCharsets.UTF_8);
	}
	
	
	public static void main(String[] args) {
		
		MD5Checker md5Checker = new MD5Checker();
		
		String encode = null;
	
		
		try {
			
			encode = md5Checker.encode("hello", "world");
			
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println("encode  " + encode);
		
	}
}
