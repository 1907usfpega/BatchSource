package core;

import java.util.ArrayList;
import java.util.List;

public class Nine {
	public void printPrime() {
		List<Integer> p = new ArrayList<Integer>();
		for(int x=1;x<=100;x++) {
			p.add(x);
		}
		for(int x: p) {
			if(prime(x)) {
				System.out.print(x+" ");
			}
		}
			
		
	}
	
	public boolean prime(int n) {
		if(n==1) {return false;}
		for(int x=2;x<n;x++) {
			if(n%x==0) {return false;}
		}
		return true;
	}
}
