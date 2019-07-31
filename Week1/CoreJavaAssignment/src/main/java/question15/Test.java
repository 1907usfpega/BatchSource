/**
 * 
 */
package question15;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Operands op = new Operands();
		int a,b;
		a = 5;
		b = 3;
		System.out.print(op.addition(a, b) + " = ");
		System.out.println(a+ " + " + b + " = " + (a+b));
		System.out.print(op.subtraction(a, b)+ " = ");
		System.out.println(a+ " - " + b + " = " + (a-b));
		System.out.print(op.multiplication(a, b) + " = ");
		System.out.println(a+ " * " + b + " = " + (a*b));
		System.out.print(op.division(a, b)+ " = ");
		System.out.println(a+ " / " + b + " = " + (a/b));

	}

}
