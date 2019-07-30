package com.revature.bankingapppt1_2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcctDaoImpl implements AcctDao {
	public static ConnectFactory cf = ConnectFactory.getInstance();
	
	public void addNewAcct(String nType, String nUser) {
		Connection conn = cf.getConnection();
		String sql = "{ call addNewAcct(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, nUser);
			call.setString(2, nType);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	public void changeAStatus(int aName, String statName) {
		Connection conn = cf.getConnection();
		String sql = "{ call changeAStat(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, aName);
			call.setString(2, statName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void removeAcct(int aName) {
		Connection conn = cf.getConnection();
		String sql = "{ call removeAcct(?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, aName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	@Override
	public List<Account> getAcctList() {
		List<Account> userList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM acct");
			Account a = null;
			while(rs.next()) {
				a = new Account(rs.getString(1), rs.getString(2), 
						rs.getDouble(5), rs.getString(3), this.getUserList(rs.getInt(1)));
				userList.add(a);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public boolean doesAcctExist(int aName) {
		Connection conn = cf.getConnection();
		try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM acct "
				+ "WHERE acctId = " + aName);
		if(rs.next())
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<User> getUserList(int aName) {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userProfile "
					+ "WHERE userName IN (SELECT linkToUser FROM linker WHERE "
					+ "linkToAcct = " + aName + ")");
			User u = null;
			while(rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
				userList.add(u);
			}
			return userList;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatus(int aName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT status FROM acct"
					+ " WHERE acctId = " + aName);
			String s = null;
			rs.next();
			s = rs.getString(1);
			return s;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return "";
	}

	@Override
	public void removeUser(String uName, int aName) {
		List<String> uListFromAcct = new ArrayList<String>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT linkToAcct FROM linker WHERE "
					+ "linkToUser = '" + uName + "'");
			String a = null;
			while(rs.next()) {
				a = rs.getString(1);
				uListFromAcct.add(a);
			}
			if(uListFromAcct.size() < 2) {
				String s2 = "{ call removeUser(?)";
				CallableStatement c2 = conn.prepareCall(s2);
				c2.setString(1, uName);
				c2.execute();
			}
			String sql = "{ call removeLink(?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, uName);
			call.setInt(2, aName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public double getBalance(int aName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT balance FROM acct"
					+ " WHERE acctId = " + aName);
			double s = 0.0;
			rs.next();
			s = rs.getDouble(1);
			return s;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0.0;
	}

	@Override
	public Account getAccount(int aName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM acct"					
					+ " WHERE acctId = " + aName);
			Account a = null;
			rs.next();
			a = new Account(rs.getString(1), rs.getString(2), 
					rs.getDouble(5), rs.getString(3), this.getUserList(aName));
			return a;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void setBalance(int aName, double amt) {
		Connection conn = cf.getConnection();
		String sql = "{ call setBal(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, aName);
			call.setDouble(2, amt);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	@Override
	public void changeBalance(int aName, double amt) {
		Connection conn = cf.getConnection();
		String sql = "{ call changeBal(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, aName);
			call.setDouble(2, amt);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public String getType(int aName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT acctType FROM acct"
					+ " WHERE acctId = " + aName);
			String s = null;
			rs.next();
			s = rs.getString(1);
			return s;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return "";
	}
	
	@Override
	public void removeCanc(){
		Connection conn = cf.getConnection();
		String sql = "{ call removeCancelled";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
