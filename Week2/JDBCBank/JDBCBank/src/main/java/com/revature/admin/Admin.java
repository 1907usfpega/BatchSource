package com.revature.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.login.Login;
import com.revature.user.User;



public class Admin {

	private int adminid;
	private String firstname;
	private String lastname;
	private boolean loggedIn;
	private static Scanner keyboard;
	
	/**
	 * @param adminid
	 * @param firstname
	 * @param lastname
	 * @param loggedIn
	 */
	public Admin(int adminid, String firstname, String lastname, boolean loggedIn) {
		super();
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.loggedIn = loggedIn;
	}
	/**
	 * @param adminid
	 * @param firstname
	 * @param lastname
	 */
	public Admin(int adminid, String firstname, String lastname) {
		super();
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * @param firstname
	 * @param lastname
	 */
	public Admin(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * @return the adminid
	 */
	public int getAdminid() {
		return adminid;
	}
	/**
	 * @param adminid the adminid to set
	 */
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	public static void start() throws SQLException {
		System.out.println("Please sign into your own admin account: ");
		Admin a = new Login().adminLogin();
		
		if(a != null) {
			a.setLoggedIn(true);
			whatToDo(a);
		}
	}
	public static void whatToDo(Admin a) throws SQLException {
		while(a.isLoggedIn()) {
			keyboard = new Scanner(System.in);
			System.out.println(" ");
			System.out.println("Choose Admin options:");
			System.out.println("------------------------");
			System.out.println("1. View All Bank Users");
			System.out.println("2. View Individual Bank Users");
			System.out.println("3. Create Bank Users");
			System.out.println("4. Update Bank Users");
			System.out.println("5. Delete Bank Users");
			System.out.println("6. Logout");
			String response = keyboard.nextLine();
			
			if (response.equals("1")) {
				a.viewAll();
			} else if (response.equals("2")) {
				a.view();
			} else if (response.equals("3")) {
				a.create();
			} else if (response.equals("4")) {
				a.update();
			} else if (response.equals("5")) {
				a.delete();
			} else if (response.equals("6")) {
				a.logout();
			}
		}
	}
	
	public void viewAll() throws SQLException {
		List<User> users = User.viewAllUsers();
		int length = users.size();
		
		for (int i = 0; i < length; i++) {
			System.out.println(users.get(i).toString());
		}
	}
	
	public void view() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("Please enter userid you want to view:");
		int userid = keyboard.nextInt();
		keyboard.nextLine();
		
		User user = User.viewUser(userid);
		
		if(user == null) {
			System.out.println("That is not a valid userid.");
		} else {
			System.out.println(user.toString());
		}
	}
	
	public void create() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("Enter the user's information:");
		System.out.println("First Name: ");
		String firstname = keyboard.nextLine();
		System.out.println("Last Name: ");
		String lastname = keyboard.nextLine();
		User.createUser(firstname, lastname);
	}
	
	public void update() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("Please enter the userid you want to update:");
		int userid = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("What will be this user's new name?");
		System.out.println("First Name: ");
		String firstname = keyboard.nextLine();
		System.out.println("Last Name: ");
		String lastname = keyboard.nextLine();
		User.updateUser(userid, firstname, lastname);
	}
	
	public void delete() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("Please enter the userid you want to delete:");
		int userid = keyboard.nextInt();
		keyboard.nextLine();
		User.deleteUser(userid);
	}
	
	public void logout() {
		setLoggedIn(false);
	}
	
}

