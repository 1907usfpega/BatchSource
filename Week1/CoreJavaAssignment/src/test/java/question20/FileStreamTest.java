/**
 * 
 */
package question20;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class FileStreamTest {

	final String path = "src/main/resources/Data.txt";
	File file = new File(path);
	FileStream stream = new FileStream();
	/**
	 * Test method for {@link question20.FileStreamTest#readFile(java.io.File)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	void testReadFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String expected = "Mickey Mouse";
		
		String line = scanner.nextLine();
		String[] arrOfStr = line.split(":");
		String name = arrOfStr[0] + " " + arrOfStr[1];
		
		assertEquals(expected, name);
	}

}
