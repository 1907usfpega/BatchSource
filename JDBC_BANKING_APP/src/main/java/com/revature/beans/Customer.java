package com.revature.beans;

public class Customer {
	
	
	private  String username;
	private  String password;
	private int accoutNumb;
	private String firstName;
	private String lastName;
	private int balance;
	
	
	public String setUsername() {
		return username;}
	
	//public String getPassword1() {
	//	return password;}
	

	
	public Customer(String username) {
		super();
		this.username = username;
	}

	public Customer(int balance,String password,int accoutNumb, String firstName,String username, String lastName ) {
		super();
		this.username= username;
		this.password=password;
		this.accoutNumb = accoutNumb;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public int getAccoutNumb() {
		return accoutNumb;
	}
	public void setAccoutNumb(int accoutNumb) {
		this.accoutNumb = accoutNumb;
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
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int deposit(int deposit) {
		return balance = balance +deposit;
	}
	
	public int withdraw(int deposit) {
		return balance = balance -deposit;
	}
	
	@Override
	public String toString() {
		return "Customer [accoutNumb=" + accoutNumb + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", balance=" + balance + "]";
	}
	
}
