/**
 * 
 */
package question16;


/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountCharacters cha = new CountCharacters();
		//String [] arg = {"Deonta"};
		//checks each separate string in the command line arguments returns the length ofthe string
		for (int i = 0; i < args.length; i++) {
			System.out.println(cha.count(args[i]));
		}

	}

}
