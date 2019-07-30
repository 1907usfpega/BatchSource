package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Account;

public interface AccountDao {

	public abstract void insertAccount(String type);
	
	public abstract void deleteAccount(int accountID);
	
	public abstract void changeAccountStatus(int accountID, String status);
	
	public abstract void changeAccountBalance(int accountID, double val);
	
	public abstract void setAccountBalance(int accountID, double val);
	
	public abstract String getAccountStatus(int accountID);
			
	public abstract Account getAccount(int accountID);
	
	public abstract ArrayList<Account> getAll();
	
	public abstract double getBalance(int accountID);
	
	
}
