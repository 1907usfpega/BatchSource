package com.revature.dao;

import java.sql.SQLException;

public interface UserDao {
	public abstract void createUser(String un, String pw) throws SQLException;
	public abstract boolean uniqueUserName(String un) throws SQLException;
	public abstract boolean correctPassword(String un, String pw) throws SQLException;
	public abstract int getUID(String un) throws SQLException;
	public abstract void updatePassword(String un, String pw) throws SQLException;
	public abstract void delUser(String un) throws SQLException;
}
