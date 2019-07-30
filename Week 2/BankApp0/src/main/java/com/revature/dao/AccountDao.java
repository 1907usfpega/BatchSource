package com.revature.dao;

import java.sql.SQLException;

public interface AccountDao {
	public abstract void createAccount(String nickname, int UID) throws SQLException;
	public abstract void deleteAccount(String nickname, int UID) throws SQLException;
	public abstract void deposit(String nickname, double depositAmt, int uid) throws SQLException;
	public abstract void withdraw(String nickname, double withdrawAmt, int uid) throws SQLException;
	public abstract void getAllAccounts(int UID) throws SQLException;
}
