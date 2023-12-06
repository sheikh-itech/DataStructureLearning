package hari_krishna.oops;

/** 		First Inherit, then Implement
 * 		-----------------------------------------
 * 
 * If there is already implemented logic in any class (by chance),
 * So logically we must Inherit it instead of Implementing
 * 
 * That’s Why →  C implements B extends A { }   Not Allowed
 */

public class Scenario3 {

	public static void main(String[] args) {

	}
}

interface I6 {
	
	void m1();
}

class A6 {
	
	void m1() {
		
	}
}

/*class B6 implements I6 extends A6 {
	
	@Override
	public void m1() {
		
	}
}*/