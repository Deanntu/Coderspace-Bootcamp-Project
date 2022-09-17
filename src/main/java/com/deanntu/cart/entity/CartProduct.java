package com.deanntu.cart.entity;

import com.deanntu.cart.manager.CartManager;

public class CartProduct {

	private long cartProductID; 
	private String cartID; 
	private long productID; 
	private long salesQuantity; 
	private long salesPrice; 
//	private long taxRate; 
//	private long lineAmount;
	private CartManager cm;
	private Cart cart;
	public CartProduct() {}
	public CartProduct(long cartProductID, String cartID, long productID, long salesQuantity, long salesPrice) {
		this.cartProductID = cartProductID;
		this.cartID = cartID;
		this.productID = productID;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		try{
			this.cart = cm.find(cartID);
			cart.setTotalAmount(cart.getTotalAmount()+(salesQuantity*salesPrice));
			cm.update(cart);}
		catch(Exception e) {
		}
	//	this.taxRate = taxRate;
	//	this.lineAmount = lineAmount;
	}
	
	public long getCartProductID() {
		return cartProductID;
	}
	public void setCartProductID(long cartProductID) {
		this.cartProductID = cartProductID;
	}
	public String getCartID() {
		return cartID;
	}
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public long getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(long salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public long getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(long salesPrice) {
		this.salesPrice = salesPrice;
	}
	/*public long getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(long taxRate) {
		this.taxRate = taxRate;
	}
	public long getLineAmount() {
		return lineAmount;
	}
	public void setLineAmount(long lineAmount) {
		this.lineAmount = lineAmount;
	}*/
}
