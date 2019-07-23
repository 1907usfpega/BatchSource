/**
 * 
 */
package Customers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Application.Application;

/**
 * @author MajorKey
 *
 */
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7450933814758381572L;

	private static List<Customer> customers = new ArrayList<Customer>();

	private String name;
	private String account_id;

	public Customer(Application app) {
		this.name = app.getName();
		this.account_id = app.getAccount_id();
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
	
	public Customer() {
		super();
	}
	
	//static getters & setters
	//methods that modify and search the static customers list

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

	public static void addCustomer(Customer cust) {
		Customer.customers.add(cust);
	}

	public static void removeCustomer(Customer cust) {
		Customer.customers.remove(cust);
	}

	public static Customer findCustomer(String name) {
		for (int i = 0; i < Customer.customers.size(); i++) {
			if (Customer.customers.get(i).getName().equalsIgnoreCase(name)) {
				return Customer.customers.get(i);
			}
		}
		return null;
	}

	//non-static getters & setters
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
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", account_id=" + account_id + "]";
	}

}
