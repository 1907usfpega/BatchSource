package core;

import java.io.FileNotFoundException;



public class Driver {

	public static void main(String[] args) {
		
		 One a = new One(); 
		 int[] intArray = new int[]{1,0,5,6,3,2,3,7,9,8,4 };
		 System.out.println("Question 1: ");
		 a.bSort(intArray); 
		 System.out.println("========================================================\n");
		 
		 Two b = new Two();
		 System.out.println("Question 2: ");
		 b.fibNumber();
		 System.out.println("\n========================================================\n");
		 
		 Three c = new Three();
		 System.out.println("Question 3: ");
		 String str = "Galloway";
		 System.out.println("Original string: "+str);
		 System.out.print("Reversed string: ");
		 c.reverseString(str);
		 System.out.println("\n========================================================\n");
		 
		 Four d = new Four();
		 System.out.println("Question 4: ");
		 System.out.println("6! is: "+d.factorial(6));
		 System.out.println("\n========================================================\n");
		 
		 Five e = new Five(); 
		 System.out.println("Question 5: ");
		 String st = "Highflyer";
		 System.out.println("Original string: "+st);
		 System.out.print("Substring: ");
		 e.subString(st, 4);
		 System.out.println("\n========================================================\n");
		 
		 Six f = new Six();
		 System.out.println("Question 6: ");
		 int evenNum= 9;
		 System.out.print("Is "+evenNum+" an even number: ");
		 f.even(evenNum);
		 System.out.println("\n========================================================\n");
		 
		 Seven g = new Seven();
		 System.out.println("Question 7: ");
		 System.out.println("\n========================================================\n");
		
		 Eight h= new Eight(); 
		 System.out.println("Question 8: ");
		 System.out.println("Palindromes in list: ");
		 h.printPalindrome(); 
		 System.out.println("\n========================================================\n");
		 
		 Nine i = new Nine();
		 System.out.println("Question 9: ");
		 System.out.println("Prime number between 1 and 100: ");
		 i.printPrime();
		 System.out.println("\n========================================================\n");
		 
		 Ten j = new Ten(); 
		 int n1 =4;
		 int n2 = 3;
		 System.out.println("Question 10: ");
		 System.out.print("Minimum value of "+n1+" and "+n2+" is: ");
		 j.minV(n1, n2);
		 System.out.println("\n========================================================\n");
		 
		 Eleven k = new Eleven();
		 System.out.println("Question 11: ");
		 k.accessEleven2(2F,67.999888F);
		 System.out.println("\n========================================================\n");
		 
		 Twelve l = new Twelve();
		 System.out.println("Question 12: ");
		 l.printEven(10);
		 System.out.println("\n========================================================\n");
		 
		 Thirteen m =new Thirteen();
		 System.out.println("Question 13: ");
		 m.printSteps();
		 System.out.println("\n========================================================\n");
		 
		 Fourteen n = new Fourteen();
		 int switcher =1;
		 System.out.println("Question 14: ");
		 System.out.println("Switch case "+switcher);
		 n.switchCase(switcher);
		 System.out.println("\n========================================================\n");
		 
		 Fifteen o = new Fifteen();
		 System.out.println("Question 15: ");
		 o.add(10, 7);
		 System.out.println("\n========================================================\n");
		 
		 Sixteen p = new Sixteen();
		 System.out.println("Question 16: ");
		 System.out.println("The number of arguments is: "+args.length);
		 System.out.println("\n========================================================\n");
		 
		 Seventeen q = new Seventeen();
		 System.out.println("Question 17: ");
		 q.calInterest();
		 System.out.println("\n========================================================\n");
		 
		 Eighteen r = new Eighteen();
		 System.out.println("Question 18: ");
		 System.out.println(r.checkUppercase("kooOol"));
		 System.out.println(r.convertToUppercase("koool"));
		 r.convertToInteger("777");
		 System.out.println("\n========================================================\n");
		 
		 NineTeen s = new NineTeen();
		 System.out.println("Question 19: ");
		 s.arrayStuff();
		 System.out.println("\n========================================================\n");
		 
		 Twenty t = new Twenty();
		  System.out.println("Question 20: ");
		try {
			t.readData();
		} catch (FileNotFoundException u) {
			// TODO Auto-generated catch block
			u.printStackTrace();
		}
	}

}
