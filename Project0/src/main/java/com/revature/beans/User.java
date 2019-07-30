package com.revature.beans;


public class User {
	
	private String userName;
	private String password;
	private String clearanceLevel;
	
	private String status;
	
	public void approve() {
		this.status = "Approved";
	}
	public void deny() {
		this.status = "Denied";
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void changePassword(String newPass) {
		this.password = newPass;
	}
	
	public void printUser() {
		System.out.println(this.toString());
	}
	

	@Override
	public String toString() {
		return "| " + userName + " | " + password + " | " + clearanceLevel
				+ " | " + status + " | ";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClearanceLevel() {
		return this.clearanceLevel;
	}
	public void setClearanceLevel(String clearanceLevel) {
		this.clearanceLevel = clearanceLevel;
	}
	
	public User() {
		
	}
	public User(String name, String pass, String clearance) {
		this.userName = name;
		this.password = pass;
		this.clearanceLevel = clearance;
		this.status = "Pending";
		
	}
	public User(String name, String pass, String clearance, String status) {
		this.userName = name;
		this.password = pass;
		this.clearanceLevel = clearance;
		this.status = status;
	}
}
