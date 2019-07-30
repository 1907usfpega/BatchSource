package com.revature.dao;

import java.sql.SQLException;

public interface AccountDao {
	public abstract void createAccount(int user_id) throws SQLException;
	
	public abstract void deleteAccount(int account_id) throws SQLException;
	public abstract void updateBalance(int account_id, double Balance)throws SQLException;

}
