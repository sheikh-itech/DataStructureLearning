package hari_krishna.exception;

public class NullPointerExceptionDemo {

	public static void main(String[] args) {

		try {
			Integer x = null;
			int y = x;
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		throw null;	// No need to catch, NullPointerException, print null
	}
}
