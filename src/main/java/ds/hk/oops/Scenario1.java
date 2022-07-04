package ds.hk.oops;

/**
 *	Class extending another class and implementing interface both having same method name
 *	Both Super Class and Interface => Same Method Name
 */
public class Scenario1 {

	public static void main(String[] args) {

		A4 a = new A4();
		a.m1();
		
		a = new B4();
		a.m1();
	}
}

interface I {
	
	void m1();
}

class A4 {
	
	void m1() {
		
		System.out.println("Method from A4");
	}
}

class B4 extends A4 implements I {
	
	@Override
	public void m1() {
		
		System.out.println("Overriden Method from B4");
	}
}