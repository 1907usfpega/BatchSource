package questions;

public class Q5 {
	public static String substring(String str, int idx) {
		char[] chars = new char[idx];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = str.charAt(i);
		}
		String s = new String(chars);
		
		return s;
	}

}
