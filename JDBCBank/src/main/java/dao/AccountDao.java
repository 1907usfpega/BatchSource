package dao;

import java.sql.SQLException;

public interface AccountDao {

	public abstract void createAccount(int customerID, String accountType, double balance) throws SQLException;
	
	public abstract boolean getAccount(int customerID) throws SQLException;
	
	public abstract void listAccounts(int customerID) throws SQLException;
	
	public abstract double getBalance(int accountID) throws SQLException;
	
	public abstract void updateBalance(double balance, int accountID) throws SQLException;
	
	public abstract boolean verifyAccountID(int customerID, int accountID) throws SQLException;
	
	public abstract void deleteAccount(int accountID) throws SQLException;
	
	
}//end AccountDao interface
