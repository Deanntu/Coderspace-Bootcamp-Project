package com.deanntu.cart.entity;

import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Cart {
	private SecretKey cartID;
	private long totalAmount;
	private String customerName;
	public Cart() {}
	public Cart(long totalAmount, String customerName) {
		this.cartID = getSecureRandomKey();
		this.totalAmount = totalAmount;
		this.customerName = customerName;
	}
	public SecretKey getCartID() {
		return cartID;
	}
	public void setCartID(String encodedKey) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
		cartID = originalKey;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private static SecretKey getSecureRandomKey() {
		try {
			return  KeyGenerator.getInstance("AES").generateKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
