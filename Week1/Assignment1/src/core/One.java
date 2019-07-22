package core;

import java.util.Arrays;

public class One {

	public One() {
		
	}
	public String bSort( int[] a) {
		System.out.println("Before Bubble Sort: "+Arrays.toString(a));
	    for(int k = 0; k< a.length-1; k++) {
	        for(int i = 0; i < a.length-k-1; i++) {
	            if(a[i] > a[i+1] ) {
	            	int x=a[i+1];
	            	a[i+1]=a[i];
	            	a[i]=x;
	               // temp = a[ i ];
	              //  a[i] = a[i+1];
	               // a[i+1] = temp;
	            }
	        }
	    }
	  System.out.println("After Bubble Sort: "+Arrays.toString(a));
	  return Arrays.toString(a);
	}
	

}
