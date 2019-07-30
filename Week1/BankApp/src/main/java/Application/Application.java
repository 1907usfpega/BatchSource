
package Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Accounts.Account;
import Driver.Test;


public class Application implements Serializable {

	private static final long serialVersionUID = 4760524870134914257L;

	private static List<Application> openApplications = new ArrayList<Application>();

	private Scanner keyboard = new Scanner(System.in);
	private Map<String, String> login = new HashMap<String, String>();
	private String name;
	private String account_id;

	public void startApplication(Test test) {
		System.out.println("I need you to fillout the following application, but before we start, "
				+ "I would like to notify you that to completely open an account there is a minimum initial deposit requirement of $50");

		System.out.println(
				"If you don't have enough right now for the depoit, you have the option to do the application now and finish the account setup later.");
		System.out.println("Do you want go ahead and do your application now?(yes/no)");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("Okay, here you go. Please fill this out.");
			System.out.println("Full Name: ");
			String nam = keyboard.nextLine();
			setName(nam);
			System.out.println();

			String user;
			do {
				System.out.println("User Name(Will try again if username already exists): ");
				user = keyboard.nextLine();
				// System.out.println();
			} while (checkUser(user));

			String pass;
			do {
				System.out.println("Password(Must be 5-8 characters long): ");
				pass = keyboard.nextLine();
			} while (!checkPassword(pass));
			addLogin(user, pass);
		} else {
			test.stop();
		}
	}

	public Account startJointApplication(Test test, String user) {

		System.out.println("I need you to fillout the following application.");
		System.out.println(
				"We will first need the owner of the account to login to their account for security purposes.");
		System.out.println("Account id: ");
		String id = keyboard.nextLine();
		Account app = Account.findAccount(id);
		if (app == null) {
			System.out.println("I'm sorry, but we don't have an account by that account id.");
			test.stop();
		}
		System.out.println("Username: ");
		String username = keyboard.nextLine();
		System.out.println("Password: ");
		String password = keyboard.nextLine();
		if (app.checkLogin(username, password)) {
			System.out.println(
					"Just so you know this information is what is used to gain access to the account so remember it or write it down.");
			System.out.println("Okay, here you go. Please fill this out.");
			System.out.println("Full Name: ");
			String nam = keyboard.nextLine();
			setName(nam);
		}
		return app;

	}

	public boolean checkUser(String user) {
		return Account.checkUserNames(user);
	}

	public boolean checkPassword(String pass) {
		if (pass.length() < 5 || pass.length() > 8) {
			return false;
		}
		return true;
	}

	
	public static List<Application> getOpenApplications() {
		return openApplications;
	}

	
	public static void setOpenApplications(List<Application> open) {
		Application.openApplications = open;
	}

	public static void addApplication(Application app) {
		Application.openApplications.add(app);
	}

	public static void removeApplication(Application app) {
		Application.openApplications.remove(app);
	}

	public static Application findCustomer(String name) {
		for (int i = 0; i < Application.openApplications.size(); i++) {
			if (Application.openApplications.get(i).getName().equalsIgnoreCase(name)) {
				return Application.openApplications.get(i);
			}
		}
		return null;
	}


	 */
	public Map<String, String> getLogin() {
		return login;
	}

	
	public void setLogin(Map<String, String> login) {
		this.login = login;
	}

	public void addLogin(String username, String password) {
		if (this.login.size() < 1) {
			this.login.put(username, password);
		}
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public String getAccount_id() {
		return account_id;
	}

	
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
}
