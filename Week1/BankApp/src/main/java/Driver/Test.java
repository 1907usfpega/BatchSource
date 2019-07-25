/**
 * 
 */
package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Accounts.Account;
import Application.Application;
import Customers.Customer;
import Employees.Employee;

/**
 * @author Deonta Kilpatrick
 * @author Justin Hua
 */
public class Test implements Runnable {

	//pulls the txt file data into the program at the beginning
	static {
		final String path = "src/main/resources/Data.txt";
		try {
			File file = new File(path);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);
			//new object input stream for the txt file
			List<Customer> customers = (ArrayList<Customer>) oi.readObject();
			Customer.setCustomers(customers);
			System.out.println("Cutomer read " + customers);
			//reads customer data from the file
			
			List<Account> accounts = (ArrayList<Account>) oi.readObject();
			Account.setAccounts(accounts);
			System.out.println("Account read " + accounts);
			//reads account data
			
			List<Application> applications = (ArrayList<Application>) oi.readObject();
			Application.setOpenApplications(applications);
			System.out.println("Application read" + applications);
			//reads application applications
			oi.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	};

	private static final long serialVersionUID = 1L;
	 
	private Thread thread;
	private boolean running = false;

	public Test() {
		this.start();
	}

	public static void main(String[] args) {
		new Test();

	}

	public synchronized void start() {
		System.out.println("Reached Start");
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	public void run() {
		System.out.println("Reached Run");
		//starts new employee
		if (running) {
			Employee e = new Employee("Jennifer", this);
			e.start();
		}

		stop();
	}

	public synchronized void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void stop() {
		System.out.println("Thank you for stopping by the Grand Simple Bank of Java!!!");
		System.out.println("Hava a nice day!");

		final String path = "src/main/resources/Data.txt";
		
		//writes all the list to the file
		try {
			File file = new File(path);
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream oo = new ObjectOutputStream(fo);

			oo.writeObject(Customer.getCustomers());
			System.out.println("Customers wrote to file.");
			oo.writeObject(Account.getAccounts());
			System.out.println("Accounts wrote to file.");
			oo.writeObject(Application.getOpenApplications());
			System.out.println("Applications wrote to file.");

			oo.close();

			thread.join();
			running = false;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
