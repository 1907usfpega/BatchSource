/**
 * 
 */
package question14;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Deonta Kilpatrick
 *
 */
public class SwitchStatements {

	public void trySwitch(int java) {
		switch(java) {
		case 1: 
			//uses math.sqrt to obtain the square root of a specific number
			int num = 144;
			System.out.println("The square root of " + num+
					" is " + Math.sqrt(num));
			break;
		case 2:
			//uses currentTimeMillis to get current time and a formatter to make it readable for the user
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			System.out.println("Today is " + formatter.format(date));
			break;
		case 3:
			//splits the string by its spaces 
			String str = "I am learning Core Java";
			String [] arrOfStr = str.split(" ");
			for(String a: arrOfStr) {
				System.out.println(a);
			}
			break;
		default:
			System.out.println("You Suck.....");
		}
	}
}
