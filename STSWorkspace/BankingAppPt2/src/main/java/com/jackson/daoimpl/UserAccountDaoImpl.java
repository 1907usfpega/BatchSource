package com.jackson.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.jackson.beans.BankAccount;
import com.jackson.beans.UserAccount;
import com.jackson.dao.UserAccountDao;
import com.jackson.util.ConnFactory;

public class UserAccountDaoImpl implements UserAccountDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewUser(String username, String password, String firstName, String lastName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEUSERACCOUNT(?, ?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, firstName);
		call.setString(4, lastName);
		call.execute();
	}
	
	public void updateUser(int userID) throws SQLException 
	{
		Scanner s = new Scanner(System.in);
		String change = "";
		System.out.println("Select what you would like to update for this user:\n\t1. Username\n\t2. Password\n\t3. First Name\n\t4. Last Name");
		int choice = s.nextInt();
		s.nextLine();
		switch(choice)
		{
			case 1:
				System.out.println("Enter the user's new username: ");
				change = s.nextLine();
				break;
			case 2:
				System.out.println("Enter the user's new password: ");
				change = s.nextLine();
				break;
			case 3:
				System.out.println("Enter the user's new first name: ");
				change = s.nextLine();
				break;
			case 4:
				System.out.println("Enter the user's new last name: ");
				change = s.nextLine();
				break;
			default:
				System.out.println("That is not a valid choice. ");
				break;
		}
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATEUSERACCOUNT(?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.setString(2, change);
		call.setInt(3, choice);
		call.execute();
	}

	public void deleteUser(int userID) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call DELETEUSERACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
	}

	public ArrayList<UserAccount> getUserList() throws SQLException 
	{
		ArrayList<UserAccount> usersList = new ArrayList<UserAccount>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM BANKUSERS");
		UserAccount u = null;
		while(rs.next())
		{
			u = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			usersList.add(u);
		}
		return usersList;
	}

	public ArrayList<BankAccount> getBankAccountList(int userID) throws SQLException 
	{
		ArrayList<BankAccount> accountsList = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNTS WHERE ACCOUNTS.USER_ID = "+userID);
		BankAccount b = null;
		while(rs.next())
		{
			b = new BankAccount(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			accountsList.add(b);
		}
		return accountsList;
	}

}
