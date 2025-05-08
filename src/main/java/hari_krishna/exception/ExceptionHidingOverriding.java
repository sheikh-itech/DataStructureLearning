package hari_krishna.exception;

public class ExceptionHidingOverriding {

	public static void main(String[] args) {

		try {
            throw new RuntimeException("Fail");
        } finally {
        	System.out.println("Hiding/Overring exception");
            return;		// Warning- finally block does not complete normally
        }
	}
}
