package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;

/*
 * DAO class for all transaction/balance based requirements.
 */

public interface TransactionDao {

	public abstract void makeDeposit(Account acct, double amt) throws SQLException;
	
	public abstract void makeWithdrawal(Account acctNo, double amt) throws SQLException;
	
	public abstract void makeXfer(Account srcAcct, Account destAcct, double amt) throws SQLException;
	
	public abstract List<Transaction> transactionList(int acctNo) throws SQLException;

}
