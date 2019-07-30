package com.revature.methods;

import com.revature.pojo.User;

public interface UserMethods {
	
	public boolean createUser(String username, String password);
	
	public boolean deleteUser(String username);
	
	public User getUserByName(String username);
	
	public User getUser(String username,String password);	
}