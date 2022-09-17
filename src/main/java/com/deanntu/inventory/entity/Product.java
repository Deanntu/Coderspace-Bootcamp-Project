package com.deanntu.inventory.entity;

public class Product {
	private long productID; 
	private String productName; 
	private long salesPrice; 
	private long categoryID;
	//private String imagePath;
	public Product() {}
	public Product(long productID, String productName, long salesPrice, long cateogryID) { //, String imagePath
		this.productID = productID;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryID = cateogryID;
		
		//this.imagePath = imagePath;
	} 
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(long salesPrice) {
		this.salesPrice = salesPrice;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	/*public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}*/
	public void print() {
		System.out.println("ProductID: "+ productID + " ProductName: " + productName + " SalesPrice: " + salesPrice + " CategoryID: " + categoryID);	
	}
	public String toPublish() {
		return "Product Name: " + productName + "\nPrice: " + salesPrice;
	}
	public String toPublishAdmin() {
		return "Product Name: " + productName + " - Price: " + salesPrice + " - Product ID: " + productID + " - CategoryID :" + categoryID;
	}
}
