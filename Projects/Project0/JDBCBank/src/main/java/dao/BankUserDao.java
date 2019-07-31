package dao;


import java.util.ArrayList;

import members.Account;
import members.Customer;

public interface BankUserDao {
	public abstract boolean createNewUser(String username, String password);
	public abstract boolean userAuthentication(String usr, String pword) ;
	public abstract boolean userAlreadyExists(String username);
	public abstract ArrayList<Account> getBankAccounts(String username);
	public abstract Account getBankAccount(int acctNum) ;
	public abstract boolean acctExists(int acctNum) ;
	public abstract boolean updateBalance(Account a);
	public abstract boolean deleteAcct(Account a);
	public abstract boolean makeNewAcct(Customer c);
	public abstract int getUserID(Customer c);

}
