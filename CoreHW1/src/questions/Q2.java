package questions;

public class Q2 {
	
	public static int[] fibonacci(int n) {
		int[] f = new int[n];
		
		for(int i = 0; i<f.length; i++) {
			//0 and 1
			if(i<2){
				f[i] = i;
			}//end if
			else {
				//calculate next Fibonacci number
				f[i] = f[i-1]+f[i-2];
			}//end else
		}//end for
		return f;
	}//end fibonacci
}//end Q2
