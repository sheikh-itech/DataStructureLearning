package ds.hk.exception;

public class TryWithVariable {

	public static void main(String[] args) {


		System.out.println(initializeInTry());
		System.out.println(initializeInTryCatch());
		System.out.println(initializeInTryOneCatch());
	}

	private static int initializeInTry() {
		
		int value;
		
		try {
			
			value = 10;
			return value;
			
		} catch(Exception ex) {
			
			//The local variable value may not have been initialized
			//return value;
		}
		
		//The local variable value may not have been initialized
		
		//return value;
		return 0;
	}
	
	private static int initializeInTryCatch() {
		
		int value;
		
		try {
			
			value = 10;
			
		} catch(Exception ex) {
			value = 20;
		}
		
		return value;
	}
	
	private static int initializeInTryOneCatch() {
		
		int value;
		
		try {
			
			value = 10;
			
		} catch(NumberFormatException ex) {
			value = 20;
		} catch(Exception ex) {

		}
		//The local variable value may not have been initialized
		
		//return value;
		return 0;
	}

	
}
