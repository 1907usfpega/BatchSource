package Assignment.Java;

public class JavaQ1BubbleSort {

	   public void sortArray(int[] x) {
		   boolean swapped = true;
		   while (swapped) {
			   swapped = false;
		    for(int i=1; i<x.length; i++) {
	         int temp=0;
	         if(x[i-1] > x[i]) {
	            temp = x[i-1];
	            x[i-1] = x[i];
	            x[i] = temp;
	            swapped = true;
	         }
	      }
		   }
	   }

	   public void printArray(int[] x) {
	      for(int i=0; i<x.length; i++)
	        System.out.print(x[i] + " ");
	   }

	   public static void main(String[] args) {
	      
	      JavaQ1BubbleSort b = new JavaQ1BubbleSort();
	      int[] num = {1,0,5,6,3,2,3,7,9,8,4};
	      b.sortArray(num);
	      b.printArray(num);   
	   }
	}