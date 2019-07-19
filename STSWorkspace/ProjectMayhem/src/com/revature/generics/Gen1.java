package com.revature.generics;

public class Gen1<T>
{
	//declare an object of type T (generic type)
	T obj;
	//pass constructor a reference to an object of type T
	Gen1(T o)
	{
		obj = o;
	}
	
	//return obj
	T getObj()
	{
		return obj;
	}
	
	//show type of T
	void showType()
	{
		System.out.println("Type of T is: "+obj.getClass().getName());
	}
}
