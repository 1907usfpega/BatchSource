package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.BankingDao;
import com.revature.util.ConnFactory;

public class BankingDaoImpl implements BankingDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createCustomer(String username, String password, String firstName, String lastName)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO customer VALUES(userseq.nextval,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstName);
		ps.setString(4, lastName);

		ps.executeUpdate();
	}

	public void createAccount(String accountName, String accountType, int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call add_account(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, accountName);
		call.setInt(2, customerID);
		call.setString(3, accountType);
		call.execute();
	}

	public List<Customer> getCustomerList() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		// Statement - compiled on SQL side; generally terrible (allows for SQL
		// injection) but since we're hardcoding it in, it's ok
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");// no need for semicolon
		Customer c = null;
		while (rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			customerList.add(c);
		}
		return customerList;
	}

	public List<Account> getAccountListPersonal(Customer c) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT bankaccount.accountid, accountname, accounttype, balance "
				+ "FROM bankaccount JOIN customer_bankaccount "
				+ "ON customer_bankaccount.accountid = bankaccount.accountid WHERE userid = " + c.getCustomerID());
		Account a = null;
		while (rs.next()) {
			a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			accountList.add(a);
		}

		return accountList;
	}

	public List<Account> getAccountListEmployee(Customer c) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUsernameList() throws SQLException {
		List<String> usernameList = new ArrayList<String>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT username FROM customer");
		String s = null;
		while (rs.next()) {
			s = rs.getString(1).toUpperCase();
			usernameList.add(s);
		}
		return usernameList;
	}

	public void withdraw(Account a, int amount) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "UPDATE bankaccount SET balance = balance - ? WHERE accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, amount);
		ps.setInt(2, a.getAccountID());
		ps.executeUpdate();
	}
	public void deposit(Account a, int amount) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "UPDATE bankaccount SET balance = balance + ? WHERE accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, amount);
		ps.setInt(2, a.getAccountID());
		ps.executeUpdate();
	}
	public int getBalance(Account a) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT balance FROM bankaccount WHERE accountID = "+a.getAccountID());
		int balance = 0;
		while(rs.next()) {
			balance = rs.getInt(1);			
		}
		return balance;
	}

	public void removeAccount(Account a) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM bankaccount WHERE accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getAccountID());
		ps.executeUpdate();
	}//end removeAccount
	
	public void removeUser(Customer c) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM customer WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, c.getCustomerID());
		ps.executeUpdate();
	}//end removeAccount

	public void changeName(Customer c, String fname, String lname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE customer SET firstname = ?, lastname = ? WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setInt(3, c.getCustomerID());
		ps.executeUpdate();
	}//end changeName

	public void changeUsername(Customer c, String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE customer SET username = ? WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setInt(2, c.getCustomerID());
		ps.executeUpdate();
	}

	public void changePassword(Customer c, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE customer SET password = ? WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setInt(2, c.getCustomerID());
		ps.executeUpdate();
		
	}
}
