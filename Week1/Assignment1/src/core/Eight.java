package core;
import java.util.ArrayList;

public class Eight {

	public void printPalindrome() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("karan");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("jimmy");
		a.add("kayak");
		a.add("john");
		a.add("billy");
		a.add("refer");
		a.add("did");
		ArrayList<String> b = new ArrayList<String>();
		for(String l:a) {
			if(isPalindrome(l)) {
				b.add(l);
				System.out.println(l);
			}
		}
		}
	
	public boolean isPalindrome(String s) {
		String s1="";
		for (int i = s.length()-1; i >=0; i--) {
			s1=s1+s.charAt(i);
		}
		if(s.equals(s1)){return true;}
		else {return false;}
	}
	}
	
	

