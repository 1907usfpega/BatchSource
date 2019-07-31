package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO<Account>{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void withdraw(int accountNumber, double amount) throws SQLException {
		if (amount >= 0) {
			if (checkBalance(accountNumber) - amount >= 0) {
				Connection conn = cf.getConnection();
				String sql = "{ call WITHDRAW(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, accountNumber);
				call.setDouble(2, amount);
				call.execute();	
				System.out.println("New Balance is: $" + checkBalance(accountNumber));
			} else {
				System.out.println("Not enough funds.  You tried to Withdraw $" + amount + ", Current balance is: $"
						+ checkBalance(accountNumber));
			}
		} else {
			System.out.println("you tried to withdraw a negative amount.  Please try again!");
		}
	}

	public void deposit(int accountNumber, double amount) throws SQLException {
		if (amount >= 0) {
			if (checkBalance(accountNumber) - amount >= 0) {
				Connection conn = cf.getConnection();
				String sql = "{ call DEPOSIT(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, accountNumber);
				call.setDouble(2, amount);
				call.execute();	
				System.out.println("New Balance is: $" + checkBalance(accountNumber));
			} else {
				System.out.println("Invalid Deposit, You cannot deposit a negative amount.  You tried to Withdraw $"
						+ amount + ", Current balance is: $" + checkBalance(accountNumber));
			}
		} else {
			System.out.println("You Deposited $0.00, No changes have been made to your balance!");
		}
	}

	public void transfer(int accountNumber, double amount, int transfer) throws SQLException {
		if (amount >= 0) {
			if (checkBalance(accountNumber) - amount >= 0) {
				System.out.println("Witdrawing from account " + accountNumber );
				System.out.println("Transferring Funds To Account " + transfer);
				Connection conn = cf.getConnection();
				String sql = "{ call TRANSFER(?,?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, accountNumber);
				call.setDouble(2, amount);
				call.setInt(3, transfer);
				call.execute();	
				System.out.println("New Balance For Account " + accountNumber + ": $" + checkBalance(accountNumber));
				System.out.println("New Balance For Account " + transfer + ": $" + checkBalance(transfer) );
			} else {
				System.out.println("Not enough funds.  You tried to Transfer $" + amount + ", Current balance is: $"
						+ checkBalance(accountNumber));
			}
		} else {
			System.out.println("you tried to transfer a negative amount.  Please try again!");
		}
	}
	
	public double checkBalance(int accountNumber) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{? = call CHECK_BALANCE(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.registerOutParameter(1, Types.DECIMAL);
		call.setInt(2, accountNumber);
		call.execute();
		double balance = call.getDouble(1);
		return balance;
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

	public void delete(int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
