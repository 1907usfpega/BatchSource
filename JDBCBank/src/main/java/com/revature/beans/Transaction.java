package com.revature.beans;

import java.sql.Date;

/*
 * Transaction object. To be implemented, primarily for calls for transaction history.
 * TODO: Flesh out class.
 */

public class Transaction {
	
	private int transId;
	private int acctId;
	private double amt;
	private Date date;
	
	
	public Transaction()
	{
		
	}

	public Transaction(int transactionId, int accountId, double amount, Date dateStamp) {
		transId = transactionId;
		acctId = accountId;
		amt = amount;
		date = dateStamp;
	}

	public int getTransId() {
		return transId;
	}

	public int getAcctId() {
		return acctId;
	}

	public double getAmt() {
		return amt;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", acctId=" + acctId + ", amt=" + amt + ", date=" + date + "]";
	}

}
