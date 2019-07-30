package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.User;

public interface UserDao {
	
	public abstract void insertUser(String username, String password, String type);
	
	public abstract void deleteUser(String username);
	
	public abstract void changeUserStatus(String username, String status);
	
	public abstract int getUserId(String username); 
	
	public abstract String getUserPassword(String username);
	
	public abstract String getUserStatus(String username);
	
	public abstract String getUserType(String username);
	
	public abstract String getClearance(String username);
	
	public abstract User getUser(String username);
	
	public abstract ArrayList<User> getAll();
	

}
