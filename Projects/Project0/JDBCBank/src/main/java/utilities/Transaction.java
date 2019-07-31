package utilities;

import daoimpl.BankUserDaoImpl;
import members.Account;

public class Transaction {
	private int action;
	private Account acct;
	private Double amt;
	private BankUserDaoImpl bu =new BankUserDaoImpl();
	public Transaction()
	{
		
	}
	public Transaction(int action){
		this.action=action;
	}
	public Transaction(int action, Double amt) {
		this.action=action;
		this.amt=amt;
	}
	


	public Transaction(int action, Account acct, Double amt) {
		super();
		this.action = action;
		this.acct = acct;
		this.amt = amt;
	}





	public int getAction() {
		return action;
	}





	public void setAction(int action) {
		this.action = action;
	}





	public Account getAcct() {
		return acct;
	}





	public void setAcctNum(Account acctNum) {
		this.acct = acctNum;
	}





	public Double getAmt() {
		return amt;
	}





	public void setAmt(Double amt) {
		this.amt = amt;
	}


	


	public void doTransaction(Account a)
	{
		switch(getAction())
		{
			case 1: 
			{
				a.viewAccount();
				
				break;
			}
			case 2:
			{
				a.deposit(getAmt());
				bu.updateBalance(a);
				break;
			}
			case 3:
			{
				a.withdraw(getAmt());
				bu.updateBalance(a);
				break;
			}
			case 4:
			{
				a.transfer(getAmt(), getAcct());
				bu.updateBalance(a);
				bu.updateBalance(getAcct());
				break;
			}
			default:
			{
				System.out.println("Invalid command. Please try again.");
			}
		}
	}
}
