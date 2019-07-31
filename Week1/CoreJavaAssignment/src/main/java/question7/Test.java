/**
 * 
 */
package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creates a list of two employees
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("Deonta", "Software Engineering", 22));
		al.add(new Employee("Vince", "Human Resources", 28));
		
		//utilizing the collections utitility method to sort the list using the different comparators
		Collections.sort(al, new Employee.NameComparator());
		
		System.out.println("Name Comparator: ");
		Iterator<Employee> itr=al.iterator();
		System.out.println(((Employee) itr.next()).toString());
		System.out.println(((Employee) itr.next()).toString());
		
		Collections.sort(al, new Employee.DeptComparator());
		
		System.out.println("Department Comparator: ");
		Iterator<Employee> itr2 =al.iterator();
		System.out.println(((Employee) itr2.next()).toString());
		System.out.println(((Employee) itr2.next()).toString());
		
		Collections.sort(al, new Employee.AgeComparator());
		
		System.out.println("Age Comparator: ");
		Iterator<Employee> itr3=al.iterator();
		System.out.println(((Employee) itr3.next()).toString());
		System.out.println(((Employee) itr3.next()).toString());

	}

}
