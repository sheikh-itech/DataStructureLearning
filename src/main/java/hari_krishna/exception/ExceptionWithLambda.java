package hari_krishna.exception;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExceptionWithLambda {

	public static void main(String[] args) {

		ExceptionLambda lambda = () -> {
		    throw new IOException("Checked but handled cleanly");
		};
		
		try {
			lambda.test();
			lambda1();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	static void lambda1() {
		
		List<Integer> list = Arrays.asList(2,3,5,10,20);
		
		list.forEach(i -> {
		    if (i < 0) {
		        throw new IllegalArgumentException("Negative numbers are not allowed.");
		    }
		    System.out.println(i);
		});
	}
	
	// Can throw Runtime/Unchecked Exceptions
	public static void foobar() throws NullPointerException {
		
	}
}

@FunctionalInterface
interface ExceptionLambda {
    void test() throws Exception;
}