package hari_krishna.exception;

/*	If a constructor throws an exception, object creation is aborted, 
 * 	and the object is not instantiated, but static members will initialized	*/

public class ExceptionInObjectCreation {

	public static void main(String[] args) {

		try {
			
			Test.method2();
			
			Test t = new Test();
			t.method1();
			
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}

class Test {
	
	private int a = 10;
	private static int b = 10;
	
	public Test() {
		System.out.println(5/0);
	}
	
	void method1() {
		System.out.println(a);
	}
	
	static void method2() {
		System.out.println(b);
	}
}