/**
 * 
 */
package question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Deonta Kilpatrick
 *
 */
public class FileStream {
	
	//reads the file by each line
	//splits current line by the : and using the created array of strings we can easily create the expected output
	public void readFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] arrOfStr = line.split(":");
			String name = arrOfStr[0] + " " + arrOfStr[1];
			System.out.println("Name: " + name);
			String age = arrOfStr[2];
			System.out.println("Age: " + age + " years");
			String state = arrOfStr[3];
			System.out.println("State: " + state + " State\n");
		}
	}
}
