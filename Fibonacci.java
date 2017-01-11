import java.util.Scanner;

/**
 * Program Fibonacci - Java
 *  @date 12 August 2014
 *  @author Nefari0uss
 * 
 * This program will request a maximum Nth value to reach in generating the Fibonacci sequence.
 * It will display all terms generated less than or equal to the Nth term. 
 *
 * This version is iterative.
 * 
 * Formula:
 * F(n) = F(n-1) + F(n-2)
 *
 * with seed values of F(0) = 0 and F(1) = 1
 **/

public class Fibonacci {

	public Fibonacci() {}

	public static void main(String[] args) {

		int n = getInput();
		calculateSequence(n);

	} 

	private static int getInput() {

		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Generate Fibonacci sequence till until what number? (Fib terms will be less tha nthis number.)");
		String num = input.nextLine();

		// Handle input greater than Java's MAX_INT.
		try {
			n = Integer.parseInt(num);
		}
		catch (NumberFormatException e) {
			System.out.println("n is too lage. Setting n to be the largest possible int value.");
			n = Integer.MAX_VALUE;
			//System.out.println(n);
		}
		input.close();
		return n;
	}

	private static void calculateSequence (int n)  {

		int a = 0;
		int b = 1;
		int c = 1;

		System.out.println("\nF(0): " + a);
		System.out.println("F(1): " + b);
		System.out.println("F(2): " + c);        

		//System.out.println("Generating terms in the sequence.");
		int i = 3;
		a = b + c;

		// Loop until the last two terms combined are greater than n.
		while (a < n) {
			System.out.println("F(" + i + "): " + a);
			b = c;
			c = a;
			i++;

			// Handle a > MAX_INT.
			if ((long)b + c > Integer.MAX_VALUE) {
				a = Integer.MAX_VALUE;
			} else {
				a = b + c;
			}
		} // end while

		System.out.println("\nNo more terms in the sequence.");
		System.out.println("Generated " + i + " terms.");
	} 

} 
