package com.revature.corejavaassignment;

public class UserProfile {

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}
	public UserProfile(String name, 
						String pass, 
						String level, 
						String type,
						String partner) {
		this.userName = name;
		this.password = pass;
		this.status = "pending";
		this.clearanceLevel = "level";
		this.accountType = type;
		this.balance = 0;
		this.jointMainKey = partner;
		
		
	}
	private String userName;
	private String password;
	private String status;
	private String clearanceLevel;
	private String accountType;
	private int balance;
	private String jointMainKey;
	
	
	
	public static void main(String args[]) {
		UserProfile user1 = new UserProfile();
		
	}
}
