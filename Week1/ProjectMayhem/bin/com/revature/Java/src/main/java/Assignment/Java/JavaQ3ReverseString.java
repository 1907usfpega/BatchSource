package Assignment.Java;

public class JavaQ3ReverseString {
	public static void main(String[] args) {
	String reverseString = "Go Revature!";
	int len = reverseString.length();{
	for (int i= (len-1); i >= 0; --i)
		reverseString += reverseString.charAt(i);
	reverseString = reverseString.substring(len);
	System.out.println(reverseString);
	
}
}
}