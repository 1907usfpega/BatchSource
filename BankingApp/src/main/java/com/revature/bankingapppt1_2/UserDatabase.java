package com.revature.bankingapppt1_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class UserDatabase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1228899232586445681L;
	private SortedMap<String, User> userDB = new TreeMap<String, User>();
	
	public String printDatabase() {
		String retString = new String();
		for(String s : this.userDB.keySet()) {
			retString = retString.concat(this.userDB.get(s).toString() + "\n");
		}
		System.out.println(retString);
		return retString;
	}
	public boolean checkIfExists(String name) {
		return this.userDB.containsKey(name);
	}
	public boolean addUser(String name, String pass, String clearance) {
		if(this.checkIfExists(name))
			return false;
		if(clearance != "Admin" && clearance != "Employee" && clearance != "Customer")
			return false;
		this.userDB.put(name, new User(name, pass, clearance));
		return true;
			
	}
	public boolean removeUser(String name) {
		if(!checkIfExists(name))
			return false;
		this.userDB.remove(name);
		return true;	
	}
	public User getUser(String name) {
		if(!checkIfExists(name)) {
			//System.out.println("fail");
			return new User("", "", "");
		}
		return this.userDB.get(name);
	}
	public boolean addAccount(String name, String newAccount) {
		if(!this.checkIfExists(name))
			return false;
		this.userDB.get(name).addAccount(newAccount);
		return true;
	}
	public boolean removeAccount(String user, String oldAccount) {
		if(!checkIfExists(user))
			return false;
		this.getUser(user).removeAccount(oldAccount);
		return true;
	}
	public boolean approve(String user) {
		if(!checkIfExists(user))
			return false;
		this.userDB.get(user).approve();
		return true;
	}
	public boolean deny(String user) {
		if(!checkIfExists(user))
			return false;
		this.userDB.get(user).deny();
		return true;
	}
	public List<String> getAccounts(String user){
		if(!checkIfExists(user)) {
			List<String> retVal = new ArrayList<String>();
			return retVal;
		}
		return this.userDB.get(user).getAccounts();		
	}
	public String getClearanceLevel(String user) {
		if(!checkIfExists(user))
			return new String();
		return this.userDB.get(user).getClearanceLevel();
	}
	public boolean setClearanceLevel(String user, String clearance) {
		if(!checkIfExists(user))
			return false;
		this.userDB.get(user).setClearanceLevel(clearance);
		return true;
	}
	public ArrayList<String> getAll(String status){
		ArrayList<String> retList = new ArrayList<String>();
		for(String s : this.userDB.keySet()) {
			if(this.userDB.get(s).getStatus().equals(status))
				retList.add(s);
		}
		return retList;
	}
	public ArrayList<String> getAll(){
		ArrayList<String> retList = new ArrayList<String>();
		for(String s : this.userDB.keySet()) {
				retList.add(s);
		}
		return retList;
	}
	
	public UserDatabase(String name, String pass, String clear) {
		// TODO Auto-generated constructor stub
		this.addUser(name, pass, clear);
	}
	public UserDatabase() {
		this("Admin", "Admin", "Admin");
	}
}
