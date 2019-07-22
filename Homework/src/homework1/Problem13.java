package homework1;

public class Problem13 {

	public static String triangle() {
		
		//Creates a counter and empty String for the triangle
		int counter = -1;
		String output = "";
		
		//Creates the beginning of the output
		System.out.print("Q13.) Triangle /\\");
		
		//The first for loop determines the row of the output
		for (int i = 0; i <= 4; i++){
			
			//The second for loop determines what gets printed each time
			//Will switch between 0 and 1 respectively
			for (int j = 0; j < i; j++){ 
				if (counter % 2 == 0) {
					output += "1 ";
					System.out.print("1 ");
				}
				else {
					output += "0 ";
					System.out.print("0 ");
				}
				counter++;
			}
			System.out.println();
			output += "\n";
		}
		
		//Returns output to the user
		return output;

	}//end triangle()

}//end Problem13 class
