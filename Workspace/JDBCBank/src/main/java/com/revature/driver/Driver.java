package com.revature.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		catReader();
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
	
	public static void catReader() {
		String path = "src/main/resources/lazyCat.txt";
		FileInputStream is = null;
		StringBuilder sb= new StringBuilder();
		int b = 0;
		try {
			File file = new File(path);
			is = new FileInputStream(file);
			while ((b = is.read()) != -1) {
				char c = (char) b;
					sb.append(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(sb);
	}
}