package com.revature.bankingapppt1;

import java.util.SortedMap;
import java.util.TreeMap;

public class UserDatabase {

	private SortedMap<String, User> userDB = new TreeMap<String, User>();
	
	public void printDatabase() {
		for(String s : this.userDB.keySet()) {
		}
		System.out.println();
	}
	public boolean addUser(String name, String pass, String clearance) {
		if(userDB.containsKey(name))
			return false;
		if(clearance != "Admin" && clearance != "Employee" && clearance != "Customer")
			return false;
		userDB.put(name, new User(name, pass, clearance));
		return true;
	}
	
	
	
	public UserDatabase() {
		// TODO Auto-generated constructor stu
	}

}
