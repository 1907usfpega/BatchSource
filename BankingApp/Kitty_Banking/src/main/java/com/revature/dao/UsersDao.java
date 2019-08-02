package com.revature.dao;

import java.sql.SQLException;

public interface UsersDao {
	public abstract void createUsers
	(String userName, String userPASS,int userID,int ACCOUNTBALANCE) 
	throws SQLException;
	
	public abstract void loginUsers
	(String userName, String userPASS,int userID,int ACCOUNTBALANCE) 
	throws SQLException;
	
}




