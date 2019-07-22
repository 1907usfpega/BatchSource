package com.revature.banking;

public class Customer extends UserAccount 
{
	
	public Customer(String personName, String userName, String password)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
	}
}
