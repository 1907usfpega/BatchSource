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
 * @author MajorKey
 *
 */
public class Test implements Runnable{
	
	static {
		final String path = "src/main/resources/Data.txt";
		try {
			File file = new File(path);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			List<Customer> customers = (ArrayList<Customer>) oi.readObject();
			Customer.setCustomers(customers);
			System.out.println("Cutomer read " + customers);
			
			List<Account> accounts = (ArrayList<Account>) oi.readObject();
			Account.setAccounts(accounts);
			System.out.println("Account read " + accounts);
			
			List<Application> applications = (ArrayList<Application>) oi.readObject();
			Application.setOpenApplications(applications);
			System.out.println("Application read" + applications);
			
			oi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private boolean running = false;
	
	public Test() {
		this.start();
	}
	
	public static void main(String[] args)
	{
		new Test();

	}

	public synchronized void start()
	{
		System.out.println("Reached Start");
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void stop()
	{
		System.out.println("Thank you for stopping by the Grand Simple Bank of Java!!!");
		System.out.println("Hava a nice day!");
		
		final String path = "src/main/resources/Data.txt";
		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			thread.join();
			running = false;
			//also write to files.
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		System.out.println("Reached Run");
		
		if(running) 
		{
			Employee e = new Employee("Jennifer", this);
			e.start();
		}
		//final String path = "src/main/resources/Data.txt";
		
		/*Outputstream- writes to file
		 * try {
			File file = new File(path);
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			//Account a = new Account();
			//a.setAccount_id("66666");
			//Account.addAccount(a);
			oo.writeObject(Customer.getCustomers());
			System.out.println("Cutomer wrote");
			oo.writeObject(Account.getAccounts());
			System.out.println("Account wrote");
			oo.writeObject(Application.getOpenApplications());
			System.out.println("Application wrote");
			oo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*Inputstream- reads from file
		 * try {
			File file = new File(path);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);
			List<Customer> customers = (ArrayList<Customer>) oi.readObject();
			System.out.println("Cutomer read " + customers);
			List<Account> accounts = (ArrayList<Account>) oi.readObject();
			System.out.println("Account read " + accounts);
			List<Application> applications = (ArrayList<Application>) oi.readObject();
			System.out.println("Application read" + applications);
			oi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		stop();
	}
}
