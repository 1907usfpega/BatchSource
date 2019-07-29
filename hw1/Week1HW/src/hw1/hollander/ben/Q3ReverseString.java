package hw1.hollander.ben;

public class Q3ReverseString {
	public static String q3(String s) {
		int n = s.length()-1;
		int i = n;
		while (i >= 0) {
			s += s.charAt(i); //append char to the end of the string
			i -= 1;
		}
		System.out.println(s.substring(n+1)); //print reversed string
		return s.substring(n+1);
	}

}
//COMPLETED