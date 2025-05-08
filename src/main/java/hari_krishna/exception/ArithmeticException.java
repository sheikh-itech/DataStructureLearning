package hari_krishna.exception;

public class ArithmeticException {

	public static void main(String[] args) {

		int a = 30;
		int b = 40;
		int c = 10;
		try {
			int expression = (a * b) / (a - b + c);	// a - b + c => will become zero
			System.out.println("Result: " + expression);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		
		try {
		    throw new Error("Critical");
		} catch (Exception e) {
		    System.out.println("Caught");
		} finally {
		    System.out.println("Finally");
		}	// Ans --> Finally, java.lang.Error: Critical
	}
}
