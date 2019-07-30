package com.jackson.beans;

public class BankAccount 
{
	private int bankacctID;
	private String accountName;
	private double funds;
	private int custID;
	
	public BankAccount() 
	{
		super();
	}

	public BankAccount(int bankacctID, String accountName, double funds, int custID) 
	{
		super();
		this.bankacctID = bankacctID;
		this.accountName = accountName;
		this.funds = funds;
		this.custID = custID;
	}

	public int getBankacctID() 
	{
		return bankacctID;
	}

	public void setBankacctID(int bankacctID) 
	{
		this.bankacctID = bankacctID;
	}

	public String getAccountName() 
	{
		return accountName;
	}

	public void setAccountName(String accountName) 
	{
		this.accountName = accountName;
	}

	public double getFunds() 
	{
		return funds;
	}

	public void setFunds(double funds) 
	{
		this.funds = funds;
	}

	public int getCustID() 
	{
		return custID;
	}

	public void setCustID(int custID) 
	{
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "BankAccount [bankacctID: " + bankacctID + ", accountName: " + accountName + ", funds: " + funds + ", custID: " + custID + "]";
	}
}
