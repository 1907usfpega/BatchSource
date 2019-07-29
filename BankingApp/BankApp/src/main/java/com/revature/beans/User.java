package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	// person has String name, ArrayList<Account> accounts, String password, int
	// role,
	// constructors, getter setters, tostring
	private String name;
	String password;
	int role;

	public User(String name, String password, int role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User(String name, String password) {
		this(name, password, 0);
	}

	@Override
	public String toString() {
		String roleString = "";
		switch(this.role) {
		case(0): roleString = "Customer" ;break;
		case(1): roleString = "Employee" ;break;
		case(2): roleString = "cAtmin" ;break;

		}
		return "User [name=" + name + ", password=" + password + ", role= " + roleString + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	
	
	
}
