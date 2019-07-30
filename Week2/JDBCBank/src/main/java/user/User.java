/**
 * 
 */
package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import account.Account;
import daoimpl.LoginDaoImpl;
import daoimpl.UserDaoImpl;
import login.Login;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class User {
	private int userid;
	private String firstname;
	private String lastname;
	private boolean loggedIn;
	private Scanner keyboard;
	public static ConnFactory cf = ConnFactory.getInstance();

	/**
	 * @param userid
	 * @param firstname
	 * @param lastname
	 */
	public User(int userid, String firstname, String lastname) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	 * @param firstname
	 * @param lastname
	 */
	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
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
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	public static List<User> viewAllUsers() throws SQLException{
		UserDaoImpl list = new UserDaoImpl();
		return list.getAllUsers();
	}
	
	public static User viewUser(int userid) throws SQLException {
		UserDaoImpl list = new UserDaoImpl();
		return list.getUser(userid);
	}
	
	public static User viewCurrentUser() throws SQLException {
		UserDaoImpl list = new UserDaoImpl();
		return list.getCurrentUser();
	}
	
	public static void createUser(String firstname, String lastname) throws SQLException {
		UserDaoImpl list = new UserDaoImpl();
		list.createUser(firstname, lastname);
	}
	
	public static void updateUser(int userid, String firstname, String lastname) throws SQLException {
		UserDaoImpl list = new UserDaoImpl();
		list.updateUser(userid, firstname, lastname);
	}
	
	public static void deleteUser(int userid) throws SQLException {
		UserDaoImpl list = new UserDaoImpl();
		list.deleteUser(userid);
	}

	public void start() throws SQLException {
		System.out.println("Would you like to ");
		System.out.println("1. Register");
		System.out.println("2. Login");
		keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();
		
		if (response.equals("1")) {
			register();
		} else if(response.equals("2")){
			System.out.println("Please sign into the user account: ");
			User user = new Login().userLogin();
			
			if(user != null) {
				user.setLoggedIn(true);
				whatToDo(user);
			}
		}
		
	}
	
	public void register() throws SQLException {
		//enter name
		//enter login
		//check if username available
		//create user
		//getcurrentuser
		//create login with current user userid
		//get login obj
		//create account using login.loginid and login.userid
		//Connection conn = cf.getConnection();
		keyboard = new Scanner(System.in);
		try {
			//.setAutoCommit(false);
			//conn.setSavepoint();
			System.out.println("Please fill out this form.");
			System.out.println("First Name: ");
			String firstname = keyboard.nextLine();
			System.out.println("Last Name: ");
			String lastname = keyboard.nextLine();
			String username = null;
			
			do {
				System.out.println("Username: ");
				username = keyboard.nextLine();
				
				if(!Login.checkUsername(username))
					System.out.println("Please try again that username is not available.");
				
			}while(!Login.checkUsername(username));
			
			System.out.println("Password: ");
			String password = keyboard.nextLine();
			
			System.out.println("End of form....\n");
			
			System.out.println("One second while we set up everything for your account...");
			
			User.createUser(firstname, lastname);
			User user = User.viewCurrentUser();
			
			System.out.println("Right before create login");
			
			Login.createLogin(username, password, user.getUserid());
			Login login = Login.getLogin(username, password);
			
			Account.createAccount(login.getUserId(), login.getLoginId());
			
			//conn.commit();
			//conn.setAutoCommit(true);
			
			user.setLoggedIn(true);
			whatToDo(user);
		} catch (SQLException e) {
			System.out.println("An issue occurred while setting up your account.");
			//conn.rollback();
			e.printStackTrace();
		}
		
	}
	
	public void whatToDo(User user) throws SQLException {
		while(user.isLoggedIn()) {
			keyboard = new Scanner(System.in);
			System.out.println("What would you like to do?");
			System.out.println("1. View All your Accounts");
			System.out.println("2. Create an Account");
			System.out.println("3. Deposit into an Account");
			System.out.println("4. Withdraw from an Account");
			System.out.println("5. Delete an Account");
			System.out.println("6. Logout");
			String response = keyboard.nextLine();
			
			if (response.equals("1")) {
				user.view(user);
			} else if (response.equals("2")) {
				user.create(user);
			} else if (response.equals("3")) {
				user.deposit(user);
			} else if (response.equals("4")) {
				user.withdraw(user);
			} else if (response.equals("5")) {
				user.delete(user);
			} else if (response.equals("6")) {
				user.logout();
			}
		}
	}
	
	public void view(User u) throws SQLException {
		List<Account> accounts = Account.viewAccounts(u.getUserid());
		int length = accounts.size();
		
		for (int i = 0; i < length; i++) {
			System.out.println(accounts.get(i).toString());
		}
	}
	
	public void create(User u) throws SQLException {
		LoginDaoImpl log = new LoginDaoImpl();
		int loginid = log.getLoginId(u.getUserid());
		Account.createAccount(u.getUserid(), loginid);
	}
	public void deposit(User u) throws SQLException {
		System.out.println("Please enter the account id of the account you are trying to deposit to.");
		keyboard = new Scanner(System.in);
		int accountid = keyboard.nextInt();
		Account a = null;
		
		if (accountid > 0) {
			a = Account.checkAccount(accountid,u.getUserid());
			if(a != null) {
				System.out.println("How much would you like to deposit?");
				double amount = keyboard.nextDouble();
				if (amount > 0) {
					Account.depositToAccount(accountid, amount);
				} else {
					System.out.println("You can't deposit a negative number. Go to withdraw.");
				}
			} else {
				System.out.println("That account doesn't belong to you.");
			}
		} else {
			System.out.println("Invalid account.");
		}
		
	}
	public void withdraw(User u) throws SQLException {
		System.out.println("Please enter the account id of the account you are trying to withdraw from.");
		keyboard = new Scanner(System.in);
		int accountid = keyboard.nextInt();
		Account a = null;
		
		if (accountid > 0) {
			a = Account.checkAccount( accountid, u.getUserid());
			if(a != null) {
				System.out.println("How much would you like to withdraw?");
				double amount = keyboard.nextDouble();
				if (amount >= 0 && amount <= a.getBalance()) {
					Account.withdrawFromAccount(accountid, amount);
				} else {
					System.out.println("We don't allow withdrawing a negative number nor overdrafts.");
				}
			} else {
				System.out.println("That account doesn't belong to you.");
			}
		} else {
			System.out.println("Invalid account.");
		}
	}
	public void delete(User u) throws SQLException {
		//check if givenaccountid == dbaccountid && actualuserid==useridtothataccount
		System.out.println("Please enter the account id of the account you are trying to delete.");
		System.out.println("You can only delete empty accounts, so if you need to withdraw first enter 0 for the account id.");
		keyboard = new Scanner(System.in);
		int accountid = keyboard.nextInt();
		Account a = null;
		if (accountid > 0) {
			a = Account.checkAccount(accountid, u.getUserid());
			if(a != null && a.getBalance() == 0) {
				Account.deleteAccount(accountid);
			}
		} 
		//check if account == 0
		//call delete method
	}
	public void logout() {
		setLoggedIn(false);
	}
}
