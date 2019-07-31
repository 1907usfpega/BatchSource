/**
 * 
 */
package Employees;

import Accounts.Account;
import Application.Application;
import Customers.Customer;
import Driver.Test;

/**
 * @author Deonta Kilpatrick
 * @author Justin Hua
 */
public class Admin extends Employee{
//Admin is an employee
	
	/**
	 * @param name
	 * @param test
	 */
	public Admin(String name, Test test) {
		super(name, test);
	}

	public void joint(String userName) {
		System.out.println("Hello " + userName + ". My name is " + this.getName() + ". I was told you want a joint account, so let's get started.");
		
		Application a = new Application();
		Account acc = a.startJointApplication(this.getTest(), userName);
		analyzeApplication(userName, a, acc);
	}
	
	public void analyzeApplication(String userName, Application app, Account acc) {
		System.out.println("Okay, let me look at your application.");
		System.out.println("I will tell you if you are approved or denied in a second.");
		waiting();
		
		if (!userName.equalsIgnoreCase(app.getName())) {
			deny();
		} else {
			approve(app, acc);
		}
	}
	
	public void approve(Application app, Account acc) {

		System.out.println("Thank you for waiting. Your application has been approved.");
		Customer.addCustomer(new Customer(app.getName(),acc.getAccount_id()));
		System.out.println("Make sure you an you keep the login information and the account id safe and handy.");
	}
	
<<<<<<< HEAD
	public void cancelAccount(Customer customer, Account account) { 
		
		System.out.println("Hello. My name is " + this.getName() + ". I was told you want cancel your account, so let's get started.");
		
		Account.removeAccount(account);
		Customer.removeCustomer(customer);
=======
	public void cancelAccount(Account acc, Customer cust) { 
		
		System.out.println("Hello. My name is " + this.getName() + ". I was told you want cancel your account, so let's get started.");
		
		Account.removeAccount(acc);
		Customer.removeCustomer(cust);
>>>>>>> ec17887aa226515703225d76adef61fef521f005
	}
}
