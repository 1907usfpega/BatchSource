package com.revature.bankingapppt1_2;

import java.sql.SQLException;
import java.util.List;

public interface AcctDao {
	public abstract void addNewAcct(String nType, String nUser);
	public abstract void changeAStatus(int aName, String statName);
	public abstract List<Account> getAcctList();
	public abstract void removeAcct(int aName);
	public abstract boolean doesAcctExist(int aName);
	public abstract List<User> getUserList(int aName);
	public abstract double getBalance(int aName);
	public abstract String getStatus(int aName);
	public abstract void removeUser(String uName, int aName);
	public abstract Account getAccount(int aName);
	public abstract void setBalance(int aName, double amt);
	public abstract void changeBalance(int aName, double amt);
	public abstract String getType(int aName);
	void removeCanc();
}
