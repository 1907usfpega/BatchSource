package avbank;

public class Account {

	private long accountId;
	
	private long ownerId;
	
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getOwnerId() {
		return ownerId;
	}
	
	
}
