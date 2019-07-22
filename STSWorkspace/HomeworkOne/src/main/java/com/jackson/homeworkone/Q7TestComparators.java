package com.jackson.homeworkone;

public class Q7TestComparators 
{
	public Employee e1, e2;
	
	public Q7TestComparators()
	{
		e1 = new Employee("Bill Smith", "Human Resources", 44);
		e2 = new Employee("Jane Doe", "Customer Service", 21);
	}
	
	public Q7TestComparators(Employee e1, Employee e2)
	{
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public boolean testAgeCompare()
	{
		Q7AgeCompare q7Age = new Q7AgeCompare();
		if(q7Age.compare(e1, e2) <= 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean testNameCompare()
	{
		Q7NameCompare q7Name = new Q7NameCompare();
		if(q7Name.compare(e1, e2) <= 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean testDepartmentCompare()
	{
		Q7DepartmentCompare q7Department = new Q7DepartmentCompare();
		if(q7Department.compare(e1, e2) <= 0)
		{
			return true;
		}
		return false;
	}
	
	/*public static void main(String[] args)
	{
		Q7TestComparators q7 = new Q7TestComparators();
		System.out.println(q7.testAgeCompare());
		System.out.println(q7.testNameCompare());
		System.out.println(q7.testDepartmentCompare());
	}*/
}
