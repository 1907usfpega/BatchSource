package core;

import corej.Eleven2;

public class Eleven {
	//This method prints a float from the class Eleven2
	public String accessEleven2(float one, float two) {
		Eleven2 a = new Eleven2(one, two);
		String b ="";
		System.out.println("First float: "+a.getOne());
		System.out.println("Second float: "+a.getTwo());
		b= b+""+a.getOne()+" "+a.getTwo();
		return b;
	}
}
