package com.revature.dao;

import java.sql.SQLException;

public interface AccountDao {
	public abstract void createAccount(String nickname, int UID) throws SQLException;
	public abstract void deleteAccount(String nickname, int UID) throws SQLException;
}
