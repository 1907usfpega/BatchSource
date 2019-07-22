package com.revature.homework1;

public class Assignment13 {
	//Triangles
	public static boolean lastNumber = true;
    public static void makeTriangle() {
        int stringLength = 1;
       
        while (stringLength < 5) {
            for (int i = 1; i <= stringLength; i++) {
                System.out.print(nextInt());
            }
            System.out.println();
            stringLength++;
        }
       
    }
 
    public static int nextInt() {
        lastNumber = !lastNumber;
        return (lastNumber)?1:0;
    }

}
