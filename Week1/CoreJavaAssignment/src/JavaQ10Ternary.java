package Assignment.Java;
import java.util.Scanner;
public class JavaQ10Ternary {
	   static int a,b,min;
	  
	   public static void main(String[] args)
	   {
	       Scanner sc=new Scanner(System.in);
	       System.out.println("enter two numberss");
	       a=sc.nextInt();
	       b=sc.nextInt();
	       min=a<b?a:b;
	       System.out.println("Min of two numbers:");
	       System.out.println(min+" ");
}
}