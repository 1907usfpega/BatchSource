package Assignment.Java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class JavaQ7ComparatorTest {

	@Test
	void test() {
		ArrayList <JavaQ7Comparator> empList = new ArrayList<JavaQ7Comparator>();
		

		empList.add(new JavaQ7Comparator("John",21, "Computer"));

		empList.add(new JavaQ7Comparator("Aston",25, "Math"));

		empList.add(new JavaQ7Comparator("Tom",24, "Science"));

		System.out.println("List before Sorting");


		for (int emp=0; emp<empList.size(); emp++)

		{

		System.out.println(empList.get(emp));

		}

		System.out.println("\n*********************");  

		System.out.println("Sorted list by name: ");

		Collections.sort(empList, new SortByName());

		for (int i=0; i<empList.size(); i++)

		{

		System.out.println(empList.get(i));

		}

		  

		System.out.println("\n********************");  

		System.out.println("Sorted list by age: ");

		Collections.sort(empList, new SortByAge());

		for (int i=0; i<empList.size(); i++)

		{

		System.out.println(empList.get(i));

		}

		System.out.println("***************************");  

		System.out.println("\nSorted list by department: ");

		Collections.sort(empList, new SortByDepartment());

		for (int i=0; i<empList.size(); i++)

		{

		System.out.println(empList.get(i));

	}
	}
}


