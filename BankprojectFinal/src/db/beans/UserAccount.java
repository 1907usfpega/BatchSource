package db.beans;

public class UserAccount {
	private String  accountNumber;
	private int balance ;
	public UserAccount(String accountNumber, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "UserAccount [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

}
