package homework1;

import java.util.ArrayList;
import java.util.List;

public class Problem19 {

	static void numDisplay() {

		//Creates an ArrayLists to store numbers
		List<Integer> nums = new ArrayList<Integer>();

		//Adds the numbers 1-10 to the list
		for(int i = 1; i <= 10; i++ ) {
			nums.add(i);
		}

		//Creates the beginning of the print statement
		System.out.println("Q19.) Here are the numbers in this list:");

		//Creates a variables to store the sum of all even numbers & odd numbers in the ArrayList
		int evenSum = 0;
		int oddSum = 0;

		//Uses an enhanced for loop to print out the ArrayList
		//Adds each number of the ArrayList to the total
		for(int y : nums) {
			System.out.print(y + " ");

			if(y % 2 == 0) {
				evenSum += y;  //<--Sums all the even numbers
			}else {
				oddSum += y;  //<--Sums all the odd numbers
			}
		}

		//Prints out both sumations to the user
		System.out.println("\n");
		System.out.println("The sumation of all even numbers in this list is: " + evenSum);
		System.out.println("The sumation of all odd numbers in this list is: " + oddSum + "\n");


		//Gets all prime numbers in the ArrayList by using modulus
		for(int x = 1; x < nums.size()-1; x++ ) {
			boolean prime = true;

			//Test each number 1-10 using modulus
			for (int i = 2; i < nums.get(x); i++) 
				if (nums.get(x) % i == 0) {
					prime = false; //<--Numbers that are not prime will be false
				}
			if(prime) {
				nums.remove(x); //<--Removes only the prime numbers from the ArrayList
			}
		}

		//Prints remaining ArrayList
		System.out.print("The list without any prime numbers will be: ");
		for(int z : nums) {
			System.out.print(z + " ");
		}
		
	}//end numDisplay()

}//end Problem19 class
