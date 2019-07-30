package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
	public abstract void createUser(String username, String userpass) throws SQLException;
	public abstract void deleteUser(int user_id) throws SQLException;
	public abstract void updateUser(int user_id, String username, String userpass) throws SQLException;
	//public abstract ArrayList<> getAllUsers() throws SQLException; //return all users as an ArrayList
		
	}
	


