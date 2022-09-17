package com.deanntu.inventory.entity;

public class Category {

	private long categoryID;
	private String categoryName;

	public Category() {}
	public Category(long categoryID,String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void print() {
		System.out.println("CategoryID: " + categoryID +" CategoryName: " + categoryName);
		
	}
	public String toPublish() {
		return "Category Name: " + categoryName + "\nCategory ID: " + categoryID;
	}
}
