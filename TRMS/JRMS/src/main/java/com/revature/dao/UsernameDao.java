package com.revature.dao;

import java.sql.SQLException;

public interface UsernameDao {
	public abstract boolean usernameExists(String un) throws SQLException;
	public abstract boolean correctPassword(String un, String pw) throws SQLException;
	public abstract int getUID(String un) throws SQLException;
}
