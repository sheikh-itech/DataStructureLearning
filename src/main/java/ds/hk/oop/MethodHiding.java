package ds.hk.oop;

/**
 * 
 * Redefining super class static method in sub-class is called Method Hiding 
 *
 */

public class MethodHiding extends Sub {


	public static void main(String[] args) {

		Child mh = null;
		mh.printMethod();
		Super.printMethod();
		Sub.printMethod();
		
		//Overriding check
		System.out.println("\nChecking Overriding with Static Method\n");
		
		Super a = new Super();
		System.out.print("Super a = new Super();:: ");
		a.printMethod();
		
		Super b = new Sub();
		System.out.print("Super b = new Sub();:: ");
		b.printMethod();
		
		Super c = new Child();
		System.out.print("Super c = new Child();:: ");
		c.printMethod();
	}
}

class Super {
	
	static void printMethod() {
		System.out.println("Super class static method");
	}
}

class Sub extends Super {
	
	static void printMethod() {
		System.out.println("Sub class static method");
	}
}

class Child extends Sub {
	
	static void printMethod() {
		System.out.println("Child class static method");
	}
}

