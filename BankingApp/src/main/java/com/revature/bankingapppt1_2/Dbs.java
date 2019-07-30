package com.revature.bankingapppt1_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Dbs {
	private static final String userFile = "user.txt";
	public static UserDatabase userData;
	private static final String accountFile = "account.txt";
	public static AccountDatabase accData;

	public static UserDatabase getUserData() {
		return userData;
	}
	
	public static void setInitUserData() {
		userData.addUser("Admin", "Admin", "Admin");
		userData.getUser("Admin").approve();
	}
	
	public static void deletAllDenied() {
		for(String u: userData.getAll("Denied")) {
			for(String a : userData.getAccounts(u)) {
				accData.removeUser(a, u);
			}
			userData.removeUser(u);
		}
		for(String a : accData.getAll("Denied")) {
			for(String u : accData.getUsers(a)) {
				userData.removeAccount(u, a);
			}
			accData.removeAccount(a);
		}	
		
	}
	

	public static AccountDatabase getAccData() {
		return accData;
	}

	public static void writeUserFileDB(UserDatabase ud) {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(userFile));
			objectOut.writeObject(ud);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@SuppressWarnings("unchecked")
	public static void readUserDBFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(userFile));
			userData = (UserDatabase) objIn.readObject();
			objIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			userData = new UserDatabase();
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeAccountFileDB(AccountDatabase ad) {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(accountFile));
			objectOut.writeObject(ad);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@SuppressWarnings("unchecked")
	public static void readAccountDBFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(accountFile));
			accData = (AccountDatabase) objIn.readObject();
			objIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			accData = new AccountDatabase();
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
