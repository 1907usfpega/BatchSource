package com.revature.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.TransactionDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

/*
 * Menu specific to admin based functions. Should note that some functions available to Admins not available for other Employees.
 * TODO: Introduce sleep commands in get methods to introduce a time delay? | Do exception handling for invalid logins, acctNo, etc.
 */

public class AdminMenu extends Menu {
	private static Employee empl = null;
	private static Customer cust = null;
	private static Account acct = null;
	private static double val;
	
	private static EmployeeDaoImpl edi = null;
	private static AccountDaoImpl adi = null;
	private static UserDaoImpl udi = null;
	private static TransactionDaoImpl tdi = null;


	
	public static void login()
	{
		edi = new EmployeeDaoImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your username.");
		String username = in.next();
		System.out.println("Please enter your password.");
		String password = in.next();
		try {
			empl = edi.getEmployee(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainMenu(empl);
	}

	private static void mainMenu(Employee employee) {
		System.out.println("Welcome back, " + employee.getFirstname() + ".\n");
		System.out.println("MAIN MENU");
		System.out.println("1. Account tools \n2. Employee tools \n3. Admin tools \n4. Log off");
		Scanner in = new Scanner(System.in);
		int sel = in.nextInt();
		switch (sel)
		{
			case 1:
			{
				adi = new AccountDaoImpl();
				System.out.println("What's the account number?");
				int acctId = in.nextInt();
				try {
					acct = adi.getAccountbyNo(acctId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accountMenu(employee, acct);
				break;
			}
			case 2:
			{
				employeeMenu(employee);
				break;
			}
			case 3:
			{
				if (employee.getType().equals("admin"))
				{
					adminMenu(employee);
				}
				else
				{
					System.out.println("We're sorry, you must be an administrator to have access. Please go somewhere else. :D");
					mainMenu(employee);
				}
				break;
			}
			case 4:
			{
				in.close();
				System.out.println("Logging off. Thank you for your service!");
				System.exit(0);
			}
			default:
			{
				mainMenu(employee);
			}
		}
		
	}

	//Admin tools include getting lists of users/accounts, as well as deleting/altering accounts. Should also be only way to alter
	//employee info.
	private static void adminMenu(Employee employee) {
		edi = new EmployeeDaoImpl();
		adi = new AccountDaoImpl();
		tdi = new TransactionDaoImpl();

		Scanner in = new Scanner(System.in);
		System.out.println("ADMIN MENU");
		System.out.println();
		System.out.println("1. Get User List     2. Get Account List \n3. Credit/charge account      4. Remove bank account \n5. Remove user account"
				+ "     6. Create employee account \n7. Remove employee account      8. Return to main menu");
		int sel = in.nextInt();
		
		switch (sel)
		{
			//Returns list of Customers.
			case 1:
			{
				try {
					System.out.println("Current list of users:");
					ArrayList<Customer> custList = new ArrayList<Customer>(edi.getCustomerList());
					for(int i = 0; i < custList.size(); i++)
					{
						System.out.println(custList.get(i).toString());
					}
					System.out.println();
					System.out.println("Returning to admin menu.");
					adminMenu(employee);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			//Returns list of bank accounts. 
			case 2:
			{
				try {
					System.out.println("Current list of accounts:");
					ArrayList<Account> accountList = new ArrayList<Account>(adi.getAccountList());
					for(int i = 0; i < accountList.size(); i++)
					{
						System.out.println(accountList.get(i).toString());
					}
					System.out.println();
					System.out.println("Returning to admin menu.");
					adminMenu(employee);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			//Charges or credits account.
			case 3:
			{
				System.out.println("What is the account number?");
				int acctNo = in.nextInt();
				try {
					acct = adi.getAccountbyNo(acctNo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("What is the amount of the transaction?");
				val = in.nextDouble();
				System.out.println("Will this be a credit or charge?");
				String ans = in.nextLine();
				if (ans.equals("credit"))
				{
					System.out.println("Crediting account #" + acctNo + " the amount of " + val);
					try {
						tdi.makeDeposit(acct, val);
						System.out.println("Credit complete. Returning to admin menu.");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("SQL error. Might wanna check your numbers, ya dingus.");
						e.printStackTrace();
					}
					finally
					{
						adminMenu(employee);
					}
					
				}
				else if (ans.equals("charge"))
				{
					System.out.println("Charging account #" + acctNo + " the amount of " + val);
					try {
						tdi.makeWithdrawal(acct, val);
						System.out.println("Done. Returning to admin menu.");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("SQL error. Might wanna check your numbers, ya dingus.");
						e.printStackTrace();
					}
					finally
					{
						adminMenu(employee);
					}
				}
				else
				{
					System.out.println("Didn't catch that. Please try again.");
					adminMenu(employee);
				}
				break;
			}
			//Removes bank account. Admin does not require zero balance req that Customer does.
			case 4:
			{
				System.out.println("What is the bank account number?");
				int acctId = in.nextInt();
				try {
					acct = adi.getAccountbyNo(acctId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("This cannot be reversed. Are you sure? (y/n)");
				String ans = in.nextLine();
				if (ans.equals("y"))
				{
					try {
						adi.closeAccount(acctId);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Returning to admin menu.");
					adminMenu(employee);
				}
				break;
			}
			//Removes user account. Should ensure bank accounts are removed first due to foreign key shenanigans.
			case 5:
			{
				System.out.println("What is the User ID?");
				int userId = in.nextInt();
				//TODO: Flesh out case once UDI method is complete.
				System.out.println("We'll fix it in post. Returning to admin menu.");
				adminMenu(employee);
				break;
			}
			//Creates employee account.
			case 6:
			{
				System.out.println("Account Creation");
				System.out.println();
				System.out.println("First name:");
				String firstname = in.nextLine();
				System.out.println("Last name:");
				String lastname = in.nextLine();
				System.out.println("Email address:");
				String email = in.nextLine();
				System.out.println("Home address:");
				String address = in.nextLine();
				System.out.println("City:");
				String city = in.nextLine();
				System.out.println("State: (EX: FL, CA)");
				String state = in.nextLine();
				System.out.println("Username:");
				String username = in.nextLine();
				System.out.println("Password:");
				String password = in.nextLine();
				System.out.println("Employee type: (employee/admin)");
				String type = in.nextLine();
				
				System.out.println("Name: " + firstname + " " + lastname + "  Email: " + email);
				System.out.println("Address: " + address + " " + city + "," + state);
				System.out.println("Username: " + username + "  Password: " + password);
				System.out.println("Is this correct? (y/n)");
				String ans = in.next();
				if (ans.equals("y"))
				{
					System.out.println("Great. We'll get everything set up now. One moment.");
					try {
						edi.createEmployee(firstname, lastname, email, address, city, state, username, password, type);
						System.out.println("Employee account created successfully.");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						System.out.println("Returning to admin menu.");
						adminMenu(employee);
					}
				}
				else
				{
					System.out.println("OK. Let's try that again.");
					adminMenu(employee);
				}
				break;
			}
			//Removes employee account.
			case 7:
			{
				System.out.println("What is the employee's ID number?");
				int emplId = in.nextInt();
				//TODO: Implement this once remove employee method is complete.
				System.out.println("Pardon the dust. Returning to admin menu.");
				adminMenu(employee);
				break;
			}
			//Returns to main menu.
			case 8:
			{
				System.out.println("Returning...");
				mainMenu(employee);
				break;
			}
			default:
			{
				adminMenu(employee);
				break;
			}
		}
		
	}

	//Basic employee related functions. May be irrelevant. Might remove. (Or handle other user account functions that don't require admin privs.)
	//TODO: Implement custom statements that do not rely on user/pw combos, and do not return those when requesting data. Add "Update employee" account case.
	private static void employeeMenu(Employee employee) {
		udi = new UserDaoImpl();
		Scanner in = new Scanner(System.in);
		
		System.out.println("EMPLOYEE MENU\n");
		System.out.println("\n1. View user account \n2. Edit user account \n3. Create user account \n4. View employee account \n5. Main menu");
		int sel = in.nextInt();	
		
		switch (sel)
		{
			//Views user account. Not working correctly? Interesting. Second print statement before second input.
			//Might need sleep to delay it? Or should I rather create a new query statement?
			case 1:
			{
				System.out.println("What is the user's username?");
				String username = in.next();
				
				System.out.println("What is the user's password?");
				String password = in.nextLine();
				try {
					cust = udi.getCustomer(username, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(cust.toString());
				System.out.println();
				System.out.println("Returning to employee menu.");
				employeeMenu(employee);
				break;
			}
			//Alters user account.
			case 2:
			{
				udi = new UserDaoImpl();
				
				System.out.println("What is the user ID?");
				int userId = in.nextInt();
				System.out.println("What needs to be changed?");
				System.out.println("FIRSTNAME | LASTNAME | EMAIL | ADDRESS | CITY | STATE | PASSWORD ");
				String ans = in.next();
				if (ans.equals("FIRSTNAME") == false || ans.equals("LASTNAME") == false || ans.equals("EMAIL") == false || ans.equals("ADDRESS") == false
						|| ans.equals("CITY") == false || ans.equals("STATE") == false || ans.equals("PASSWORD") == false)
				{
					System.out.println("Sorry, we didn't catch that. Please try again.");
					employeeMenu(employee);
				}
				else
				{
					System.out.println("What's the new one?");
					String newVal = in.next();
					System.out.println("OK. We'll change " + ans + " to " + newVal);
					try {
						udi.updateCustomer(userId, ans, newVal);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						employeeMenu(employee);
					}
					break;
				}
			}
			//Creates user account. Gonna go ahead and call NewCustomerMenu for sake of simplicity. Will require employee to login again, however.
			case 3:
			{
				NewCustomerMenu.getUserParams();
				break;
			}
			//Views employee account.
			case 4:
			{
				System.out.println(employee.toString());
				System.out.println();
				employeeMenu(employee);
			}
			//Returns to main menu.
			case 5:
			{
				mainMenu(employee);
			}
			default:
			{
				employeeMenu(employee);
			}
		}
	}

	//Bank account related functions. Allows for getting balances & making transactions (may alter Admin transactions for considerations).
	private static void accountMenu(Employee employee, Account account) {
		adi = new AccountDaoImpl();
		tdi = new TransactionDaoImpl();
		
		//Creates a new account object to reflect updates in DB.
		Account acct = null;
		try {
			acct = adi.getAccountbyNo(account.getAcctNo());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.println("ACCOUNT MENU");
		System.out.println();
		
		System.out.println("What would you like to do?");
		System.out.println("1. Account balance. \n2. Deposit \n3. Withdrawal \n4. Transfer \n5. Transaction history \n6. Main menu");
		int sel = in.nextInt();
		
		switch (sel)
		{
			case 1:
			{
				System.out.println(acct.getBalance());
				System.out.println();
				accountMenu(employee, acct);
				break;
			}
			//Deposits.
			case 2:
			{
				System.out.println("What is the amount of the transaction?");
				val = in.nextDouble();
				try {
					tdi.makeDeposit(acct, val);
					System.out.println("Deposit made successfully. Returning to top menu.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("SQL error. Might wanna check your numbers, ya dingus.");
					e.printStackTrace();
				}
				finally
				{
					accountMenu(employee, acct);
				}
				break;
			}
			//Withdrawals
			case 3:
			{
				System.out.println("What is the amount of the transaction?");
				val = in.nextDouble();
				try {
					tdi.makeWithdrawal(acct, val);
					System.out.println("Withdrawal complete. Returning to admin menu.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("SQL error. Might wanna check your numbers, ya dingus.");
					e.printStackTrace();
				}
				finally
				{
					accountMenu(employee, acct);
				}
				break;
			}
			//Transfers
			case 4:
			{
				System.out.println("What is the amount of the transaction?");
				val = in.nextDouble();
				System.out.println("What is the account number to transfer to?");
				int targetId = in.nextInt();
				try {
					tdi.makeXfer(acct, adi.getAccountbyNo(targetId), val);
					System.out.println("Transfer complete. Returning to top menu.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					accountMenu(employee, acct);
				}
				break;
			}
			//Returns transaction history.
			case 5:
			{
				try {
					System.out.println("TRANSACTION HISTORY");
					ArrayList<Transaction> transList = new ArrayList<Transaction>(tdi.transactionList(acct.getAcctNo()));
					for (int i = 0; i < transList.size(); i++)
					{
						System.out.println(transList.get(i).toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					accountMenu(employee, acct);
				}
			}
			//Returns to main menu.
			case 6:
			{
				mainMenu(employee);
				break;
			}
			default:
			{
				accountMenu(employee, acct);
			}
		}	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
