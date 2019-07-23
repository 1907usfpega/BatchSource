/**
 * 
 */
package Employees;

import java.util.Scanner;

import Accounts.Account;
import Application.Application;
import Customers.Customer;
import Driver.Test;

/**
 * @author Deonta Kilpatrick
 * @author Justin Hua
 */
public class Employee {

	protected Account customerAccount;
	protected Customer myCustomer;
	
	private Test test;
	private Scanner keyboard = new Scanner(System.in);

	private String name;

	/**
	 * @param name
	 */
	public Employee(String name, Test test) {
		super();
		this.name = name;
		this.test = test;
	}

	public void start() {
		String response;
		System.out.println("Hello! Welcome to the Grand Simple Bank of Java!");
		System.out.println("My name is " + this.name + ". What is your name?");
		System.out.println("Full Name: ");
		String userName = keyboard.nextLine();
		System.out.println("Nice to meet you " + userName + ".");
		System.out.println(
				"Are you a 'new' or 'returning' customer or do you have an open application, here at the Grand Bank? (new/returning/open application)");

		boolean isChecked = false;
		int numTimes = 1;
		while (!isChecked) {
			response = keyboard.nextLine();

			if (response.equalsIgnoreCase("new")) {

				isChecked = true;

				if (!checkIfReturning(userName)) {
					newCustomer(userName);
				} else {
					System.out.println("The system shows that you already have an account with us.");

					do {
						returningCustomer();
						System.out.println("Do you have anything I can help you with? (yes/no)");
						response = keyboard.nextLine();
					} while (response.equalsIgnoreCase("yes"));

				}
			} else if (response.equalsIgnoreCase("returning")) {

				isChecked = true;

				if (checkIfReturning(userName)) {

					do {
						returningCustomer();
						System.out.println("Do you have anything I can help you with? (yes/no)");
						response = keyboard.nextLine();
					} while (response.equalsIgnoreCase("yes"));

				} else {
					System.out.println(
							"The system is not pulling up any accounts that belong to your name. We need you to make a new account.");
					newCustomer(userName);
				}
			} else if (response.equalsIgnoreCase("open application")) {

				System.out.println("One second let me look for your application.");
				waiting();

				Application app = Application.findCustomer(userName);

				if (app != null) {
					initialDeposit(app);
				} else {
					System.out.println("We don't have an application in the system for you.");
					System.out.println("Would you like to make a new application?(yes/no)");
					response = keyboard.nextLine();
					if (response.equalsIgnoreCase("yes")) {
						newCustomer(userName);
					} else {
						stop();
					}
				}
			} else {

				if (numTimes >= 3) {
					System.out.println("I can't understand you, and we don't "
							+ "have any translators onboard, therefore " + "we can't help you here.");
					stop();
				} else {
					System.out.println("I'm sorry. I don't understand your answer. Please try telling me again.");
				}
				numTimes++;
			}
		}

	}

	public void waiting() {
		this.test.sleep();
	}

	public void stop() {
		this.test.stop();
	}

	public void newCustomer(String userName) {

		System.out.println("Okay, that is fine. Would you like to create a 'new' account with us?");
		System.out.println("Or would you like to apply for a 'joint' account with one of our returning customers?");
		System.out.println("(new/joint/no)");

		String response;
		boolean isChecked = false;
		int numTimes = 1;
		while (!isChecked) {
			response = keyboard.nextLine();

			if (response.equalsIgnoreCase("new")) {
				isChecked = true;
				System.out.println("Okay, come to my office and we can get you started...");
				waiting();
				Application a = new Application();
				a.startApplication(this.test);
				analyzeApplication(userName, a);

			} else if (response.equalsIgnoreCase("joint")) {
				isChecked = true;
				System.out.println("Okay, I will have to send you to my manage...");
				waiting();

				new Admin("Bob", this.test).joint(userName);

			} else if (response.equalsIgnoreCase("no")) {
				stop();

			} else {
				if (numTimes >= 3) {
					System.out.println("I can't understand you, and we don't "
							+ "have any translators onboard, therefore " + "we can't help you here.");
					stop();
				} else {
					System.out.println("I'm sorry. I don't understand your answer. Please try telling me again.");
				}
				numTimes++;
			}
		}
	}

