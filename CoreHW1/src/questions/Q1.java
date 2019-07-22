package questions;
public class Q1 {
	
	
	public static int[] bubblesort(int ... v){
		
		//boolean to know if it's sorted or not yet
		boolean sorted;

		do
		{
			sorted = true;
			for(int i = 0; i<v.length-1; i++) {
				//compare current value to next value
				if(v[i]>v[i+1]) {
					sorted = false; //it wasn't sorted
					//swap the values
					int temp = v[i];
					v[i] = v[i+1];
					v[i+1] = temp;
				}
			}//end for
		}while(!sorted);//if we had to do any swaps, do another loop
		
		
		return v;
	}//end bubblesort
	
	
}
