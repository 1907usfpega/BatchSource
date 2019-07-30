package com.revature.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.account.Account;
import com.revature.dao.AccountDao;
import com.revature.dao.UserDao;
import com.revature.user.User;

public class Database implements UserDao, AccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public static ArrayList<User> pList = new ArrayList<User>();
	public static ArrayList<Account> aList = new ArrayList<Account>();
	public static ArrayList<Account> rList = new ArrayList<Account>();

	public static void addUser(User a) {
		boolean present = false;
		Iterator<User> itr = pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if (b.equals(a)) {
				present = true;
				break;
			}
		}
		if (!present) {
			writeUsers(a);
			pList.add(a);
		}
	}//end addUser
	public static void addAccount(Account a) {
		boolean present = false;
		Iterator<Account> itr = aList.iterator();
		while (itr.hasNext()) {
			Account b = itr.next();
			if (a.equals(b)) {
				System.out.println("Account already exists\nPlease try again with a different name");
				present = true;
				break;
			}
		}
		if (!present) {
			System.out.println(
					"Your account " + a.getAccountName() + ", has been created.");
			writeAccounts(a);
			aList.add(a);
		}
	}// end addAccount
	public void deleteUser(String u) {
		Connection conn=cf.getConnection();
		String sql="{ call removeuser(?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setString(1, u);
			cs.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void removeUser(User a) {
		String username=a.getUserName();
		Database s=new Database();
		s.deleteUser(username);
		pList.remove(a);
	}//end removeUser
	public void deleteAccount(int a) {
		Connection conn=cf.getConnection();
		String sql="{ call removeAcct(?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, a);
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void removeAccount(Account acc) {
		int aid=acc.getAccountID();
		Database s=new Database();
		s.deleteAccount(aid);
		aList.remove(acc);
	}
	public void updateUsers(String f, String l,String p, String u) {
		Connection conn=cf.getConnection();
		String sql="{ call updateuser(?,?,?,?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setString(1, f);
			cs.setString(2, l);
			cs.setString(3, p);
			cs.setString(4, u);
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateUser(User a) {
		String uname=a.getUserName().toUpperCase();
		String fname=a.getFirstName();
		String lname=a.getLastName();
		String pass=a.getpass();
		
		Database s=new Database();
		s.updateUsers(fname, lname, pass, uname);
		
	}//end updateUser
	public void updateAccounts(int a, int b) {
		Connection conn=cf.getConnection();
		String sql="{ call updateacct(?,?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, a);
			cs.setInt(2, b);
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateAccount(Account acc) {
		int aid=acc.getAccountID();
		int bal=acc.getBalance();
		Database s=new Database();
		s.updateAccounts(aid, bal);
		
	}//end updateAccount
	
	
	public static boolean userExists(String username) {
		boolean exists = false;
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if(b.getUserName().toUpperCase().equals(username.toUpperCase())) {
				exists = true;
				break;
			}
		} // end while
		return exists;
	}//end userExists
	

	public static void readUsers() {
		Connection conn =cf.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bankuser");
			User s=null;
			while(rs.next()) {
				s=new User(rs.getString(2),rs.getString(5),rs.getString(3),rs.getString(4),rs.getInt(7),rs.getInt(6), rs.getInt(1));
				pList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void readAccounts() {
		Connection conn =cf.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bankaccount join bankuser on bankaccount.userid=bankuser.userid");
			Account s=null;
			while(rs.next()) {
				s=new Account(rs.getString(2),rs.getString(3),rs.getInt(1),rs.getInt(4),rs.getString(7));
				aList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createUser(String u,String f, String l, String p, int a, int em) {
		Connection conn=cf.getConnection();
		String sql="{ call insertuser(?,?,?,?,?,?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setString(2, f);
			cs.setString(3, l);
			cs.setString(4, p);
			cs.setString(1, u);
			cs.setInt(5, a);
			cs.setInt(6, em);
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void writeUsers(User a) {
		String uname=a.getUserName();
		String fname=a.getFirstName();
		String lname=a.getLastName();
		String pass=a.getpass();
		int adm =a.getIsAdmin();
		int emp =a.getIsEmp();
		
		Database s=new Database();
		s.createUser(uname, fname, lname, pass, adm, emp);
	}
	
	
	public void createAccount(String n, String t, int i) {
		
	}
	public static void writeAccounts(Account acct) {
		String name=acct.getAccountName();
		String type=acct.getAccountType();
		int uid =0;
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b= itr.next();
			acct.getOwner();
			if(acct.getOwner().contains(b.getUserName())) {
				uid=b.getUserID();
				break;
			}
		}
		Connection conn=cf.getConnection();
		String sql="{ call insertacct(?,?,?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setString(1, type);
			cs.setInt(3, uid);
			cs.setString(2, name);
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		Database s=new Database ();
		s.createAccount(name, type, uid);
	}

	
	
	
	public static void printUsers() {
		printUsers(false);
	}// end printUsers
	public static void printUsers(boolean indexed) {
		System.out.println("\nUsers: ");
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			System.out.println((indexed?(pList.indexOf(b)+"\t"):"") + b.toString());
		} // end while
	}// end printUsers
	
	public static void printAccounts() {
		printAccounts(false);
	}// end printAccounts
	public static void printAccounts(boolean indexed) {
		printAccounts(indexed, false);
	}// end printAccounts
	public static void printAccounts(boolean indexed,boolean withBalance) {
		System.out.println("\nAccounts: ");
		Iterator<Account> aitr = Database.aList.iterator();
		while (aitr.hasNext()) {
			Account b = aitr.next();
			System.out.println((indexed?(aList.indexOf(b)+"\t"):"") + b.toString(withBalance));
		} // end while
	}// end printAccounts

}