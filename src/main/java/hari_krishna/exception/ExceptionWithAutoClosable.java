package hari_krishna.exception;

public class ExceptionWithAutoClosable {

	/*	The primary exception is thrown, and the exception in close() is suppressed
	 * 	since Java 7 try-with-resources introduced this feature
	 * 	(can be accessed using getSuppressed())	*/
	
	
	public static void main(String[] args) throws Exception {

		try (MyAutoCloseable r = new MyAutoCloseable()) {
			
            throw new Exception("Primary");
        }
	}
}

class MyAutoCloseable implements AutoCloseable {
    public void close() {
        throw new RuntimeException("Suppressed");
    }
}