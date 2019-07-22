package core;

public class Five {
	public String subString(String str, int idx) {
		String s="";
		for(int x=0;x<idx;x++) {
			s=s+str.charAt(x);
		}
		System.out.println(s);
		return s;
	} 
}
