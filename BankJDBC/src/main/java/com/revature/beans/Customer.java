package com.revature.beans;

public class Customer {
	private int customerID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID, String username, String password, String firstName, String lastName) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
