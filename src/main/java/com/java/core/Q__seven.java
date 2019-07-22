package com.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee{
	String name;
	String department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	int age;
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
}


//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
public class Q__seven  {
	
		// TODO Auto-generated constructor stub
	

public static void main(String[] args) {
		// TODO Auto-generated method stub
 ArrayList<Employee>Employees = new ArrayList();
 ArrayList<String>names= new ArrayList();
 ArrayList<Integer>ages=new ArrayList();
//Collections.sort(stringList,new SortComparator());
Employee empl = new Employee();
    empl.name = "ken";
    empl.department="science";
    empl.age=23;
    Employees.add(empl);
Employee empl2 = new Employee();
    empl2.name="sarah";
    empl2.department="chemistry";
    empl2.age=21;
    Employees.add(empl2);
    


   int XAge;
   int YAge;
   Employee info = new Employee();
    for(int x = 0; x<Employees.size()-1;x++) {
    	info = Employees.get(x);
    	names.add(info.getName());
    	info = Employees.get(x+1);
        names.add(info.getName());
    }

    for(int x = 0; x<Employees.size()-1;x++) {
    	info = Employees.get(x);
    	names.add(info.getDepartment());
    	info = Employees.get(x+1);
        names.add(info.getDepartment());
    } 
    
Collections.sort(names, new SortComparator());
System.out.println("Sort by names"+names);
names.clear();

Employee empDepart = new Employee();
for(int x = 0; x<Employees.size()-1;x++) {
	empDepart = Employees.get(x);
	names.add(empDepart.getDepartment());
	empDepart = Employees.get(x+1);
    names.add(info.getDepartment());
}
Collections.sort(names, new SortComparator());
System.out.println("Sort by Department"+names);
names.clear();

Employee empAge = new Employee();
for(int x = 0; x<Employees.size()-1;x++) {
	empAge = Employees.get(x);
	ages.add(empAge.getAge());
	empAge = Employees.get(x+1);
    ages.add(empAge.getAge());

	}
Collections.sort(ages, new AgeComparator());
System.out.println("Sort by Ages "+ages);
names.clear();
}}
