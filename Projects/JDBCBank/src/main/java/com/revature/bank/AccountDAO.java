package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO<Account>{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void withdraw(Account account, double amount) throws SQLException {
		if (amount >= 0) {
			if (account.getBalance() - amount >= 0) {
				Connection conn = cf.getConnection();
				String sql = "{ call WITHDRAW(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, account.getAccountNumber());
				call.setDouble(2, amount);
				call.execute();	
				//account.setBalance(account.getBalance() - amount);
				System.out.println("New Balance is: $" + account.getBalance());
			} else {
				System.out.println("Not enough funds.  You tried to Withdraw $" + amount + ", Current balance is: $"
						+ account.getBalance());
			}
		} else {
			System.out.println("you tried to withdraw a negative amount.  Please try again!");
		}
	}

	public void deposit(Account account, double amount) throws SQLException {
		if (amount >= 0) {
			if (account.getBalance() - amount >= 0) {
				Connection conn = cf.getConnection();
				String sql = "{ call DEPOSIT(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, account.getAccountNumber());
				call.setDouble(2, amount);
				call.execute();	
				//account.setBalance(account.getBalance() + amount);
				System.out.println("New Balance is: $" + account.getBalance());
			} else {
				System.out.println("Invalid Deposit, You cannot deposit a negative amount.  You tried to Withdraw $"
						+ amount + ", Current balance is: $" + account.getBalance());
			}
		} else {
			System.out.println("You Deposited $0.00, No changes have been made to your balance!");
		}
	}

	public void transfer(Account account, double amount, Account transfer) throws SQLException {
		if (amount >= 0) {
			if (account.getBalance() - amount >= 0) {
				System.out.println("Witdrawing from account " + account.getBalance());
				System.out.println("Transferring Funds To Account " + transfer.getAccountNumber());
				Connection conn = cf.getConnection();
				String sql = "{ call TRANSFER(?,?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, account.getAccountNumber());
				call.setDouble(2, amount);
				call.setInt(3, transfer.getAccountNumber());
				call.execute();	
			} else {
				System.out.println("Not enough funds.  You tried to Transfer $" + amount + ", Current balance is: $"
						+ account.getBalance());
			}
		} else {
			System.out.println("you tried to transfer a negative amount.  Please try again!");
		}
	}
	
	public void checkBalance(Account account) throws SQLException {
		getAll();
	}
	
	public void deleteAccount(Account account) {
		
	}
	
	public void createAccount(Account account) {
		
	}
	
	//DAO Interface Methods
	public List<Account> getAll() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM \"ACCOUNT\"");
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getDouble(2));
			accountList.add(a);
		}
		return accountList;
	}

	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}
}
