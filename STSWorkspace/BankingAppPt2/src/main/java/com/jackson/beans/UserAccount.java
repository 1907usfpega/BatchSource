package com.jackson.beans;

public class UserAccount 
{
	private int accountID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public UserAccount() 
	{
		super();
	}

	public UserAccount(int accountID, String username, String password, String firstName, String lastName) 
	{
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAccountID() 
	{
		return accountID;
	}

	public void setAccountID(int accountID) 
	{
		this.accountID = accountID;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFullName()
	{
		return firstName + " " + lastName;
	}

	@Override
	public String toString() 
	{
		return "UserAccount [accountID: " + accountID +", name: " +firstName+" "+lastName+ ", username: " + username + ", password: " + password + "]";
	}
	
}
