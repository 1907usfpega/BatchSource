package core;

import java.util.Comparator;

public class Seven implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int)o1.getAge()-o2.getAge();
	}

}
