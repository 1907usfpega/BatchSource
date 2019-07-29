package com.revature.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Version of Account class from BankApp modified for use w/SQL.
 * AUTHOR: redc
 * DATE: 28JUL2019
 */

public class Account {
	
	private Double balance;
	private Integer acctNo;
	private Integer userId;
	private String acctType;
	
	public Account(int acctNum, int userNum, double bal, String type) {
		acctNo = acctNum;
		userId = userNum;
		balance = bal;
		acctType = type;
	}

	
	//Returns current balance in account. Opted for use here instead of through connection due to speed(won't have to query DB to get bal. That said, I don't
	//think this will show updated balances until a new connection to DB is made.
	public Double getBalance()
	{	
		return balance;
	}
	
	public Integer getAcctNo() {
		return acctNo;
	}


	public Integer getUserId() {
		return userId;
	}


	public String getAcctType() {
		return acctType;
	}
	
	public void printBal(int targetID)
	{
		System.out.println("Your balance is $" + this.getBalance());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
