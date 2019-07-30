package com.revature.bankingapppt1_2;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	public abstract void addNewUser(String nName, String nPass, String nLevel);
	public abstract void changeUStatus(String uName, String statName);
	public abstract List<User> getUserList();
	public abstract void removeUser(String uName);
	public abstract boolean doesUserExist(String uName);
	public abstract String getPassword(String uName);
	public abstract List<Account> getAccountList(String uName);
	public abstract String getClearanceLevel(String uName);
	public abstract String getStatus(String uName);
	public abstract void removeAccount(String uName, String aName);
	public abstract User getUser(String uName);
	public abstract void addLink(String uName, int aName);
	public abstract List<User> getUserList(int aName);
	public abstract void removeCanc();
	
}
