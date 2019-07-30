package com.jackson.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jackson.beans.UserAccount;

public interface UserAccountDao 
{
	public abstract void createNewUser(String firstName, String lastName, String username, String password) throws SQLException;
	public abstract ArrayList<UserAccount> getUserList() throws SQLException;
}
