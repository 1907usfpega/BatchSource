package homework1;

public class Driver extends UserInput{  
	
	public static void main(String[] args) {
		
		System.out.println("Question Selection");
		System.out.println("Please enter a number 1-20:");
		int question = isInt();
		
		while(question <= 0 | question > 20) {
			System.out.println("Invalid input. Please enter a number 1-20:");
			question = isInt();
		}
		
		switch(question) {
		case 1:
			int[] sort = {1,0,5,6,3,2,3,7,9,8,4};  //<--Creates an int[] to be sorted
			Problem1.bubbleSort(sort); 
			break;
		case 2:
			Problem2.fibonacci();
			break;
		case 3:
			Problem3.reverseString();
			break;
		case 4:
			Problem4.factorial();
			break;
		case 5:
			Problem5.indexString();
			break;
		case 6:
			Problem6.evenOdd();
			break;
		case 7:
			Problem7.sortEmployees();
			break;
		case 8:
			Problem8.palindromes();
			break;
		case 9:
			Problem9.primeNumbers();
			break;
		case 10:
			Problem10.minimum();
			break;
		case 11:
			Problem11.callFloats();
			break;
		case 12:
			Problem12.evenNumbers();
			break;
		case 13:
			Problem13.triangle(); 
			break;
		case 14:
			Problem14.switchCase();
			break;
		case 15:
			Problem15.main(args);
			break;
		case 16:
			Problem16.main(args); //<--"Problem16" passed in on my args
			break;
		case 17:
			Problem17.interest();
			break;
		case 18:
			Problem18.main(args);
			break;
		case 19:
			Problem19.numDisplay();
			break;
		case 20:
			Problem20.writeAndRead();
			break;
		}

	}//end main

}//end Driver class
