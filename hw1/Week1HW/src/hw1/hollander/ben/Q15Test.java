package hw1.hollander.ben;

public class Q15Test {
	public static void main(String[] args) {
		Q15 q15 = new Q15();
		double sum = q15.add(1, 2, 3);
		double diff = q15.subtract(1, 2, 3);
		double product = q15.multiply(1, 3, 4);
		double quotient = q15.divide(1, 2);
		System.out.println(sum);
		System.out.println(diff);
		System.out.println(product);
		System.out.println(quotient);
	}
}
