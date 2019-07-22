package questions;
import java.util.Calendar;
import java.util.Date;

public class Q14 {

	public static void switchCase(int i) {
		switch (i) {
		case 1:
			int num = 16;
			System.out.println("Finding the square root of "+num+":");
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			System.out.println("Today's Date:");
			Date today = Calendar.getInstance().getTime();
			System.out.println(today);
			break;
		case 3:
			System.out.println("Splitting and storing a string:");
			String str = "I am learning Core Java";
			String[] splitString = str.split(" ");
			for(String x:splitString) {
				System.out.println(x);
			}
			break;
		}//end switch
	}//end switchCase
}//end Q14
