package com.deanntu.cart;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// create new key
		SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
		// get base64 encoded version of the key
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		// decode the base64 encoded string
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		// rebuild key using SecretKeySpec
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
		String nex = Base64.getEncoder().encodeToString(originalKey.getEncoded());
	}
	private static SecretKeySpec getSecureRandomKey() {
	    byte[] secureRandomKeyBytes = new byte[24 / 8];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(secureRandomKeyBytes);
	    return new SecretKeySpec(secureRandomKeyBytes, "AES");
	}

}
