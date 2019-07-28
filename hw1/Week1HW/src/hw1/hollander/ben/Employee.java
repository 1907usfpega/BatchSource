package hw1.hollander.ben;

public class Employee  implements Comparable<Employee>{
	private String name;
	private String dept;
	private int age;
	
	public Employee() {
		super();
	}
	

	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Employee arg0) {
		return this.getAge()-arg0.getAge();
	}
	
}
//Q7