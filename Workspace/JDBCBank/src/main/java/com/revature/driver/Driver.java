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
	public static User admin = new User();

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