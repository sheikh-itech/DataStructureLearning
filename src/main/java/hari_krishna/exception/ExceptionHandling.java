package hari_krishna.exception;

public class ExceptionHandling {

	public static void main(String[] args) throws Exception {
		
		startLevel();
		advanceLevel();
		advanceLevel_1();
	}

	static void startLevel() throws Exception {
			
		// try-catch
		try {
			System.out.println("Inside try");
		} catch(Exception ex) {
			System.out.println("Inside catch");
		}
		System.out.println("After First try-catch");
		
		// try-finally
		try {
			System.out.println("Inside try");
		} finally {
			System.out.println("Inside finally");
		}
		System.out.println("After Second try-finally");
		
		// try-catch-finally
		try {
			System.out.println("Inside try");
			System.out.println(10/0);
		} catch(Exception ex) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Inside finally");
		}
		System.out.println("After Third try-catch-finally");
		
		// try-catch-finally
		try {
			System.out.println("Inside try");
			System.out.println(10/0);
		} catch(IndexOutOfBoundsException ex) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Finally executed even catch not matched");
		}
		
		//Syntax error on token "catch", ( expected
		//try {	} finally {	} catch(Exception e) {	}
		
		//Syntax error, insert "Finally" to complete BlockStatements
		//try {	}
	}
	
	static int advanceLevel() {
		
		try {
			
			return 0;
		} catch(Exception ex) {
			
			return 0;
		} finally {
			
			return 0;
		}
	}
	
	static int advanceLevel_1() {
		
		try {
			
			return 0;
		} catch(Exception ex) {
			
			return 0;
		} finally {
			
		}
		//Unreachable code
		//return 0;
	}
}
