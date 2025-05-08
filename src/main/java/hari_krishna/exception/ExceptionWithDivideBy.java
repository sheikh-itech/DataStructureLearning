package hari_krishna.exception;

public class ExceptionWithDivideBy {

	public static void main(String[] args) {

		try {
			System.out.println(5/0);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());	//	/ by zero
		}
		
		try {
			System.out.println(7.0/0);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());	//	Infinity
		}
	}
}