	public void returningCustomer() {

		if (checkLogin()) {

			System.out.println("How may I help you today?(Deposit/Withdraw/Transfer/See Balance/Cancel Account)");

			String response = keyboard.nextLine();
			if (response.equalsIgnoreCase("deposit")) {
				System.out.println("How much money would you like to deposit?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("Okay, just come back another time.");
					stop();
				}

				this.customerAccount.deposit(amount);

			} else if (response.equalsIgnoreCase("withdraw")) {

				System.out.println("How much money would you like to withdraw?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("Okay, just come back another time.");
					stop();
				}

				this.customerAccount.withdraw(amount);

			} else if (response.equalsIgnoreCase("transfer")) {

				System.out.println("How much money would you like to tranfer?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("Okay, just come back another time.");
					stop();
				}

				System.out.println("What is the account id of the account you are transferring money to?");
				response = keyboard.nextLine();
				Account a = Account.findAccount(response);
				if (a != null)
					this.customerAccount.transfer(amount, a);
				else {
					System.out.println("We could not find an account with the corresponding id.");
				}

			} else if (response.equalsIgnoreCase("see balance")) {
				System.out.println("Your balance is $" + checkBalance());

			} else if (response.equalsIgnoreCase("cancel account")) {
				System.out.println("Okay, I'll have to send you to me manager for that....");
				waiting();
				new Admin("Bob", this.test).cancelAccount(this.customerAccount, this.myCustomer);
			} else {
				stop();
			}
		}
	}

	public void analyzeApplication(String userName, Application app) {
		System.out.println("Okay, let me look at your application.");
		System.out.println("I will tell you if you are approved or denied in a second.");
		waiting();
		
		if (!userName.equalsIgnoreCase(app.getName())) {
			deny();
		} else {
			approve(app);
		}
	}

	public void approve(Application app) {

		System.out.println("Thank you for waiting. Your application has been approved.");
		String id = Account.generateAccountID();
		System.out.println("Here is your account id: " + id);
		app.setAccount_id(id);
		initialDeposit(app);
	}

	public void deny() {
		System.out.println("I'm sorry but your application has been denied.");
		stop();

	}

	public void initialDeposit(Application app) {
		System.out.println("Do you have enough for the initial deposit?(yes/no)");
		String response = keyboard.nextLine();
		
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("Okay, how much money would you like to deposit?");
			System.out.println("Remember that the minimum initial deposit is $50.00");
			System.out.println(
					"Your account will NOT be activated and you will have to come finish your application another time if you try to deposit less than the minimum amount.");
			
			response = keyboard.nextLine();
			double amount = 0.0;
			try {
				if (response.subSequence(0, 1).equals("$")) {
					amount = Double.parseDouble(response.substring(1));
				} else {
					amount = Double.parseDouble(response);
				}
			} catch (Exception e) {
				System.out.println(
						"Okay, just come back another time and we can finish setting up your account with us.");
				Application.addApplication(app);
				stop();
			}

			if (amount >= 50.0) {
				Customer.addCustomer(new Customer(app));
				Account.addAccount(new Account(app, amount));
			} else {
				System.out.println(
						"Okay, just come back another time and we can finish setting up your account with us.");
				Application.addApplication(app);
				stop();
			}
		} else {
			System.out.println("Okay, just come back another time and we can finish setting up your account with us.");
			Application.addApplication(app);
			stop();
		}
	}

	public boolean checkIfReturning(String name) {
		// if name is in customers list return true
		// also set checkedAccount = Account.findAccount(customer.getAccount_id)
		// else false
		if (Customer.findCustomer(name) == null) {
			return false;
		}

		this.myCustomer = Customer.findCustomer(name);
		this.customerAccount = Account.findAccount(this.myCustomer.getAccount_id());
		return true;

	}

	public boolean checkLogin() {
		System.out.println("What is your username?");
		String username = keyboard.nextLine();
		System.out.println("What is your password?");
		String password = keyboard.nextLine();
		return customerAccount.checkLogin(username, password);

	}

	public double checkBalance() {
		return customerAccount.getBalance();
	}
	
	public String checkCustomerInfo() {
		return myCustomer.toString();
	}

	// non-static getters & setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * @return the customerAccount
	 */
	public Account getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(Account customerAccount) {
		this.customerAccount = customerAccount;
	}

	/**
	 * @return the myCustomer
	 */
	public Customer getMyCustomer() {
		return myCustomer;
	}

	/**
	 * @param myCustomer the myCustomer to set
	 */
	public void setMyCustomer(Customer myCustomer) {
		this.myCustomer = myCustomer;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
