package hw1.hollander.ben;

public class Q5Substring {
	public static String q5(String str, int idx) {
		// Should implement a check to make sure idx < str.length
		String r = ""; //String to return
		for (int i = 0; i<=idx-1; i++) { //i<=idx to make it inclusive
			r += str.charAt(i);
		}
		return r;
	}

}
//COMPLETED