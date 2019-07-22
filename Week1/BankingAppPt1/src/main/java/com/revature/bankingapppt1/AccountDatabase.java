package com.revature.bankingapppt1;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AccountDatabase implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SortedMap<String, Account> acctDB = new TreeMap<String, Account>();
	
	public void printDatabase() {
		for(String k : this.acctDB.keySet())
			System.out.println(this.getAccount(k).toString());
		System.out.println();
	}
	public boolean approve(String user) {
		if(!checkIfExists(user))
			return false;
		this.acctDB.get(user).approve();
		return true;
	}
	public boolean deny(String user) {
		if(!checkIfExists(user))
			return false;
		this.acctDB.get(user).deny();
		return true;
	}
	public boolean addAccount(String id, String type, String initialUser) {
		if(type != "Checking" && type != "Savings")
			return false;
		if(this.acctDB.containsKey(id))
			return false;
		this.acctDB.put(id, new Account(id, type, initialUser));
		return true;
	}
	public boolean removeAccount(String id) {
		if(!this.checkIfExists(id))
			return false;
		this.acctDB.remove(id);
		return true;
	}
	public boolean checkIfExists(String id) {
		return this.acctDB.containsKey(id);
	}
	public Account getAccount(String id) {
		if(!this.checkIfExists(id))
			return new Account("", "", "");
		return this.acctDB.get(id);
	}
	public boolean addUser(String id, String newUser) {
		if(!this.checkIfExists(id))
			return false;
		this.acctDB.get(id).addUser(newUser);
		return true;
	}
	public boolean removeUser(String id, String oldUser) {
		if(!this.checkIfExists(id))
			return false;
		if(this.getAccount(id).getUsers().size() < 2)
			return false;
		this.getAccount(id).removeUser(oldUser);
		return true;
	}
	public boolean updateBalance(String id, double change) {
		if(!this.checkIfExists(id))
			return false;
		this.acctDB.get(id).updateBalance(change);
		return true;
	}
	public double getBalance(String id) {
		if(!this.checkIfExists(id))
			return (double)0;
		return this.acctDB.get(id).getBalance();
	}
	public boolean setBalance(String id, double newBalance) {
		if(!this.checkIfExists(id))
			return false;
		this.acctDB.get(id).setBalance(newBalance);
		return true;
	}
	public List<String> getUsers(String id){
		if(!this.checkIfExists(id)) {
			List<String> retVal = new ArrayList<String>();
			return retVal;
		}
		return this.acctDB.get(id).getUsers();
	}
	//added(vvvvvv)
	public List<String> getAllPending(){
		List<String> retList = new ArrayList<String>();
		for(String s : this.acctDB.keySet()) {
			if(this.acctDB.get(s).getStatus() == "Pending")
				retList.add(s);
		}
		return retList;
	}
	
	public AccountDatabase() {
		this.addAccount("0000000000000000", "Checking", "RevatureAcct0");
	}
	public AccountDatabase(String initID, String initType, String initUser) {
		this.addAccount(initID, initType, initUser);
		this.getAccount(initID).approve();
	}

}
