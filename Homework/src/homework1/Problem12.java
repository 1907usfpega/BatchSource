package homework1;

public class Problem12 {
	
	static void evenNumbers() {
		
		//Creates a new int array 
		int[] allNums = new int[100];
		
		//Stores all numbers between 1-100 in the array
		for(int i = 0; i < allNums.length; i++) {
			allNums[i] = i + 1;
		}
		
		//Prints the beginning of the output message
		System.out.println("Q12.) All the even numbers between 1-100 are:");
		
		
		//Uses an enhanced for loop to iterate through the array
		//Utilizes modulus to only print the even numbers
		for(int data : allNums){
			if(data % 2 == 0) {
				System.out.print(data + " ");
			}
		}
		
	}//end evenNumbers()

}//end Problem12
