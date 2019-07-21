/**
 * 
 */
package Customers;

import java.util.ArrayList;
import java.util.List;


/**
 * @author MajorKey
 *
 */
public class Customer {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	
	private String name;
	private String account_id;
	private double funds;
	/**
	 * @param name
	 * @param account_id
	 * @param funds
	 */
	public Customer(String name, String account_id, double funds) {
		super();
		this.name = name;
		this.account_id = account_id;
		this.funds = funds;
	}
	/**
	 * @param name
	 * @param account_id
	 */
	public Customer(String name, String account_id) {
		super();
		this.name = name;
		this.account_id = account_id;
	}
	/**
	 * @param name
	 */
	public Customer(String name) {
		super();
		this.name = name;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @return the customers
	 */
	public static List<Customer> getCustomers() {
		return customers;
	}
	/**
	 * @param customers the customers to set
	 */
	public static void setCustomers(List<Customer> customers) {
		Customer.customers = customers;
	}
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
	 * @return the account_id
	 */
	public String getAccount_id() {
		return account_id;
	}
	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	/**
	 * @return the funds
	 */
	public double getFunds() {
		return funds;
	}
	/**
	 * @param funds the funds to set
	 */
	public void setFunds(double funds) {
		this.funds = funds;
	}
	public void addFunds(double amount) {
		
	}
	public void subtractFunds(double amount) {
		
	}
}
