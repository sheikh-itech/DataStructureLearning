package hari_krishna.oop;

/**
 * 
 * We Can Not Instantiate Abstract Class, it leads CE
 * 
 * ==> But We Can Run Abstract Class Without Creating Object
 * 
 * Class should be declared Abstract, if it has Abstract Method
 * Call methods of Abstract class from its Subclass
 *
 */
public abstract class AbstractClassExecution {

	abstract void m1();
	protected abstract void m2();
	public abstract void m3();
	
	// Abstract method can not have static modifiers
	//abstract static void m4();
	
	static void m5() {
		
		System.out.println("m2 method");
	}
	public static void main(String[] args) {
		
		m5();
		
		// Cannot instantiate the type AbstractClassExecution
		//AbstractClassExecution a = new AbstractClassExecution();
	}

}
