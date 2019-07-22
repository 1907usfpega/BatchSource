/**
 * creates employee bean with nested class that serve as the different comparators for different employee attributes
 */
package question7;

import java.util.Comparator;


/**
 * @author Deonta Kilpatrick
 *
 */
public class Employee {

	private String name;
	private String department;
	private int age;
	
	/**
	 * @param name
	 * @param department
	 * @param age
	 */
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
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
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	static class NameComparator implements Comparator<Employee> {

		public int compare(Employee x, Employee y) {
			return x.getName().compareTo(y.getName());
		}
	}
	static class DeptComparator implements Comparator<Employee> {
		public int compare(Employee x, Employee y) {
			return x.getDepartment().compareTo(y.getDepartment());
		}	
	}
	static class AgeComparator implements Comparator<Employee> {
		public int compare(Employee x, Employee y) {
			if(x.getAge()== y.getAge())  
				return 0;  
			else if(x.getAge() > y.getAge())  
				return 1;  
			else  
				return -1;  
		}	
	}
}
