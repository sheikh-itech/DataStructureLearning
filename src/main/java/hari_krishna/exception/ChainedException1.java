package hari_krishna.exception;

public class ChainedException1 {

	public static void main(String[] args) {

		try {
            Throwable t = new Exception("Root");
            throw new Exception("Wrapper", t);
        } catch (Exception e) {
            System.err.println(e.getCause().getMessage());	//	Root
        }
	}
}
