package hari_krishna.oop;


/**
 * In Inheritance always super class loaded first and
 * All its SB, NSB and variable execute from super to sub-class
 * 
 * Super class identified and loaded using 'extends' keyword
 */

public class ClassLoadinginInheritance extends B {

	static {
		System.out.println("ClassLoadinginInheritance class loaded");
	}

	public static void main(String[] args) {

		ClassLoadinginInheritance o = new ClassLoadinginInheritance();

	}

}

//Grand Super class
class A {
	
	/*public A(int a) {
		
	}*/
	static {
		System.out.println("A class loaded");
	}
	
	{
		System.out.println("NSB::A class");
	}
}

//Super class
class B extends A {
	
	//Implicit super constructor A() is undefined for default constructor.
	//Must define an explicit constructor
	
	static {
		System.out.println("B class loaded");
	}
	
	{
		System.out.println("NSB::B class");
	}
}
