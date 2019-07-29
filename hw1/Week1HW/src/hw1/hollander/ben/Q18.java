package hw1.hollander.ben;

public class Q18 extends Q18Super {
	
	public Q18() {
		super(); //Constructor
	}

	@Override
	public boolean hasUppercase(String str) {
		//REGEX would be overkill
		char [] arr = str.toCharArray(); //get a char array so we can use is uppercase
		for(char c: arr) {
			if (Character.isUpperCase(c)) {
				System.out.println(true);
				return true;
			}
		}
		System.out.println(false);
		return false;
	}

	@Override
	public String toUppercase(String str) {
		System.out.println(str.toUpperCase());
		return str.toUpperCase();
	}

	@Override
	public int parseInt(String str) {
		int n = Integer.parseInt(str);
		System.out.println(n+10);
		return n+10;
	}

}
