package user.screens;

public class Account {

	private int accountID;
	private String accountType;
	private double balance;
	
	public Account() {
		super();
		
	}


	public Account(int accountID, String accountType, double balance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
	}


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountType=" + accountType + ", balance=" + balance + "]";
	}

	
}//end Account class
	