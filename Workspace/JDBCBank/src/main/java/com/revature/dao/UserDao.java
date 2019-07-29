package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface UserDao {
	public abstract void createUser(String name, String password);
	public abstract void deleteUser(int id);
	public abstract void updateUserName(String name, int ind) throws SQLException;
	public abstract void updateUserPass(String pass, int ind) throws SQLException;
	public abstract ArrayList<User> getUsers() throws SQLException;
	public abstract ArrayList<Account> getAccounts(int userId) throws SQLException;
	
}
