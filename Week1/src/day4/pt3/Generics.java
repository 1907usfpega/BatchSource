package day4.pt3;

public class Generics<T> {

	T ob;
	
	Generics(T o){
		ob = o;
	}
	
	//return ob
	T getOb() {
		return ob;
	}
	
	//Show type of T
	void showType() {
		System.out.println("Type of T is: " + ob.getClass().getName());
	}

}//end Generics class
