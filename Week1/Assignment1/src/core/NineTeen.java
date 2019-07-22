package core;

import java.util.ArrayList;
import java.util.List;

public class NineTeen {
	public String arrayStuff() {
		List<Integer> a = new ArrayList<Integer>();
		Nine b =  new Nine();
		for (int i = 1; i < 11; i++) {
			a.add(i);
		}
		System.out.println("Original array: "+a.toString());
		
		int even =0;
		for (int i = 1; i <a.size(); i=i+2) {
			even=even+a.get(i);
		}
		System.out.println("Even number sum: "+even);
		
		int odd =0;
		for (int i = 1; i <a.size(); i=i+2) {
			odd+=a.get(i);
		}
		System.out.println("Odd number sum: "+odd);
		
		for (int i = 0; i < a.size(); i++) {
			//System.out.println(a.toString());
			if(b.prime(a.get(i))) {
				
				a.remove(i);
				
			}
		}
		a.remove(1);
		String result = a.toString();
		System.out.println("Array after removing prime numbers: "+result);
		return result;
	}
}
