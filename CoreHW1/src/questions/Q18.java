package questions;

public class Q18 extends Q18Super {

	@Override
	public boolean hasUpperCase(String str) {
		return str.toLowerCase() != str;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void convertInt(String str) {
		try {
			int i = Integer.parseInt(str) + 10;
			System.out.println(i);
		} catch (NumberFormatException e) {
			System.out.println("You gotta give me a number.");
		}
	}

}
