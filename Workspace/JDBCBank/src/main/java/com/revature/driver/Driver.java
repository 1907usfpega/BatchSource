package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;

public class Driver {
	static UserDaoImpl udi = new UserDaoImpl();
	static AccountDaoImpl adi = new AccountDaoImpl();
	static ArrayList<User> userList;
	private static User loggedInUser = null;

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		Driver.loggedInUser = loggedInUser;
	}

	public static void main(String[] args) {
		userList = getUsers();
		boolean cont = true;
		while (cont) {
			cont = MainMenu.loginOrRegister();
		}

		// register or login method

		// if login returned true

		// call bank app start (bank homepage)
		// if return is equal 0

		// System.exit(0);

		//
	}

	public static ArrayList<User> getUsers() {
		ArrayList<User> userList = null;
		try {
			userList = udi.getUsers();
			for (User u : userList) {
				System.out.println(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;

	}
}
/*
 * udi.createUser("Leo", "qwertz"); udi.createUser("Terry", "catz");
 * udi.createUser("Nic", "CupOfJava"); udi.deleteUser(1); adi.createAccount(2);
 * System.out.println("account created!");
 */

/*
 * try { ArrayList<Account> accs = udi.getAccounts(2); for(Account a : accs) {
 * System.out.println(a); } adi.depoOrWithdraw(1, 0, false);
 * System.out.println(accs.get(0)); } catch (SQLException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } catch
 * (NegativeNumberException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 */
