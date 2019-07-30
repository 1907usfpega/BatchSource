/**
 * 
 */
package admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import login.Login;
import user.User;

/**
 * @author MajorKey
 *
 */
public class Admin {

	private int adminid;
	private String firstname;
	private String lastname;
	private boolean loggedIn;
	private Scanner keyboard;
	
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
	public void start() throws SQLException {
		System.out.println("Please sign into the admin account: ");
		Admin a = new Login().adminLogin();
		
		if(a != null) {
			a.setLoggedIn(true);
			whatToDo(a);
		}
	}
	public void whatToDo(Admin a) throws SQLException {
		while(a.isLoggedIn()) {
			keyboard = new Scanner(System.in);
			System.out.println("What would you like to do?");
			System.out.println("1. View All Users");
			System.out.println("2. View a User");
			System.out.println("3. Create a User");
			System.out.println("4. Update a User");
			System.out.println("5. Delete a User");
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
		System.out.println("What is the userid of the user you want to see?");
		int userid = keyboard.nextInt();
		
		User user = User.viewUser(userid);
		
		if(user == null) {
			System.out.println("That is not a valid userid.");
		} else {
			System.out.println(user.toString());
		}
	}
	
	public void create() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("What will be this user's name?");
		System.out.println("First Name: ");
		String firstname = keyboard.nextLine();
		System.out.println("Last Name: ");
		String lastname = keyboard.nextLine();
		User.createUser(firstname, lastname);
	}
	
	public void update() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("What is the userid of the user you want to update.");
		int userid = keyboard.nextInt();
		System.out.println("What will be this user's new name?");
		System.out.println("First Name: ");
		String firstname = keyboard.nextLine();
		System.out.println("Last Name: ");
		String lastname = keyboard.nextLine();
		User.updateUser(userid, firstname, lastname);
	}
	
	public void delete() throws SQLException {
		keyboard = new Scanner(System.in);
		System.out.println("What is the userid of the user you want to delete.");
		int userid = keyboard.nextInt();
		User.deleteUser(userid);
	}
	
	public void logout() {
		setLoggedIn(false);
	}
	
}
