/**
 * 
 */
package question5;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindSubstring find =new FindSubstring();
		String str = "Deonta";
		int idx = 4;
		try {
			System.out.println(find.subString(str, idx));
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
