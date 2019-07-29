package com.revature.dao;

import com.revature.exception.NegativeNumberException;

public interface AccountDao {
	public abstract void createAccount(int userId);
	public abstract void deleteAccount(int accountId);
	public abstract void depoOrWithdraw(int accountId, int amount,boolean withdrawn) throws NegativeNumberException;
	
}
