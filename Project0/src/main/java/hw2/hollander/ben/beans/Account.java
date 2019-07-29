package hw2.hollander.ben.beans;

public class Account {
	private String usrname;
	private double balance;
	
	public Account() {
		super();
	}
	
	public Account(String usrname) {
		this.usrname = usrname;
	}

	public double getBalance() {
		return balance;
	}
}
