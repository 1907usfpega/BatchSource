package com.revature.bankingapppt1_2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	public static ConnectFactory cf = ConnectFactory.getInstance();
	
	public void addNewUser(String nName, String nPass, String nLevel) {
		Connection conn = cf.getConnection();
		String sql = "{ call addNewUser(?,?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, nName);
			call.setString(2, nPass);
			call.setString(3, nLevel);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void changeUStatus(String uName, String statName) {
		Connection conn = cf.getConnection();
		String sql = "{ call changeUStat(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, uName);
			call.setString(2, statName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void removeUser(String uName) {
		Connection conn = cf.getConnection();
		String sql = "{ call removeUser(?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, uName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	@Override
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userProfile");
			User u = null;
			while(rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), this.getAccountList(rs.getString(1)));
				userList.add(u);
			}
			return userList;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean doesUserExist(String uName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userProfile "
					+ "WHERE userName = '" + uName + "'");
			if(rs.next())
				return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
		
	}

	@Override
	public String getPassword(String uName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userProfile "
					+ "WHERE userName = '" + uName + "'");
			String s = null;
			rs.next();
			s = rs.getString(2);
			return s;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return "";
	}

	@Override
	public List<Account> getAccountList(String uName) {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM acct "
					+ "WHERE acctId IN (SELECT linkToAcct FROM linker "
					+ "WHERE linkToUser = '" + uName + "')");
			Account a = null;
			while(rs.next()) {
				a = new Account(rs.getInt(1) + "", rs.getString(2), rs.getDouble(5), rs.getString(3),
						this.getUserList(rs.getInt(1)));
				accountList.add(a);
			}
			return accountList;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public String getClearanceLevel(String uName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT clearanceLevel FROM userProfile "
					+ "WHERE userName = '" + uName + "'");
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
	public String getStatus(String uName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT status FROM userProfile"
					+ " WHERE userName = '" + uName + "'");
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
	public void removeAccount(String uName, String aName) {
		List<String> uListFromAcct = new ArrayList<String>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT linkToUser FROM linker WHERE "
					+ "linkToAcct = '" + aName + "'");
			String a = null;
			while(rs.next()) {
				a = rs.getString(1);
				uListFromAcct.add(a);
			}
			if(uListFromAcct.size() < 2) {
				String s2 = "{ call removeAcct(?)";
				CallableStatement c2 = conn.prepareCall(s2);
				c2.setInt(1, Integer.parseInt(aName));
				c2.execute();
			}
			String sql = "{ call removeLink(?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, uName);
			call.setString(2, aName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public User getUser(String uName) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userProfile"
					+ " WHERE userName = '" + uName + "'");
			User u = null;
			rs.next();
			u = new User(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), this.getAccountList(uName));
			return u;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void addLink(String uName, int aName) {
		Connection conn = cf.getConnection();
		String sql = "{ call addLink(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, uName);
			call.setInt(2, aName);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
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
	public void removeCanc(){
		Connection conn = cf.getConnection();
		String sql = "{ removeCancelled";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.execute();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
