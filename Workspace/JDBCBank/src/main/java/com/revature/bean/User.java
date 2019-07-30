package com.revature.bean;

public class User {
	private int user_id;
	private String username;
	private String userpass;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.userpass = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return userpass;
	}
	public void setPassword(String password) {
		this.userpass = password;
	}
	@Override
	public String toString() {
		return "\n[user_id=" + user_id  + " username=" + username + " userpass=" + userpass ;
	}
	
	
	
	
	

}
