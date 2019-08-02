package com.revature.beans;

import com.revature.dao.UsersDao;

public class User {

	// person has String name, ArrayList<Account> accounts, String password, int
	// role,
	// constructors, getter setters, tostring
	private String userName;
	private String userPass;
	private int userId;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public User(String userName, String userPass, int userId) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass + ", userId=" + userId + "]";
	}

	}
	
	

	

	

	
	
	

