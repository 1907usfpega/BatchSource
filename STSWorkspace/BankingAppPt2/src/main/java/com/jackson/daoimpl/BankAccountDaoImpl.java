package com.jackson.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.jackson.beans.BankAccount;
import com.jackson.dao.BankAccountDao;
import com.jackson.util.ConnFactory;

import cam.jackson.exceptions.OverdraftException;

public class BankAccountDaoImpl implements BankAccountDao 
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewAccount(int userID, String acctName, double funds) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEBANKACCOUNT(?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.setString(2, acctName);
		call.setDouble(3, funds);
		call.execute();
	}

	public void depositFunds(int acctID, int userID) throws SQLException
	{
		double amount = 0;
		boolean found = false;
		Scanner s = new Scanner(System.in);
		UserAccountDaoImpl userDao = new UserAccountDaoImpl();
		BankAccount b = new BankAccount();
		
		
		for(BankAccount current : userDao.getBankAccountList(userID))
		{
			if(current.getBankacctID() == acctID)
			{
				b = current;
				found = true;
			}
		}
		if(found == false)
		{
			System.out.println("User does not have access to that account ID");
			return;
		}
		System.out.println("Enter the amount you wish to deposit: ");
		amount = s.nextDouble();
		s.nextLine();
		if(amount < 0)
		{
			System.out.println("Underdaft Exception: You attempted to deposit a negavite number into the "+b.getAccountName()+" account");
		}
		else
		{
			Connection conn = cf.getConnection();
			String sql = "{ call DEPOSIT(?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, acctID);
			call.setDouble(2, amount);
			call.execute();
			System.out.println("New Balance for "+b.getAccountName()+": "+b.getFunds()+amount);
		}
		
	}

	public void withdrawFunds(int acctID, int userID) throws SQLException, OverdraftException
	{
		double amount = 0;
		boolean found = false;
		Scanner s = new Scanner(System.in);
		UserAccountDaoImpl userDao = new UserAccountDaoImpl();
		BankAccount b = new BankAccount();
				
		for(BankAccount current : userDao.getBankAccountList(userID))
		{
			if(current.getBankacctID() == acctID)
			{
				b = current;
				found = true;
			}
		}
		if(found == false)
		{
			System.out.println("User does not have access to that account ID");
			return;
		}
		System.out.println("Enter the amount you wish to withdraw: ");
		amount = s.nextDouble();
		s.nextLine();
		if(amount > b.getFunds())
		{
			System.out.println("OverdraftException: You attempted to withdraw more funds than were available in the "+b.getAccountName()+" account");
		}
		else
		{
			Connection conn = cf.getConnection();
			String sql = "{ call WITHDRAW(?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, acctID);
			call.setDouble(2, amount);
			call.execute();
			System.out.println("New Balance for "+b.getAccountName()+": "+(b.getFunds()-amount));
		}
	}
	
	public void deleteAccount(int acctID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call DELETEBANKACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acctID);
		call.execute();
	}

	public ArrayList<BankAccount> getAccountsList() throws SQLException 
	{
		ArrayList<BankAccount> baList = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNTS");
		BankAccount b = null;
		while(rs.next())
		{
			b = new BankAccount(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			baList.add(b);
		}
		return baList;
	}

}
