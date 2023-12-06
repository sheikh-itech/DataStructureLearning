package hari_krishna.oop;

/**
 * 
 * When a method overloaded with siblings and 
 * if passed argument matched with both parameter compiler throws
 * CE::Ambiguous Error
 *
 */
public class SiblingOverloading {

	public static final void main(String[] args) {

		B3 b = new B3();	
		C3 c = new C3();
		
		D d = new D();
		d.m1(b);
		d.m1(c);
		
		//The method m1(B3) is ambiguous for the type D
		//d.m1(null);
	}
}

class D {
	
	void m1(B3 a) {
		System.out.println("m1 of B3");
	}
	
	void m1(C3 a) {
		System.out.println("m1 of C3");
	}
}

class A3 {
	
}

class B3 extends A3 {
	
}

class C3 extends A3 {
	
}