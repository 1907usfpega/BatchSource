package core;

public class Eighteen extends Ques18 {

	@Override
	public boolean checkUppercase(String s) {
		char[] alpha = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(char a: alpha) {
			for(char b: s.toCharArray()) {
				if(a==b) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String convertToUppercase(String s) {
		return s.toUpperCase();
	}

	@Override
	public void convertToInteger(String s) {
		System.out.println(Integer.parseInt(s)+10);
	}
	
}
