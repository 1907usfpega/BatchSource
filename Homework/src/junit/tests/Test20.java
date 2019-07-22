package junit.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Test20 {

	@Test
	void test() {
		
		//Tests successfully creating and writing to a file
		try {
			FileWriter fw = new FileWriter("test.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Successfully wrote to a file from JUnit Test20.");
			bw.close();
			fw.close();
			System.out.println("Successfully wrote to a file from JUnit Test20.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}//end test()

}//end Test20
