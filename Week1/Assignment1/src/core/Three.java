package core;

public class Three {
	public String reverseString(String s) {
		int x=s.length();
		for (int i = s.length()-1; i >=0; i--) {
			s=s+s.charAt(i);
		}
		s=s.substring(x);
		System.out.println(s);
		return s;
	}

	
}
