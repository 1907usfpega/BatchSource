package homework1;

import java.util.Comparator;

public class EmployeeCompareDept implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return (o1.getDepartment().compareTo(o2.getDepartment()));
	}
	
}
