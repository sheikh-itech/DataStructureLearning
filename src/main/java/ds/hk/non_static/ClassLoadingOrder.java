package ds.hk.non_static;

import ds.hk.non_static.B;

/**
 * 
 * Class loaded once their Object Created OR Any Static Member called
 * [If not loading directly (Called from other class)]
 * 
 * Import statement does not load class 
 *
 */
public class ClassLoadingOrder {

	static {
		System.out.println("ClassLoadingOrder class loaded");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/**
		 * JVM do not loads class when it's null referenced variable created
		 * JVM only loads class when
		 * 	1. It is called using java command
		 *  2. Or it's Object created OR Static member called
		 *  
		 */
		
		B bb = null;
		
		A a = new A();
		B b = new B();

	}

}


class A {
	
	static {
		System.out.println("A class loaded");
	}
}

class B {
	
	static {
		System.out.println("B class loaded");
	}
}