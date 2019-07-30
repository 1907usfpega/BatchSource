package members;

public class Account {
	private int acctNum;
	private double balance;
	private int transfer;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(int acctNum, double balance) {
		super();
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	


	public int getAcctNum() {
		return acctNum;
	}


	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double amt) {
		this.balance = this.balance+amt;
	}
	
	

	@Override
	public String toString() {
		return "Account [acctNum=" + acctNum + ", balance=" + balance + "]";
	}


	public boolean deposit(double amt) {
		if(amt< 1) {
			if(transfer==1) {return false;}
			System.out.println("You cannot deposit a negative number");
			return false;
		}
		else {
			setBalance(amt);
			if(transfer==1) {return true;}
			System.out.println("You have successfully deposited: $"+amt+"0");
			System.out.println("Your new balance is: $"+getBalance()+"0\n\n");
			
			return true;
		}
		
	}
	public boolean withdraw(double amt) {
		if(amt<1) {
			if(transfer==1) {return false;}
			System.out.println("You can not withdraw a negative amount!");
			return false;
		}
		else if(amt>getBalance()) {
			if(transfer==1) {return false;}
			System.out.println("Insufficient funds!");
			return false;
		}
		else {
			setBalance(amt*-1);
			if(transfer==1) {return true;}
			System.out.println("You have successfully withdrawn: $"+amt+"0");
			System.out.println("Your new balance is: $"+getBalance()+"0\n\n");
			return true;
		}
	}
	public boolean transfer(double amt, Account target) {
		transfer=1;
		if(withdraw(amt)) {
			if(target.deposit(amt)) {
				System.out.println("Your transfer was successful");
				System.out.println("Your new balance is: $"+getBalance()+"0\n\n");
				return true;
			}
		}
		return false;
		
	}
	public void viewAccount() {
		System.out.println("Account# "+getAcctNum()+" : $"+getBalance()+"\n\n");
	}
}
