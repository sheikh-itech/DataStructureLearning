package ds.hk.oop;

/**
 * An Interface have below elements :-
 * 
 * 1. Variables -> public static final variables only
 * 
 * 2. Abstract methods -> Method don't have body, 
 * 						  No need to mention abstract keyword explicitly
 * 
 * 3. Static methods -> To define common operation for all implementing classes
 * 					 -> Called in static way using Interface/Subclass name
 * 
 * 4. Default methods -> To add new functionality without forcing old 
 * 						 implementation classes to re-write new logic
 * 					  -> Can be called only through Subclass
 * 
 * Note: Any Interface cannot define an initializer -> static and non-static block
 */

public class InterfaceExample {

	public static void main(String[] args) {

		A4.m3();
		
		Test1 t = new Test1();
		t.m4();	//Default method call
	}
}

class Test1 implements A4 {

	@Override
	public void m1() {
		
	}
	@Override
	public void m2() {

	}
}
interface A4 {
	
	//The blank final field num may not have been initialized
	//int NUM;
	
	int NUM = 10;
	
	/*static {
		
	}*/
	
	void m1();	//By default method is Abstract and Public
	abstract void m2();	//By default Public
	
	static void m3() {
		System.out.println("Static method of Interface");
	}
	
	default void m4() {
		System.out.println("Default method of Interface");
	}
}