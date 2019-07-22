package questions;

public class Q6 {
	public static boolean isEven(int i) {
		//if it's odd, integer division will truncate the value, so that remultiplying it by two will not return the original value
		return (i/2*2==i);
	}
	//overloading so we can pass in a bunch of integers. also uses recursion
	public static boolean[] isEven(int ... v) {
		boolean[] b = new boolean[v.length];
		for(int i = 0; i<v.length; i++) {
			b[i] = isEven(v[i]);
		}
		return b;
	}
	

}
