package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

/*
 * Dao for account creation & removal. Note that all transactions/alterations of accounts should be handled by the TransactionDao.
 */

public interface AccountDao {
	
	public abstract void createAccount(Integer userId, Double balance, String accountType) throws SQLException;
	
	//Should only be allowed by customer if bal = 0.00. Should always be available to admins.
	public abstract void closeAccount(Integer userId) throws SQLException;
	
	//For use in getting an account and its info.
	public abstract Account getAccount(Integer userId) throws SQLException;
	public abstract Account getAccountbyNo(Integer AccountId) throws SQLException;

	
	public abstract List<Account> getAccountList() throws SQLException;
	
	public abstract Double getBal(Integer accountId) throws SQLException;

}
