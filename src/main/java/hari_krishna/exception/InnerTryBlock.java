package hari_krishna.exception;

public class InnerTryBlock {

	public static void main(String[] args) {
		
		System.out.println(innerTry());
		System.out.println(innerTryWithFinally());
		System.out.println(innerTryBothFinally());
	}

	private static int innerTry() {
		
		try {
			try {
				
				System.out.println("inner try");
				return 1;
				
			} catch(Exception ex) {
				System.out.println("Inner catch");
				return 1;
			}
			
			//Unreachable code
			//System.out.println("Outer try");
			
		} catch(Exception ex) {
			System.out.println("Outer catch");
		}

		return 0;
	}
	
	@SuppressWarnings("finally")
	private static int innerTryWithFinally() {
		
		try {	
			try {
				
				System.out.println("inner try");
				return 1;
				
			} catch(Exception ex) {
				
				System.out.println("Inner catch");
				return 1;
				
			} finally {
				
				System.out.println("inner final");
				return 1;
			}
			
			//Unreachable code
			//System.out.println("Outer try");
			
		} catch(Exception ex) {
			System.out.println("Outer catch");
		}

		return 0;
	}
	
	@SuppressWarnings("finally")
	private static int innerTryBothFinally() {
		
		try {	
			try {
				
				System.out.println("inner try");
				return 1;
				
			} catch(Exception ex) {
				
				System.out.println("Inner catch");
				return 1;
				
			} finally {
				
				System.out.println("inner final");
				return 1;
			}
			
			//Unreachable code
			//System.out.println("Outer try");
			
		} catch(Exception ex) {
			System.out.println("Outer catch");
		} finally {
			System.out.println("Outer final");
			return 1;
		}
		
		//Unreachable code
		//return 0;
	}

}
