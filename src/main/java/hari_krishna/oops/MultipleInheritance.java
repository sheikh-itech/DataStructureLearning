package hari_krishna.oops;

/**			Multiple Inheritance
 * 		-----------------------------
 * 
 * It is not Inheritance, because if we implement multiple interfaces
 * Or extend multiple interface, then we are just enhancing our area of contract
 * 
 * It is not we are creating Any Object Here, just accessing contract of interface
 */

public class MultipleInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

interface A1 {
	
}

interface B1 {
	
}

interface C1 extends A1, B1 {
	
}

class D1 implements A1, B1 {
	
}

class A2 {
	
}

class B2 {
	
}

//Multiple Inheritance not possible 

/*class C2 extends A2, B2 {
	
}*/