package com.jackson.beans;

public class Transaction 
{
	private String accountName;
	private int type;
	private double amount;
	private int userAcctID;
	private int bankAcctID;
	
	
	public Transaction() 
	{
		super();
	}

	public Transaction(String accountName, int type, double amount) 
	{
		super();
		this.accountName = accountName;
		this.type = type;
		this.amount = amount;
	}

	public String getAccountName() 
	{
		return accountName;
	}

	public void setAccountName(String accountName) 
	{
		this.accountName = accountName;
	}

	public int getType() 
	{
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public int getUserAcctID() 
	{
		return userAcctID;
	}

	public void setUserAcctID(int userAcctID) 
	{
		this.userAcctID = userAcctID;
	}

	public int getBankAcctID() 
	{
		return bankAcctID;
	}

	public void setBankAcctID(int bankAcctID) 
	{
		this.bankAcctID = bankAcctID;
	}

	@Override
	public String toString() 
	{
		return "Transaction [accountName=" + accountName + ", type=" + type + ", amount=" + amount + ", userAcctID="
				+ userAcctID + ", bankAcctID=" + bankAcctID + "]";
	}
}
