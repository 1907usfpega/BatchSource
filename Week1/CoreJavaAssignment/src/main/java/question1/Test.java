/**
 * 
 */
package question1;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//instantiates an new bubble sort object 
		//and provides the array to be sorted
		//sorts it then prints it
		BubbleSort a = new BubbleSort();
		int [] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		arr = a.sort(arr);
		System.out.println("Final Product: ");
		a.printArray(arr);
	}

}
