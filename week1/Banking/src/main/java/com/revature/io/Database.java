package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.driver.Account;
import com.revature.driver.User;

public class Database {
	private static final String USERFILE = "User.txt";
	private static final String ACCTFILE = "Acct.txt";
	private static final String RECSFILE = "Recs.txt";
	public static ArrayList<User> pList = new ArrayList<User>();
	public static ArrayList<Account> aList = new ArrayList<Account>();
	public static ArrayList<Account> rList = new ArrayList<Account>();

	public static void addUser(User a) {
		boolean present = false;
		Iterator<User> itr = pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if (b.equals(a)) {
				// System.out.println("Username already taken");
				present = true;
				break;
			}
		}
		if (!present) {
			pList.add(a);
			writeUsers();
		}
	}//end addUser
	public static void addAccount(Account a) {
		boolean present = false;
		Iterator<Account> itr = aList.iterator();
		while (itr.hasNext()) {
			Account b = itr.next();
			if (a.equals(b)) {
				present = true;
				break;
			}
		}
		if (!present) {
			aList.add(a);
			writeAccounts();
		}
	}// end addAccount
	public static void addRequest(Account a) {
		boolean present = false;
		Iterator<Account> itr = rList.iterator();
		while (itr.hasNext()) {
			Account b = itr.next();
			if (b.getAccountName() == a.getAccountName()) {
				present = true;
				break;
			}
		}
		if (!present) {
			rList.add(a);
			writeRequests();
		}

	}//end addRequest
	
	public static void removeUser(User a) {
		pList.remove(a);
		writeUsers();
	}//end removeUser
	public static void removeAccount(Account acc) {
		aList.remove(acc);
		writeAccounts();
	}// end removeUser
	public static void removeRequest(Account acc) {
		rList.remove(acc);
		writeRequests();
	}//end removeUser
	
	public static void updateUser(User a) {
		removeUser(a);
		addUser(a);
	}//end updateUser
	public static void updateAccount(Account acc) {
		removeAccount(acc);
		addAccount(acc);
	}//end updateAccount
	public static void updateRequest(Account acc) {
		removeRequest(acc);
		addRequest(acc);
	}//end updateRequest
	

	@SuppressWarnings("unchecked")
	public static void readUsers() {
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream(USERFILE));
			pList = (ArrayList<User>) is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void readAccounts() {
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream(ACCTFILE));
			aList = (ArrayList<Account>) is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void readRequests() {
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream(RECSFILE));
			rList = (ArrayList<Account>) is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end readRequests

	public static void writeUsers() {
		ObjectOutputStream os = null;
		File file = new File(USERFILE);
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(pList);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeAccounts() {
		ObjectOutputStream os = null;
		File file = new File(ACCTFILE);
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(aList);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end writeAccounts

	public static void writeRequests() {
		ObjectOutputStream os = null;
		File file = new File(RECSFILE);
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(rList);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end writeRequests

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
	public static void printRequests() {
		printRequests(false);
	}// end printRequests
	public static void printRequests(boolean indexed) {
		System.out.println("\nPending Accounts: ");
		Iterator<Account> aitr = Database.rList.iterator();
		while (aitr.hasNext()) {
			Account b = aitr.next();
			System.out.println((indexed?(rList.indexOf(b)+"\t"):"") + b.toString());
		} // end while
	}// end printRequests

}