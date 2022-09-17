package com.deanntu.user.entity;

public class User {
	private long userID;
	private String userName;
	private String userPassword;
	private String address;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User(long userID, String userName, String userPassword, String address) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
	}
	public User() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}