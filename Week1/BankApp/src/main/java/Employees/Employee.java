/**
 * 
 */
package Employees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MajorKey
 *
 */
public class Employee {

	private static List<Employee> employees = new ArrayList<Employee>();
	
	private String name;
	
	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	public void start() {
		
	}
	public void stop() {
		
	}
	public void analyzeApplication() {
		
	}
	public void approve(){
		
	}
	public void deny() {
		
	}
	public void checkCustomers() {
		
	}
	public void checkCustomers(String name) {
		
	}
	public void transactions() {
		
	}
	public void checkBalances() {
		
	}
	/**
	 * @return the employees
	 */
	public static List<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public static void setEmployees(List<Employee> employees) {
		Employee.employees = employees;
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
	
}
