package day4.pt3;

public class GenericDemo {

	public static void main(String[] args) {
		
		//Create a Gererics reference for integers
		Generics<Integer> i;
		i = new Generics<Integer>(88);
		i.showType();
		
		//Get value of i
		int v = i.getOb();
		System.out.println("Value: " + v);
		
		System.out.println();
		
		//Create a Gererics reference for Strings
		Generics<String>s = new Generics<String>("Cookies");
		s.showType();
		
		//Get value of s
		String str = s.getOb();
		System.out.println("Value: " + str);

	}//end main

}//end GenericDemo
