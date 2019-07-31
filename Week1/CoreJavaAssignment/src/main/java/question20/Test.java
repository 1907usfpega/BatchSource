/**
 * 
 */
package question20;

import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String path = "src/main/resources/Data.txt";
		File file = new File(path);
		FileStream stream = new FileStream();
		try {
			stream.readFile(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
