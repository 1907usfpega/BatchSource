package day4.pt2;

public class Arrays {

	public static void main(String[] args) {
		
		int s = 7;
		int[] myArray = new int[s]; //<--Makes new Array and declares its size
		//int myArray[] = new int[s]; Also works
		
		int[] odds = {3,5,7,9,11,13}; //<--Presets values in an array
		
		System.out.println(myArray[1]); //<--Default int value is 0
		
		System.out.println(odds[1]); //<--Prints number 5
		System.out.println(odds); //<--Prints memory location of the Array
		System.out.println();
		
		
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 5;
			System.out.println(i + "'s element is " + myArray[i]);
		}
		
		System.out.println();
		
		for(int i:odds) {
			System.out.println(i);
		}
		
	}//end main

}//end Arrays class
