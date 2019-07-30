package com.jackson.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jackson.beans.BankAccount;

import cam.jackson.exceptions.OverdraftException;

public interface BankAccountDao 
{
	public abstract void createNewAccount(int userID, String acctName, double funds) throws SQLException;
	public abstract void deleteAccount(int acctID) throws SQLException;
	public abstract ArrayList<BankAccount> getAccountsList() throws SQLException;
	public abstract void depositFunds(int acctID) throws SQLException;
	public abstract void withdrawFunds(int acctID) throws SQLException, OverdraftException;
	
}
