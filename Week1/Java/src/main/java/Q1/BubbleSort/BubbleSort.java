package Q1.BubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		
		Sorting s = new Sorting();
		int[] arr = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		s.bubbleSort(arr);
		for(int i= 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
