/**
 * 
 */
package question7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class EmployeeTest {
	
	Employee e1 = new Employee("Deonta", "Software Engineering", 22);
	Employee e2 = new Employee("Vince", "Human Resources", 28);

	
	@Test
	void testNameComparator() {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(e1);
		al.add(e2);
		
		Collections.sort(al, new Employee.NameComparator());
		Iterator<Employee> itr=al.iterator();
		
		assertEquals(e1, (Employee) itr.next());
	}
	
	@Test
	void testDeptComparator() {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(e1);
		al.add(e2);
		
		Collections.sort(al, new Employee.DeptComparator());
		Iterator<Employee> itr=al.iterator();
		
		assertEquals(e2, (Employee) itr.next());
	}
	
	@Test
	void testAgeComparator() {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(e1);
		al.add(e2);
		
		Collections.sort(al, new Employee.AgeComparator());
		Iterator<Employee> itr=al.iterator();
		
		assertEquals(e1, (Employee) itr.next());
	}

}
