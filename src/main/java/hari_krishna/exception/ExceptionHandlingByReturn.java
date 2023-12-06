package hari_krishna.exception;

public class ExceptionHandlingByReturn {

	/**
	 * The output with return value; and return changes 
	 * the order of execution when returned from finally block
	 * 
	 */
	public static void main(String[] args) {

		System.out.println(exceptionCheck());
		
		voidExceptionCheck();
	}

	/**
	 * @return value instead of error
	 */
	@SuppressWarnings("finally")
	private static int exceptionCheck() {

		try {
			
			System.out.println(10/0);
			
		} finally {
			
			System.err.println("1. Returning from final block to override exception value");
			return 15;
		}
		//return 15;
	}
	
	@SuppressWarnings("finally")
	private static void voidExceptionCheck() {

		try {
			
			System.out.println(10/0);
			
		} finally {
			
			System.err.println("2. Returning from final block to override exception value");
			return;
		}
		//return;
	}

}
